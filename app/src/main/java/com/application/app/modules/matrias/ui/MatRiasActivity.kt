package com.application.app.modules.matrias.ui

import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityMatRiasBinding
import com.application.app.modules.matrias.`data`.viewmodel.MatRiasVM
import com.application.app.modules.professores.ui.ProfessoresActivity
import kotlin.String
import kotlin.Unit

class MatRiasActivity : BaseActivity<ActivityMatRiasBinding>(R.layout.activity_mat_rias) {
  private val viewModel: MatRiasVM by viewModels<MatRiasVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.matRiasVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearRowmatemtica.setOnClickListener {
      val destIntent = ProfessoresActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "MAT_RIAS_ACTIVITY"

  }
}
