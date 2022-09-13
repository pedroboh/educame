package com.application.app.modules.login.ui

import android.content.Intent
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.appcomponents.googleauth.GoogleHelper
import com.application.app.databinding.ActivityLoginBinding
import com.application.app.modules.cadastroone.ui.CadastroOneActivity
import com.application.app.modules.login.`data`.viewmodel.LoginVM
import com.application.app.modules.matrias.ui.MatRiasActivity
import kotlin.String
import kotlin.Unit

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
  private val viewModel: LoginVM by viewModels<LoginVM>()

  private lateinit var googleLogin: GoogleHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loginVM = viewModel
    googleLogin = GoogleHelper(this,
    { accountInfo ->
      },{ error -> 

      })
    }

    override fun setUpClicks(): Unit {
      binding.imageGoogle.setOnClickListener {
        googleLogin.login()
      }
      binding.tvCadastrese.setOnClickListener{
        val i = Intent(this, CadastroOneActivity::class.java)
        startActivity(i)
      }
    }

    companion object {
      const val TAG: String = "LOGIN_ACTIVITY"

    }
  }
