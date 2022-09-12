package com.application.app.modules.matrias.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.matrias.`data`.model.MatRiasModel
import org.koin.core.KoinComponent

class MatRiasVM : ViewModel(), KoinComponent {
  val matRiasModel: MutableLiveData<MatRiasModel> = MutableLiveData(MatRiasModel())

  var navArguments: Bundle? = null
}
