package com.application.app.modules.professores.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowProfessoresBinding
import com.application.app.modules.professores.`data`.model.ProfessoresRowModel
import kotlin.Int
import kotlin.collections.List

class ProfessoresAdapter(
  var list: List<ProfessoresRowModel>
) : RecyclerView.Adapter<ProfessoresAdapter.RowProfessoresVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowProfessoresVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_professores,parent,false)
    return RowProfessoresVH(view)
  }

  override fun onBindViewHolder(holder: RowProfessoresVH, position: Int) {
    val professoresRowModel = ProfessoresRowModel()
    // TODO uncomment following line after integration with data source
    // val professoresRowModel = list[position]
    holder.binding.professoresRowModel = professoresRowModel
  }

  override fun getItemCount(): Int = 3
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ProfessoresRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: ProfessoresRowModel
    ) {
    }
  }

  inner class RowProfessoresVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowProfessoresBinding = RowProfessoresBinding.bind(itemView)
  }
}
