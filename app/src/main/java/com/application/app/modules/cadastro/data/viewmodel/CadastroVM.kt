package com.application.app.modules.cadastro.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.cadastro.`data`.model.CadastroModel
import org.koin.core.KoinComponent

class CadastroVM : ViewModel(), KoinComponent {
  val cadastroModel: MutableLiveData<CadastroModel> = MutableLiveData(CadastroModel())

  var navArguments: Bundle? = null
}
