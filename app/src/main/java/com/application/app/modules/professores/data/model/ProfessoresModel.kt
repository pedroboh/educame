package com.application.app.modules.professores.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class ProfessoresModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWeburl: String? = MyApp.getInstance().resources.getString(R.string.lbl_educa_me)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMATEMTICA: String? = MyApp.getInstance().resources.getString(R.string.lbl_matem_tica)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etBotoVoltarValue: String? = null
)
