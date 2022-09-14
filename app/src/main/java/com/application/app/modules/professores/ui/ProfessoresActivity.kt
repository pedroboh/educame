package com.application.app.modules.professores.ui

//import ProfessorAdapter
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.LinearLayout
//import android.widget.TextView
//import android.widget.Toast
//import androidx.core.view.get
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.application.app.databinding.ActivityProfessoresBinding
//import com.application.app.infrastructure.SessionManager
//import com.application.app.infrastructure.network.MateriasApi
//import com.application.app.modules.professores.data.model.ProfessoresRowModel
//import com.lastcode.educame.infrastructure.network.RetrofitHelper
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
//class ProfessoresActivity : Fragment() {
//
//    //    private lateinit var binding: FragmentListaBinding
//    private lateinit var binding: ActivityProfessoresBinding
//    private lateinit var listaProfessores: MutableList<ProfessoresRowModel>
//    private lateinit var  recyclerView: RecyclerView
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        binding = ActivityProfessoresBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        listaProfessores = mutableListOf()
//        recyclerView = binding.recyclerProfessores
//
//
//        recyclerView.layoutManager = LinearLayoutManager(context)
//
//
//
//    }
//
//    override fun onResume() {
//        carregarDados()
//        super.onResume()
//    }
//
////    private fun atualizarTela() {
////        var adapter = ProfessorAdapter(listaProfessores)
////        recyclerView.adapter = adapter
////        adapter.setOnItemClickListener(object : ProfessorAdapter.onItemClickListener{
////            override fun onItemClick(position: Int) {
////                val item = recyclerView.get(position) as LinearLayout
////                var professor = adapter.getItem(position)
////                val textTeste = TextView(activity?.applicationContext)
////                textTeste.textSize = 20f
////                textTeste.text = "Teste dinamico"
////
//////                textTeste.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
////                val param = textTeste.layoutParams as ViewGroup.MarginLayoutParams
//////                param.setMargins(10)
////
////
////
////                item.addView(textTeste)
////
////
////
////                Toast.makeText(activity?.applicationContext, "${professor.txtNomeProfessor}", Toast.LENGTH_SHORT).show()
////            }
////
////        })
//////        binding.tvQuantidadeAluno.text = listaProfessores.size.toString()
////    }
//
////    private fun carregarDados(){
////        CoroutineScope(Dispatchers.IO).launch() {
////            try {
////                val result = RetrofitHelper.getInstance().create(MateriasApi::class.java).getProfessores()
////                val sessionManager = activity?.let { SessionManager(it.applicationContext) }
////                var token = sessionManager?.fetchAuthToken()
////                Log.i("EVENTO_API","retornoApi: Success: ${result.size} registros recuperados")
////                listaProfessores = mutableListOf()
////                result.forEach {listaProfessores.add((it))}
////
////                withContext(Dispatchers.Main){
////                    atualizarTela()
////                }
////            }catch (e: Exception){
////                Log.i("EVENTO_API","retornoApi2:  + ${e.message}")
////            }
////        }
////    }
//
//        private fun carregarDados(){
//        CoroutineScope(Dispatchers.IO).launch() {
//            try {
//                val sessionManager = SessionManager(requireActivity().applicationContext)
//                var token = sessionManager.fetchAuthToken()
//                val result = RetrofitHelper.getInstance().create(MateriasApi::class.java).getProfessores(token, "5372477c-c4c6-4b0c-adb9-9e2975193598")
//                val professores = result.professores
//                Log.i("EVENTO_API","retornoApi: Success: ${professores.size} registros recuperados")
//
//
//                professores.forEach {
//                    val professor = ProfessoresRowModel(txtEmailProfessor = it.email, txtIdProfessor = it.id, txtNomeProfessor = it.nome)
//                    listaProfessores.add(professor)
////                    viewModel.professoresList.value?.add((professor))
//                    Log.i("EVENTO_API","adicionado um professor")
//                }
////                viewModel.professoresList.value?.addAll(listaProfessores)
////                adapter.updateData(listaProfessores)
//                withContext(Dispatchers.Main){
//                    atualizarTela()
//                }
//            }catch (e: Exception){
//                Log.i("EVENTO_API","retornoApi2:  + ${e.message}")
//            }
//        }
//
//    }
//
//    private fun atualizarTela() {
//        var adapter = ProfessorAdapter(listaProfessores)
//        recyclerView.adapter = adapter
//        adapter.setOnItemClickListener(object : ProfessorAdapter.onItemClickListener{
//            override fun onItemClick(position: Int) {
//                val item = recyclerView.get(position) as LinearLayout
//                var professor = adapter.getItem(position)
//                val textTeste = TextView(activity?.applicationContext)
//                textTeste.textSize = 20f
//                textTeste.text = "Teste dinamico"
//
////                textTeste.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//                val param = textTeste.layoutParams as ViewGroup.MarginLayoutParams
////                param.setMargins(10)
//
//
//
////                item.addView(textTeste)
//
//
//
//                Toast.makeText(activity?.applicationContext, "${professor.txtIdProfessor}", Toast.LENGTH_SHORT).show()
//            }
//
//        })
////        binding.tvQuantidadeAluno.text = listaFeedbacks.size.toString()
//    }
//
//}




import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityProfessoresBinding
import com.application.app.infrastructure.SessionManager
import com.application.app.infrastructure.network.MateriasApi
import com.application.app.modules.professores.`data`.model.ProfessoresRowModel
import com.application.app.modules.professores.`data`.viewmodel.ProfessoresVM
import com.lastcode.educame.infrastructure.network.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ProfessoresActivity :
    BaseActivity<ActivityProfessoresBinding>(R.layout.activity_professores) {
    private val viewModel: ProfessoresVM by viewModels<ProfessoresVM>()
    private var listaProfessores = mutableListOf<ProfessoresRowModel>()



    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        val professoresAdapter =
            ProfessoresAdapter(viewModel.professoresList.value ?: mutableListOf(),this)
        binding.recyclerProfessores.adapter = professoresAdapter
        professoresAdapter.setOnItemClickListener(
            object : ProfessoresAdapter.OnItemClickListener {
                override fun onItemClick(view: View, position: Int, item: ProfessoresRowModel) {
                    onClickRecyclerProfessores(view, position, item)
                }
            }
        )
        carregarDados(professoresAdapter)

        viewModel.professoresList.observe(this) {

            professoresAdapter.updateData(listaProfessores)
        }

        binding.professoresVM = viewModel
    }


    override fun setUpClicks(): Unit {
    }

    fun onClickRecyclerProfessores(
        view: View,
        position: Int,
        item: ProfessoresRowModel
    ): Unit {
        when (view.id) {
        }
    }

    private fun carregarDados(adapter: ProfessoresAdapter){
        CoroutineScope(Dispatchers.IO).launch() {
            try {
                val sessionManager = SessionManager(this@ProfessoresActivity)
                var token = sessionManager.fetchAuthToken()
                val result = RetrofitHelper.getInstance().create(MateriasApi::class.java).getProfessores(token, "5372477c-c4c6-4b0c-adb9-9e2975193598")
                val professores = result.professores
                Log.i("EVENTO_API","retornoApi: Success: ${professores.size} registros recuperados")


                professores.forEach {
                    val professor = ProfessoresRowModel(txtEmailProfessor = it.email, txtIdProfessor = it.id, txtNomeProfessor = it.nome)
                    listaProfessores.add(professor)
                    viewModel.professoresList.value?.add((professor))
                    Log.i("EVENTO_API","adicionado um professor")
                }
                viewModel.professoresList.value?.addAll(listaProfessores)
                Log.i("EVENTO_API","log1")


//                onRestart()
                withContext(Dispatchers.Main){
                    adapter.updateData(listaProfessores)
                    Log.i("EVENTO_API","log2")
//                    atualizarTela()
                }
            }catch (e: Exception){
                Log.i("EVENTO_API","retornoApi2:  + ${e.message}")
            }
        }

    }

    override fun onResume() {
//        carregarDados()
        super.onResume()
    }

//    private fun atualizarTela(){
//    var adapter = ProfessoresAdapter(listaProfessores,this)
//    }

    companion object {
        const val TAG: String = "PROFESSORES_ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, ProfessoresActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }



}
