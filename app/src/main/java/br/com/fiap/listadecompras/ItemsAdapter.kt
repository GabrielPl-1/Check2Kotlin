package br.com.fiap.listadecompras

/**
 *  imports de classes e interfaces fornecidas pelo framework Android
 */
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter responsável por vincular os dados da lista de itens a uma RecyclerView (Exibição de conjuntos de dados em lista).
 */
class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    /**
     * Lista de itens
     */
    private val items = mutableListOf<ItemModel>()

    /**
     * Adiciona um novo item à lista e chama o RecyclerView com o notifyDataSetChanged(),
     * sua função é notificar o Recycler View  que as Views foram alteradas e devem ser atualizadas,
     */
    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()

    }

    /**
     * Cria e retorna um novo ViewHolder para exibir um item na lista.
     * ViewHolder contém referências dos elementos visuais de um item no RecyclerView.
     * Ele ajuda a reutilizar as visualizações dos itens e facilita a atualização desses itens.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        /**
         * construição de hierarquia de visualizações a partir de um arquivo de layout XML.
         * inflar layouts XML em objetos de View correspondentes em tempo de execução
         */
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)

    }

    /**
     * Retorna o número total dos itens na lista.
     */
    override fun getItemCount(): Int = items.size

    /**
     * onBindViewHolder
     * Método chamado pelo recyclerview para exibir os dados em uma posição específica
     * Onde você associa os dados de um item aos elementos visuais dentro do ViewHolder
     * Chamado sempre que o RecyclerView precisa exibir um novo item ou atualizar um item existente.
     * Vincula os dados de um item à View do ViewHolder.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        /**
         * obtém o item de dados na posição específica dentro da lista de itens.
         */
        val item = items[position]
        /**
         *  associa às visualizações do ViewHolder para exibição na interface do usuário.
         */
        holder.bind(item)
    }

    /**
     * ViewHolder que representa a visualização de cada item na RecyclerView.
     */
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)

        /**
         * Atualizar os elementos visuais do ViewHolder com os dados do item específico que está sendo exibido
         * na posição correspondente
         */
        fun bind(item: ItemModel) {
            textView.text = item.name
        }
    }
}
