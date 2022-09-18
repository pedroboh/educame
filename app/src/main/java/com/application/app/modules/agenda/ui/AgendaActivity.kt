package com.application.app.modules.agenda.ui

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityAgendaBinding
import com.application.app.dto.AgendaAlunoModel
import com.application.app.infrastructure.SessionManager
import com.application.app.modules.agenda.`data`.viewmodel.AgendaVM
import com.application.app.modules.matrias.ui.MatRiasActivity
import com.application.app.modules.professores.data.model.ProfessoresRowModel
import com.application.app.modules.professores.ui.ProfessoresActivity
import com.lastcode.educame.infrastructure.network.AlunoApi
import com.lastcode.educame.infrastructure.network.RetrofitHelper
import com.squareup.moshi.JsonReader
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.String
import kotlin.Unit

class AgendaActivity : BaseActivity<ActivityAgendaBinding>(R.layout.activity_agenda) {
  private val viewModel: AgendaVM by viewModels<AgendaVM>()
  private var listaAgenda = mutableListOf<AgendaAlunoModel>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")

    val agendaAdapter = AgendaAdapter(viewModel.agendaList.value ?: mutableListOf(), this@AgendaActivity)
    binding.recyclerAgenda.adapter = agendaAdapter
    agendaAdapter.setOnItemClickListener(
      object : AgendaAdapter.OnItemClickListener{
        override fun onItemClick(view: View, position: Int, item: AgendaAlunoModel) {
          TODO("Not yet implemented")
        }
      }
    )

//AQUI QUE DA O PROBLEMA
    carregarDados(agendaAdapter)

    viewModel.agendaList.observe(this){
      agendaAdapter.updateData(listaAgenda)
    }

    binding.agendaVM = viewModel
  }

  override fun onResume() {
    onInitialized()
    super.onResume()
  }

  override fun setUpClicks(): Unit {
    binding.btnMarcarAula.setOnClickListener {
      val i = Intent(this, ProfessoresActivity::class.java)
      startActivity(i)
    }
  }

  fun onClickRecyclerAgenda(
    view: View,
    position: Int,
    item: AgendaAlunoModel
  ): Unit {
    when (view.id) {
    }

  }


  private fun carregarDados(adapter: AgendaAdapter) {
    CoroutineScope(Dispatchers.IO).launch() {
      try {
        val sessionManager = SessionManager(this@AgendaActivity)
        var token = sessionManager.fetchAuthToken()
        var alunoId = sessionManager.fetchID()
        val result = RetrofitHelper.getInstance().create(AlunoApi::class.java)
          .getAgenda(token, alunoId)
        val agenda = result
        Log.i(
          "EVENTO_API",
          "retornoApi: Success: ${agenda.size} registros recuperados"
        )


        agenda.forEach {
          var dataString = it.data
          dataString += "Z"
//          "2022-09-27T01:59:12.471Z"
          val jsonReader =Rfc3339DateJsonAdapter()

          val aula = AgendaAlunoModel(

//            data = Rfc3339DateJsonAdapter().nullSafe().fromJson("{${dataString}Z}"),
            data = jsonReader.fromJsonValue(dataString),
            emailProfessor = it.emailProfessor,
            nomeProfessor = it.nomeProfessor,
            nomeLive = it.nomeLive,
            url = it.url
          )
          listaAgenda.add(aula)
//          viewModel.agendaList.value?.add((aula))
          Log.i("EVENTO_API", "adicionado um professor")
        }

        //ADICIONA VALORES PRA LISTA
        //


        viewModel.agendaList.value?.addAll(listaAgenda)
        Log.i("EVENTO_API", "log1")



        withContext(Dispatchers.Main) {


          //PROVAVELMENTE É AQUI O PROBLEMA
          adapter.updateData(listaAgenda)
          Log.i("EVENTO_API", "log2")
//                    atualizarTela()
          Log.i("EVENTO_API", "log2.2")
        }
      } catch (e: Exception) {
        Log.i("EVENTO_API", "retornoApi2:  + ${e.message}")
      }
    }

  }

  companion object {
    const val TAG: String = "AGENDA_ACTIVITY"

  }
}
