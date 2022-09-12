package com.application.app.modules.login.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class LoginModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtALUNO: String? = MyApp.getInstance().resources.getString(R.string.lbl_aluno)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWeburl: String? = MyApp.getInstance().resources.getString(R.string.lbl_educa_me)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWeburlOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_educa_me)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEmail: String? = MyApp.getInstance().resources.getString(R.string.lbl_email)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSenha: String? = MyApp.getInstance().resources.getString(R.string.lbl_senha)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMantenhamecon: String? =
      MyApp.getInstance().resources.getString(R.string.msg_mantenha_me_con)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEsqueciminhas: String? =
      MyApp.getInstance().resources.getString(R.string.msg_esqueci_minha_s)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupTwentyFiveValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etPasswordValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupFortyThreeValue: String? = null
)
