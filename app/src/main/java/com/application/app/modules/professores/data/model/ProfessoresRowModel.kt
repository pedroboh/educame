package com.application.app.modules.professores.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class ProfessoresRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSrgio: String? = MyApp.getInstance().resources.getString(R.string.lbl_s_rgio)

)
