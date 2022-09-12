package com.application.app.modules.professores.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.professores.`data`.model.ProfessoresModel
import com.application.app.modules.professores.`data`.model.ProfessoresRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ProfessoresVM : ViewModel(), KoinComponent {
  val professoresModel: MutableLiveData<ProfessoresModel> = MutableLiveData(ProfessoresModel())

  var navArguments: Bundle? = null

  val professoresList: MutableLiveData<MutableList<ProfessoresRowModel>> =
      MutableLiveData(mutableListOf())
}
