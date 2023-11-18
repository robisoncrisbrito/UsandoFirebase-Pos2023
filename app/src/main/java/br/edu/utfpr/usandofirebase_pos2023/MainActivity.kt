package br.edu.utfpr.usandofirebase_pos2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.edu.utfpr.usandofirebase_pos2023.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val bd = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )



        binding.btIncluir.setOnClickListener {
            btIncluirOnClick()
        }

        binding.btAlterar.setOnClickListener {
            btAlterarOnClick()
        }

        binding.btExcluir.setOnClickListener {
            btExcluirOnClick()
        }

        binding.btPesquisar.setOnClickListener {
            btPesquisarOnClick()
        }

        binding.btListar.setOnClickListener {
            btListarOnClick()
        }
    }

    private fun btIncluirOnClick() {

        val pessoa = hashMapOf(
            "cod" to binding.edCod.text.toString(),
            "nome" to binding.etNome.text.toString(),
            "telefone" to binding.etTelefone.text.toString()
        )

        bd.collection( "Pessoa" )
            .document( binding.edCod.text.toString() )
            .set( pessoa )
            .addOnSuccessListener {
                Toast.makeText( this, "Inclusão realizada com Sucesso!!", Toast.LENGTH_LONG ).show()
            }
            .addOnFailureListener{ e->
                Toast.makeText( this, e.localizedMessage, Toast.LENGTH_LONG ).show()
            }
    }

    private fun btAlterarOnClick() {
        val pessoa = hashMapOf(
            "cod" to binding.edCod.text.toString().toInt(),
            "nome" to binding.etNome.text.toString(),
            "telefone" to binding.etTelefone.text.toString()
        )

        bd.collection( "Pessoa" )
            .document( binding.edCod.text.toString() )
            .set( pessoa )
            .addOnSuccessListener {
                Toast.makeText( this, "Alteração realizada com Sucesso!!", Toast.LENGTH_LONG ).show()
            }
            .addOnFailureListener{ e->
                Toast.makeText( this, e.localizedMessage, Toast.LENGTH_LONG ).show()
            }

    }

    private fun btExcluirOnClick() {
        bd.collection( "Pessoa" )
            .document( binding.edCod.text.toString() )
            .delete()
            .addOnSuccessListener {
                Toast.makeText( this, "Exclusão realizada com Sucesso!!", Toast.LENGTH_LONG ).show()
            }
            .addOnFailureListener{ e->
                Toast.makeText( this, e.localizedMessage, Toast.LENGTH_LONG ).show()
            }
    }

    private fun btPesquisarOnClick() {
        val saida = StringBuilder()

        bd.collection( "Pessoa" )
            .whereEqualTo( "cod", binding.edCod.text.toString() )
            .get()
            .addOnSuccessListener { result->
                if ( result.isEmpty ) {
                    Toast.makeText( this, "Registro não encontrado", Toast.LENGTH_LONG ).show()
                } else {
                    val registro = result.elementAt( 0 ).data

                    Toast.makeText( this, "Registro encontrado: ${registro.get( "nome" ) }", Toast.LENGTH_LONG ).show()
                }

            }
            .addOnFailureListener { e ->
                Toast.makeText( this, e.localizedMessage, Toast.LENGTH_LONG ).show()
            }
    }

    private fun btListarOnClick() {

        val saida = StringBuilder()

        bd.collection( "Pessoa" )
            .get()
            .addOnSuccessListener { result->
                for ( document in result ) {
                    saida.append( "${document.data.get( "nome" )}\n"  )
                }
                Toast.makeText( this, saida, Toast.LENGTH_LONG ).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText( this, e.localizedMessage, Toast.LENGTH_LONG ).show()
            }

    }
}