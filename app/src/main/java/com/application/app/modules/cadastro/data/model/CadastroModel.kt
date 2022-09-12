package com.application.app.modules.cadastro.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class CadastroModel(
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
  var txtEnviamosumema: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enviamos_um_ema)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtVOLTAR: String? = MyApp.getInstance().resources.getString(R.string.lbl_voltar2)

)
