package br.com.fiap.listadecompras


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
     /**
     *  Fnção principal falar ao compilador para não gerar avisos quando
     *  uma view é inflada sem um ID específico
     * **/
    @SuppressLint("MissingInflatedId")
    /**
         * Este método onCreate() é chamado quando a atividade é criada.
         * O parâmetro savedInstanceState é utilizado para restaurar o estado da atividade
        * de uma instância anterior, se disponível.
        * Dentro deste método, você normalmente configura a interface do usuário da atividade,
        * inflando layouts, configurando listeners e realizando outras inicializações necessárias.
         */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         *Chama a implementação do método onCreate() da classe pai para realizar inicializações
        necessárias para o ciclo de vida da atividade.
        Define o layout da atividade com base no arquivo XML "activity_main.xml".
         */
        setContentView(R.layout.activity_main)

        /**
         * Obtém uma referência para o RecyclerView do layout usando seu ID.
          */
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);

         /**
         * Cria uma instância do adaptador de itens
         */
        val itemsAdapter = ItemsAdapter()
        /**
         * Define o adaptador para o RecyclerView.
         */
        recyclerView.adapter = itemsAdapter
        /**
         * Obtém uma referência para o Button do layout usando seu ID.
         */
        val button = findViewById<Button>(R.id.button)
         /**
         * Obtém uma referência para o EditText do layout usando seu ID
         */
        val editText = findViewById<EditText>(R.id.editText)

        /**
        *  Configura um listener de clique para o botão.
        */
        button.setOnClickListener {
            /**
             * Cria um novo objeto ItemModel, usando o texto inserido no EditText como nome.
             */
            val item = ItemModel(
                name = editText.text.toString()
            )
            itemsAdapter.addItem(item)
        }
    }
 }
