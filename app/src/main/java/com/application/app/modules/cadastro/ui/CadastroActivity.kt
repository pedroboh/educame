package com.application.app.modules.cadastro.ui

import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityCadastroBinding
import com.application.app.modules.cadastro.`data`.viewmodel.CadastroVM
import kotlin.String
import kotlin.Unit

class CadastroActivity : BaseActivity<ActivityCadastroBinding>(R.layout.activity_cadastro) {
  private val viewModel: CadastroVM by viewModels<CadastroVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.cadastroVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "CADASTRO_ACTIVITY"

  }
}
