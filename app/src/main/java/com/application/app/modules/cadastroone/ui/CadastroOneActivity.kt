package com.application.app.modules.cadastroone.ui

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityCadastroOneBinding
import com.application.app.modules.cadastroone.`data`.viewmodel.CadastroOneVM
import com.application.app.modules.login.ui.LoginActivity
import com.lastcode.educame.infrastructure.network.AlunoApi
import com.lastcode.educame.infrastructure.network.RetrofitHelper
import com.application.app.dto.AlunoCadastroModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.String

class CadastroOneActivity :
    BaseActivity<ActivityCadastroOneBinding>(R.layout.activity_cadastro_one) {
    private val viewModel: CadastroOneVM by viewModels<CadastroOneVM>()

    override fun onInitialized() {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.cadastroOneVM = viewModel
    }

    override fun setUpClicks() {

        binding.btnRegistrar.setOnClickListener {
            gravarAluno()

        }

        binding.txtVOLTAR.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
    }

    private fun atualizarTela() {
        binding.etEmail.text?.clear()
        binding.etSenha.text?.clear()
        binding.etConfirmaSenha.text?.clear()



    }

    private fun montarAluno(): AlunoCadastroModel? {
        val password: String = binding.etSenha.text.toString()
        val passwordConfirm: String = binding.etConfirmaSenha.text.toString()
        if (password.equals(passwordConfirm)) {
            val email: String = binding.etEmail.text.toString()
            val aluno = AlunoCadastroModel(email = email, password = password)

            return aluno
        } else {
            return null
        }

    }

    private fun gravarAluno(){

        val aluno = montarAluno()

        if (aluno != null) {
            val coroutineScope = CoroutineScope(Dispatchers.IO)
            coroutineScope.launch {
                try {
                    val result = RetrofitHelper.getInstance().create(AlunoApi::class.java).gravarAluno(aluno)

                    Log.i("EVENTO_API", "retornoApi2: Sucesso")


                    withContext(Dispatchers.Main){
                        if (result.token.isEmpty().not()){
                        val toast = Toast.makeText(this@CadastroOneActivity, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG)
                        toast.show()
                            Log.i("EVENTO_API", "CHEGUEI AQUI")
                        }else{
                            val toast = Toast.makeText(this@CadastroOneActivity, "Erro em cadastrar usuário!", Toast.LENGTH_LONG)
                            toast.show()
                        }
                        atualizarTela()

                    }


                }catch (e: Exception){
                    Log.i("EVENTO_API","retornoApi3: ${e.printStackTrace().toString()}" )
                    val toast = Toast.makeText(this@CadastroOneActivity, "Erro em cadastrar usuário!", Toast.LENGTH_LONG)
                    toast.show()
                }
            }
        } else {
            Toast.makeText(this@CadastroOneActivity, "Senha diferente da confirmação", Toast.LENGTH_SHORT).show()
        }

    }


    companion object {
        const val TAG: String = "CADASTRO_ONE_ACTIVITY"

    }
}
