package com.application.app.modules.agenda.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.agenda.`data`.model.AgendaModel
import org.koin.core.KoinComponent

class AgendaVM : ViewModel(), KoinComponent {
  val agendaModel: MutableLiveData<AgendaModel> = MutableLiveData(AgendaModel())

  var navArguments: Bundle? = null
}
