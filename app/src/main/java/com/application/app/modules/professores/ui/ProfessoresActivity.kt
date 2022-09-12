package com.application.app.modules.professores.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityProfessoresBinding
import com.application.app.modules.professores.`data`.model.ProfessoresRowModel
import com.application.app.modules.professores.`data`.viewmodel.ProfessoresVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ProfessoresActivity : BaseActivity<ActivityProfessoresBinding>(R.layout.activity_professores)
    {
  private val viewModel: ProfessoresVM by viewModels<ProfessoresVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val professoresAdapter =
    ProfessoresAdapter(viewModel.professoresList.value?:mutableListOf())
    binding.recyclerProfessores.adapter = professoresAdapter
    professoresAdapter.setOnItemClickListener(
    object : ProfessoresAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ProfessoresRowModel) {
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
    when(view.id) {
    }
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
