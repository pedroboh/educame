package com.application.app.modules.cadastroone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.cadastroone.`data`.model.CadastroOneModel
import org.koin.core.KoinComponent

class CadastroOneVM : ViewModel(), KoinComponent {
  val cadastroOneModel: MutableLiveData<CadastroOneModel> = MutableLiveData(CadastroOneModel())

  var navArguments: Bundle? = null
}
