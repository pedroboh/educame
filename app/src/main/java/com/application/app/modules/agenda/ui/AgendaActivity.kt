package com.application.app.modules.agenda.ui

import android.content.Intent
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityAgendaBinding
import com.application.app.modules.agenda.`data`.viewmodel.AgendaVM
import com.application.app.modules.cadastroone.ui.CadastroOneActivity
import com.application.app.modules.matrias.ui.MatRiasActivity
import com.application.app.modules.professores.ui.ProfessoresActivity
import kotlin.String
import kotlin.Unit

class AgendaActivity : BaseActivity<ActivityAgendaBinding>(R.layout.activity_agenda) {
  private val viewModel: AgendaVM by viewModels<AgendaVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.agendaVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnMarcarAula.setOnClickListener {
      val i = Intent(this, MatRiasActivity::class.java)
      startActivity(i)
    }
  }

  companion object {
    const val TAG: String = "AGENDA_ACTIVITY"

  }
}
