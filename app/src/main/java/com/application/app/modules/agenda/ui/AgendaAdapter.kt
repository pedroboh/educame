package com.application.app.modules.agenda.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowAgendaBinding
import com.application.app.databinding.RowProfessoresBinding
import com.application.app.dto.AgendaAlunoModel
import com.application.app.dto.ProfessorMarcarLiveModel
import com.application.app.modules.professores.data.model.ProfessoresRowModel
import com.application.app.modules.professores.ui.ProfessoresAdapter


class AgendaAdapter (
    var list: List<AgendaAlunoModel>,
    var context: Context
        ):RecyclerView.Adapter<AgendaAdapter.RowAgendaVH>(){
    private lateinit var clickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendaAdapter.RowAgendaVH {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_agenda, parent, false)
        return RowAgendaVH(view)
    }

    override fun onBindViewHolder(holder: AgendaAdapter.RowAgendaVH, position: Int) {

        val agendaAlunoModel = list[position]
        holder.binding.agendaAlunoModel = agendaAlunoModel
    }

    override fun getItemCount(): Int {
        // TODO uncomment following line after integration with data source
        return list.size
    }

    public fun updateData(newData: List<AgendaAlunoModel>) {
        list = newData
        Log.i("EVENTO_API", "log3")
        notifyDataSetChanged()
        Log.i("EVENTO_API", "log4")
    }

    fun setOnItemClickListener(clickListener: AgendaAdapter.OnItemClickListener) {
        this.clickListener = clickListener
    }

    interface OnItemClickListener {
        fun onItemClick(
            view: View,
            position: Int,
            item: AgendaAlunoModel
        )
    }

    inner class RowAgendaVH(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val binding: RowAgendaBinding = RowAgendaBinding.bind(itemView)

//        init {
//            binding.txtNomeProfessor.setOnClickListener {
//                Log.i("EVENTO_API", "CLICKADO")
//                Log.i("EVENTO_API", binding.txtIdProfessor.text.toString())
//
//                if (binding.linearInfo.visibility == View.VISIBLE) {
//                    binding.linearInfo.visibility = View.GONE
//                } else {
//                    binding.linearInfo.visibility = View.VISIBLE
//                }
//            }
//            binding.btnAgendarAula.setOnClickListener {
//
//                val nomeProfessor = binding.txtNomeProfessor.text.toString()
//                val emailProfessor = binding.txtEmailProfessor.text.toString()
//                val idProfessor = binding.txtIdProfessor.text.toString()
//                val professor = ProfessorMarcarLiveModel(id = idProfessor, nome = nomeProfessor, email = emailProfessor)
//                val nomeLive = binding.etNomeAula.text.toString()
//                agendarLive(professor,nomeLive)
//
//
//
//
//            }
//        }
    }
}