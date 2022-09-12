package com.application.app.modules.login.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.login.`data`.model.LoginModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import org.koin.core.KoinComponent

class LoginVM : ViewModel(), KoinComponent {
  val loginModel: MutableLiveData<LoginModel> = MutableLiveData(LoginModel())


  var navArguments: Bundle? = null


  lateinit var googleAuthResponse: GoogleSignInAccount
}
