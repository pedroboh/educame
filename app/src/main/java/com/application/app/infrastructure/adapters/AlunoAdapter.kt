package com.lastcode.educame.infrastructure.adapters

class AlunoAdapter {
}
//foi usado para testes em outro projeto, usar como referencia pra construir ProfessorAdapter
//class AlunoAdapter (
//    private val dataset: List<AlunoModel>
//) : RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>() {

//    class AlunoViewHolder(view: View, listener : onItemClickListener) :
//        RecyclerView.ViewHolder(view) {
//
//        val tvAlunoId: TextView = view.findViewById(R.id.tvAlunoId)
//        val tvAlunoNome: TextView = view.findViewById(R.id.tvAlunoNome)
//        val tvAlunoConsole: TextView = view.findViewById(R.id.tvAlunoConsole)
//        val tvAlunoUrlVideo: TextView = view.findViewById(R.id.tvAlunoUrlVideo)
//        val tvAlunoNota : TextView = view.findViewById(R.id.tvAlunoNota)
//        //testando click no item
//        init {
//            view.setOnClickListener{
//                listener.onItemClick(absoluteAdapterPosition)
//            }
//        }

//    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
//        val adapterLayout = LayoutInflater.from(parent.context)
//            .inflate(R.layout.fragment_lista_aluno, parent, false)
//
//        return AlunoViewHolder(adapterLayout, mListener)
//    }
//
//    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
//        val aluno = dataset[position]
//        holder.tvAlunoId.text = aluno.id
//        holder.tvAlunoNome.text = aluno.nome
//        holder.tvAlunoConsole.text = aluno.email
//        holder.tvAlunoUrlVideo.text = aluno.password
//        holder.tvAlunoNota.text = aluno.createdAt
//
//
////        if(!gameFeedback.urlImagem.equals("")) {
////            Picasso.get().load(gameFeedback.urlImagem).into(holder.ivAlunoFoto)
////        }
//    }
//
//    override fun getItemCount() = dataset.size
//
//
//    //Tentando setar clicks nos itens
//    private lateinit var mListener : onItemClickListener
//
//    interface onItemClickListener{
//
//        fun onItemClick(position: Int)
//
//    }
//
//    fun setOnItemClickListener(listener: onItemClickListener){
//        mListener = listener
//    }
//
//    fun getItem(position : Int) : AlunoModel{
//        return dataset.get(position)
//    }
//}