package com.application.app.modules.professores.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowProfessoresBinding
import com.application.app.dto.LiveMarcarModel
import com.application.app.dto.ProfessorMarcarLiveModel
import com.application.app.infrastructure.SessionManager
import com.application.app.modules.professores.`data`.model.ProfessoresRowModel
import com.lastcode.educame.infrastructure.network.AlunoApi
import com.lastcode.educame.infrastructure.network.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.Int
import kotlin.collections.List

class ProfessoresAdapter(
    var list: List<ProfessoresRowModel>,
    var context: Context
) : RecyclerView.Adapter<ProfessoresAdapter.RowProfessoresVH>() {
    private lateinit var clickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowProfessoresVH {
//    carregarDados()
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_professores, parent, false)
        return RowProfessoresVH(view)
    }

    override fun onBindViewHolder(holder: RowProfessoresVH, position: Int) {
//    val professoresRowModel = ProfessoresRowModel(txtNomeProfessor = "Teste", txtIdProfessor = "teste", txtEmailProfessor = "teste")
        // TODO uncomment following line after integration with data source

        val professoresRowModel = list[position]
        holder.binding.professoresRowModel = professoresRowModel
    }

    override fun getItemCount(): Int {
        // TODO uncomment following line after integration with data source
        return list.size
    }

    public fun updateData(newData: List<ProfessoresRowModel>) {
        list = newData
        Log.i("EVENTO_API", "log3")
        notifyDataSetChanged()
        Log.i("EVENTO_API", "log4")
    }

    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        this.clickListener = clickListener
    }

    interface OnItemClickListener {
        fun onItemClick(
            view: View,
            position: Int,
            item: ProfessoresRowModel
        )
    }

//  private fun makeToast(message : String){
//    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
//  }
//
//  private fun carregarDados(){
//    CoroutineScope(Dispatchers.IO).launch() {
//      try {
//        val sessionManager = SessionManager(context)
//        var token = sessionManager.fetchAuthToken()
//        val result = RetrofitHelper.getInstance().create(MateriasApi::class.java).getProfessores(token, "5372477c-c4c6-4b0c-adb9-9e2975193598")
//        val professores = result.professores
//        Log.i("EVENTO_API","retornoApi: Success: ${professores.size} registros recuperados")
//
//        var listaProfessores = mutableListOf<ProfessoresRowModel>()
//        professores.forEach {
//          val professor = ProfessoresRowModel(txtEmailProfessor = it.email, txtIdProfessor = it.id, txtNomeProfessor = it.nome)
//          listaProfessores.add(professor)
//
//          Log.i("EVENTO_API","adicionado um professor")
//        }
//
//
//                withContext(Dispatchers.Main){
//                    updateData(listaProfessores)
//                }
//      }catch (e: Exception){
//        Log.i("EVENTO_API","retornoApi2:  + ${e.message}")
//
//      }
//    }
////     return emptyList()
//  }

    inner class RowProfessoresVH(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val binding: RowProfessoresBinding = RowProfessoresBinding.bind(itemView)

        init {
            view.setOnClickListener {
                Log.i("EVENTO_API", "CLICKADO")
                Log.i("EVENTO_API", binding.txtIdProfessor.text.toString())

                if (binding.linearInfo.visibility == View.VISIBLE) {
                    binding.linearInfo.visibility = View.GONE
                } else {
                    binding.linearInfo.visibility = View.VISIBLE
                }
            }
            binding.btnAgendarAula.setOnClickListener {

                val nomeProfessor = binding.txtNomeProfessor.text.toString()
                val emailProfessor = binding.txtEmailProfessor.text.toString()
                val idProfessor = binding.txtIdProfessor.text.toString()
                val professor = ProfessorMarcarLiveModel(id = idProfessor, nome = nomeProfessor, email = emailProfessor)
                agendarLive(professor)



            }
        }
    }

    private fun registrarLive(data:Date, professor: ProfessorMarcarLiveModel){
        val coroutineScope = CoroutineScope(Dispatchers.IO)

        coroutineScope.launch {
            try {
                withContext(Dispatchers.Main) {
                    val professorAgenda = professor
                    val sessionManager = SessionManager(context)

                    val live = LiveMarcarModel(
                        data = data,
                        nome = "placeholder+ ${professor}",
                        link = "placeholder",
                        professor = professorAgenda
                    )
                    val result = RetrofitHelper.getInstance().create(AlunoApi::class.java)
                        .agendarLive(
                            sessionManager.fetchAuthToken(),
                            sessionManager.fetchID(),
                            live
                        )
                    Log.i("EVENTO_API", result.id)
                }
            } catch (e: Exception) {
                Log.i("EVENTO_API", "deu zebra")


            }
        }
    }

    private fun agendarLive(professor: ProfessorMarcarLiveModel): Calendar {
        val currentDateTime = Calendar.getInstance()
        val startYear = currentDateTime.get(Calendar.YEAR)
        val startMonth = currentDateTime.get(Calendar.MONTH)
        val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)
        val startHour = currentDateTime.get(Calendar.HOUR_OF_DAY)
        val startMinute = currentDateTime.get(Calendar.MINUTE)
        var dataAgenda = Calendar.getInstance()
        DatePickerDialog(context, DatePickerDialog.OnDateSetListener { _, year, month, day ->
            TimePickerDialog(context, TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                val pickedDateTime = Calendar.getInstance()
                pickedDateTime.set(year, month, day, hour, minute)
//        doSomethingWith(pickedDateTime)
                dataAgenda = pickedDateTime
                Log.i("EVENTO_API", pickedDateTime.toString())
                Log.i("EVENTO_API", pickedDateTime.time.toString())
                registrarLive(dataAgenda.time,professor)


            }, startHour, startMinute, false).show()
        }, startYear, startMonth, startDay).show()
        return dataAgenda
    }

}
