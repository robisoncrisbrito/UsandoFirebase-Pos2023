package br.edu.utfpr.usandofirebase_pos2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.utfpr.usandofirebase_pos2023.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

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

    }

    private fun btAlterarOnClick() {

    }

    private fun btExcluirOnClick() {

    }

    private fun btPesquisarOnClick() {

    }

    private fun btListarOnClick() {

    }
}