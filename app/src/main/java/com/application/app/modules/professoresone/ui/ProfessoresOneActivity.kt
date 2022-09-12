package com.application.app.modules.professoresone.ui

import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityProfessoresOneBinding
import com.application.app.modules.professores.ui.ProfessoresActivity
import com.application.app.modules.professoresone.`data`.viewmodel.ProfessoresOneVM
import kotlin.String
import kotlin.Unit

class ProfessoresOneActivity :
    BaseActivity<ActivityProfessoresOneBinding>(R.layout.activity_professores_one) {
  private val viewModel: ProfessoresOneVM by viewModels<ProfessoresOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.professoresOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.etBotoVoltar.setOnClickListener {
      val destIntent = ProfessoresActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PROFESSORES_ONE_ACTIVITY"

  }
}
