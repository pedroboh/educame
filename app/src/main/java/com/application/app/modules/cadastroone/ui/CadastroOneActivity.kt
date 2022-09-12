package com.application.app.modules.cadastroone.ui

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityCadastroOneBinding
import com.application.app.modules.cadastroone.`data`.viewmodel.CadastroOneVM
import com.application.app.modules.matrias.ui.MatRiasActivity
import com.lastcode.educame.infrastructure.network.AlunoApi
import com.lastcode.educame.infrastructure.network.RetrofitHelper
import com.application.app.viewmodels.AlunoCadastroModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.String
import kotlin.Unit

class CadastroOneActivity :
    BaseActivity<ActivityCadastroOneBinding>(R.layout.activity_cadastro_one) {
    private val viewModel: CadastroOneVM by viewModels<CadastroOneVM>()

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.cadastroOneVM = viewModel
    }

    override fun setUpClicks(): Unit {

        binding.btnRegistrar.setOnClickListener {
            gravarAluno()




//            val aluno = AlunoCadastro(
//                email = binding.etEmail.text.toString(),
//                senha = binding.etSenha.text.toString()
//            )
//            val apiService = RestApiService()
//            Log.i("debugapi", aluno.toString())
//
//            apiService.addAluno(aluno) {
//                if (it?.id != null) {
//                    Toast.makeText(
//                        this@CadastroOneActivity,
//                        "Aluno Cadastrado com id ${it.id}",
//                        Toast.LENGTH_LONG
//                    ).show()
//                } else {
//                    Toast.makeText(
//                        this@CadastroOneActivity,
//                        "Erro em cadastrar aluno",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
        }

        binding.txtVOLTAR.setOnClickListener {
            val i = Intent(this, MatRiasActivity::class.java)
            startActivity(i)
        }
    }

    private fun atualizarTela() {
        binding.etEmail.text?.clear()
        binding.etSenha.text?.clear()
        binding.etConfirmaSenha.text?.clear()


//        hideKeyboard()


    }

    private fun montarAluno(): AlunoCadastroModel {
        val email: String = binding.etEmail.text.toString()
        val password: String = binding.etSenha.text.toString()

        val aluno = AlunoCadastroModel(email = email, password = password)

        return aluno

    }

    private fun gravarAluno(){

        val aluno = montarAluno()

        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            try {
                val result = RetrofitHelper.getInstance().create(AlunoApi::class.java).gravarAluno(aluno)
//                val resultId = result.body()?.aluno?.id

//                Log.i("EVENTO_API", "TOKEN: ${result.token}")
//                Log.i("EVENTO_API", "TOKEN: ${result.body()?.token.toString()}")
//                Log.i("EVENTO_API","retornoApi2: Successo: ID Aluno: ${result.registerViewModel.id}")
//                Log.i("EVENTO_API", result.body())
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

    }


    companion object {
        const val TAG: String = "CADASTRO_ONE_ACTIVITY"

    }
}
