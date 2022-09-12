package com.application.app.modules.agenda.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class AgendaModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWeburl: String? = MyApp.getInstance().resources.getString(R.string.lbl_educa_me)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSrgio: String? = MyApp.getInstance().resources.getString(R.string.lbl_s_rgio)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFive: String? = MyApp.getInstance().resources.getString(R.string.lbl_05)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFour: String? = MyApp.getInstance().resources.getString(R.string.lbl2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSeven: String? = MyApp.getInstance().resources.getString(R.string.lbl_07)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSix: String? = MyApp.getInstance().resources.getString(R.string.lbl2)
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
  var txtEight: String? = MyApp.getInstance().resources.getString(R.string.lbl3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtZero: String? = MyApp.getInstance().resources.getString(R.string.lbl_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSrgioOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_s_rgio)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupTen: String? = MyApp.getInstance().resources.getString(R.string.lbl_aula_ao_vivo)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAgenda: String? = MyApp.getInstance().resources.getString(R.string.lbl_agenda)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etBotoVoltarValue: String? = null
)
