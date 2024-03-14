package br.com.renancsdev.bancocarrefour.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.renancsdev.bancocarrefour.R
import br.com.renancsdev.bancocarrefour.api.request.Resultado
import br.com.renancsdev.bancocarrefour.databinding.ActivityMainBinding
import br.com.renancsdev.bancocarrefour.extension.esconder
import br.com.renancsdev.bancocarrefour.extension.mainAdapterFiltro
import br.com.renancsdev.bancocarrefour.model.login.Login
import br.com.renancsdev.bancocarrefour.ui.activity.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()
    private var context     = this@MainActivity
    private var layoutMain  = R.layout.activity_main
    private lateinit var listaLoginsEncontrados: List<Login>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setarLayout()
        setarBinding()
    }
    /*  Configuracao Inicial */
    private fun setarLayout(){
        setContentView(layoutMain)
    }
    private fun setarBinding(){
        binding = DataBindingUtil.setContentView(context , layoutMain)
    }
    /*  Fim Configuracao Inicial */

    override fun onStart() {
        super.onStart()
        buscarDadosViewModel()
    }

    /* ViewModel */
    private fun buscarDadosViewModel(){
        viewModel.buscaListaUsuarios().observe(context) {
            it?.let { resultado ->
                when (resultado) {
                    is Resultado.Sucesso -> {
                        resultado.dado?.let { usuarios ->
                            listaLoginsEncontrados = usuarios
                            initUsuariosAdapter(usuarios , binding)
                            binding.includeProgressbarMain.flCarrefourLoading.esconder()
                            true
                        } ?: false
                    }
                    is Resultado.Erro -> {
                        Toast.makeText(context , "${resultado.exception}" , Toast.LENGTH_LONG).show()
                        false
                    }
                }
            } ?: false
        }
    }
    /* Fim ViewModel */



    /* Lista de Exibição */
    private fun initUsuariosAdapter(logins: List<Login>, binding: ActivityMainBinding){
        binding.mainAdapterFiltro(logins , listaLoginsEncontrados)
    }
    /* Fim Lista de Exibição */

}