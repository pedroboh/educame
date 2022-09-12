package com.application.app.modules.professoresone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.professoresone.`data`.model.ProfessoresOneModel
import org.koin.core.KoinComponent

class ProfessoresOneVM : ViewModel(), KoinComponent {
  val professoresOneModel: MutableLiveData<ProfessoresOneModel> =
      MutableLiveData(ProfessoresOneModel())

  var navArguments: Bundle? = null
}
