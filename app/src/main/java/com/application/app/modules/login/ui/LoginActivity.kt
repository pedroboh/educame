package com.application.app.modules.login.ui

import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.appcomponents.googleauth.GoogleHelper
import com.application.app.databinding.ActivityLoginBinding
import com.application.app.modules.login.`data`.viewmodel.LoginVM
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
    }

    companion object {
      const val TAG: String = "LOGIN_ACTIVITY"

    }
  }
