package com.application.app.modules.professores.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityProfessoresBinding
import com.application.app.infrastructure.SessionManager
import com.application.app.infrastructure.network.MateriasApi
import com.application.app.modules.professores.`data`.model.ProfessoresRowModel
import com.application.app.modules.professores.`data`.viewmodel.ProfessoresVM
import com.lastcode.educame.infrastructure.network.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ProfessoresActivity :
    BaseActivity<ActivityProfessoresBinding>(R.layout.activity_professores) {
    private val viewModel: ProfessoresVM by viewModels<ProfessoresVM>()


    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        val professoresAdapter =
            ProfessoresAdapter(viewModel.professoresList.value ?: mutableListOf())
        binding.recyclerProfessores.adapter = professoresAdapter
        professoresAdapter.setOnItemClickListener(
            object : ProfessoresAdapter.OnItemClickListener {
                override fun onItemClick(view: View, position: Int, item: ProfessoresRowModel) {
                    onClickRecyclerProfessores(view, position, item)
                }
            }
        )
        viewModel.professoresList.observe(this) {
            professoresAdapter.updateData(it)
        }
        binding.professoresVM = viewModel
    }

    override fun setUpClicks(): Unit {
    }

    fun onClickRecyclerProfessores(
        view: View,
        position: Int,
        item: ProfessoresRowModel
    ): Unit {
        when (view.id) {
        }
    }

    private fun carregarDados(){
        CoroutineScope(Dispatchers.IO).launch() {
            try {
                val sessionManager = SessionManager(this@ProfessoresActivity)
                var token = sessionManager.fetchAuthToken()
                val result = RetrofitHelper.getInstance().create(MateriasApi::class.java).getProfessores(token, "5372477c-c4c6-4b0c-adb9-9e2975193598")
                Log.i("EVENTO_API","retornoApi: Success: ${result.size} registros recuperados")

                result.forEach { viewModel.professoresList.value?.add((it)) }

//                withContext(Dispatchers.Main){
//                    atualizarTela()
//                }
            }catch (e: Exception){
                Log.i("EVENTO_API","retornoApi2:  + ${e.message}")
            }
        }

    }

    override fun onResume() {
        carregarDados()
        super.onResume()
    }

    companion object {
        const val TAG: String = "PROFESSORES_ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, ProfessoresActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
