package com.application.app.modules.professores.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowProfessoresBinding
import com.application.app.infrastructure.SessionManager
import com.application.app.infrastructure.network.MateriasApi
import com.application.app.modules.professores.`data`.model.ProfessoresRowModel
import com.lastcode.educame.infrastructure.network.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.Int
import kotlin.collections.List

class ProfessoresAdapter(
  var list: List<ProfessoresRowModel>,
  var context: Context
) : RecyclerView.Adapter<ProfessoresAdapter.RowProfessoresVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowProfessoresVH {
//    carregarDados()
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_professores,parent,false)
    return RowProfessoresVH(view)
  }

  override fun onBindViewHolder(holder: RowProfessoresVH, position: Int) {
//    val professoresRowModel = ProfessoresRowModel(txtNomeProfessor = "Teste", txtIdProfessor = "teste", txtEmailProfessor = "teste")
    // TODO uncomment following line after integration with data source

     val professoresRowModel = list[position]
    holder.binding.professoresRowModel = professoresRowModel
  }

  override fun getItemCount(): Int{
  // TODO uncomment following line after integration with data source
   return list.size}

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

  private fun makeToast(message : String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
  }

  private fun carregarDados(){
    CoroutineScope(Dispatchers.IO).launch() {
      try {
        val sessionManager = SessionManager(context)
        var token = sessionManager.fetchAuthToken()
        val result = RetrofitHelper.getInstance().create(MateriasApi::class.java).getProfessores(token, "5372477c-c4c6-4b0c-adb9-9e2975193598")
        val professores = result.professores
        Log.i("EVENTO_API","retornoApi: Success: ${professores.size} registros recuperados")

        var listaProfessores = mutableListOf<ProfessoresRowModel>()
        professores.forEach {
          val professor = ProfessoresRowModel(txtEmailProfessor = it.email, txtIdProfessor = it.id, txtNomeProfessor = it.nome)
          listaProfessores.add(professor)

          Log.i("EVENTO_API","adicionado um professor")
        }


                withContext(Dispatchers.Main){
                    updateData(listaProfessores)
                }
      }catch (e: Exception){
        Log.i("EVENTO_API","retornoApi2:  + ${e.message}")

      }
    }
//     return emptyList()
  }

  inner class RowProfessoresVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowProfessoresBinding = RowProfessoresBinding.bind(itemView)
  }
}
