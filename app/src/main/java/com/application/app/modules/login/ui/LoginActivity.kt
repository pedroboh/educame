package com.application.app.modules.login.ui

import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.appcomponents.googleauth.GoogleHelper
import com.application.app.databinding.ActivityLoginBinding
import com.application.app.dto.AlunoCadastroModel
import com.application.app.infrastructure.SessionManager
import com.application.app.modules.agenda.ui.AgendaActivity
import com.application.app.modules.cadastroone.ui.CadastroOneActivity
import com.application.app.modules.login.`data`.viewmodel.LoginVM
import com.application.app.modules.professores.ui.ProfessoresActivity
import com.lastcode.educame.infrastructure.network.AlunoApi
import com.lastcode.educame.infrastructure.network.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.String
import kotlin.Unit

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val viewModel: LoginVM by viewModels<LoginVM>()

    private lateinit var googleLogin: GoogleHelper
    private lateinit var sessionManager: SessionManager

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.loginVM = viewModel
        googleLogin = GoogleHelper(this,
            { accountInfo ->
            }, { error ->

            })
    }

    override fun setUpClicks(): Unit {
        binding.imageGoogle.setOnClickListener {
            googleLogin.login()
        }
        binding.tvCadastrese.setOnClickListener {
            val i = Intent(this, CadastroOneActivity::class.java)
            startActivity(i)
        }
        binding.btnEntrar.setOnClickListener {
            loginAluno()
        }
    }

    private fun loginAluno() {

        val aluno = montarAluno()
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            try{
                val result = RetrofitHelper.getInstance().create(AlunoApi::class.java).loginAluno(aluno)

                Log.i("EVENTO_API", "retornoAPi: Login sucesso")

                withContext(Dispatchers.Main){
                    sessionManager = SessionManager(this@LoginActivity)
                    sessionManager.saveAuthToken(result.token)
                    sessionManager.saveID(result.registerViewModel.id)
//                    var token :String = ""
//                    if (sessionManager.fetchAuthToken() != null) {
//                        token += sessionManager.fetchAuthToken()
//                    }
//                    Log.i("EVENTO_API", token)
                    val i = Intent(this@LoginActivity, AgendaActivity::class.java)
                    startActivity(i)
                }
            }
            catch (e: Exception){
                Log.i("EVENTO_API", "deu ruim")

            }
        }

    }
    private fun montarAluno(): AlunoCadastroModel {
        val email: String = binding.etLoginEmail.text.toString()
        val password: String = binding.etLoginSenha.text.toString()
        val aluno = AlunoCadastroModel(email = email, password = password)

        return aluno

    }

    companion object {
        const val TAG: String = "LOGIN_ACTIVITY"

    }
}
