package com.application.app.modules.cadastroone.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class CadastroOneModel(
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
  var txtConfirmarsenha: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_confirmar_senha)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtVOLTAR: String? = MyApp.getInstance().resources.getString(R.string.lbl_voltar2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etRectangleTwoValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etRectangleThreeValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etRectangleSevenValue: String? = null
)
