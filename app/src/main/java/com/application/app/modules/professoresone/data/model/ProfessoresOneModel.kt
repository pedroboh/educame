package com.application.app.modules.professoresone.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class ProfessoresOneModel(
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
  var txtSrgio: String? = MyApp.getInstance().resources.getString(R.string.lbl_s_rgio)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? =
      MyApp.getInstance().resources.getString(R.string.msg_professor_organ)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFive: String? = MyApp.getInstance().resources.getString(R.string.lbl_05)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOne: String? = MyApp.getInstance().resources.getString(R.string.lbl2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSeven: String? = MyApp.getInstance().resources.getString(R.string.lbl_07)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTwentyTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_22)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEighteen: String? = MyApp.getInstance().resources.getString(R.string.lbl_18)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtThree: String? = MyApp.getInstance().resources.getString(R.string.lbl3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtZero: String? = MyApp.getInstance().resources.getString(R.string.lbl_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupTwentyNine: String? = MyApp.getInstance().resources.getString(R.string.lbl_confirmar)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etBotoVoltarValue: String? = null
)
