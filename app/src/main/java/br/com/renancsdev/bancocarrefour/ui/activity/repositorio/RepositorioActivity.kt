package br.com.renancsdev.bancocarrefour.ui.activity.repositorio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.renancsdev.bancocarrefour.R
import br.com.renancsdev.bancocarrefour.ui.adapter.adapter.RecyclerViewRepositorio
import br.com.renancsdev.bancocarrefour.api.request.Resultado
import br.com.renancsdev.bancocarrefour.api.request.UsuarioRepositoriosRepositorio
import br.com.renancsdev.bancocarrefour.databinding.ActivityRepositorioBinding
import br.com.renancsdev.bancocarrefour.extension.esconder
import br.com.renancsdev.bancocarrefour.model.Repositorio
import br.com.renancsdev.bancocarrefour.ui.activity.detalhe.viewmodel.UsuarioDetalheViewModel
import br.com.renancsdev.bancocarrefour.ui.activity.repositorio.viewmodel.RepositoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositorioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepositorioBinding
    var context     = this@RepositorioActivity
    var layoutRepositorio  = R.layout.activity_repositorio
    private val viewModel by viewModel<RepositoryViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setarConfiguracaoInicial()

        buscarDadosViewModel()

    }


    /*  Configuracao Inicial */
    fun setarConfiguracaoInicial(){
        setarLayout()
        setarBinding()
    }
    fun setarLayout(){
        setContentView(layoutRepositorio)
    }
    fun setarBinding(){
        binding = DataBindingUtil.setContentView(context , layoutRepositorio)
    }
    /*  Fim Configuracao Inicial */



    /* ViewModel */
    fun buscarDadosViewModel(){
        viewModel.buscaReposotoriosUsuario(intent.getStringExtra("repositorio")!!).observe(this) {
            it?.let { resultado ->
                when (resultado) {
                    is Resultado.Sucesso -> {
                        resultado.dado?.let { repositorios ->
                            initRepositorioAdapter(repositorios , binding)
                            binding.includeProgressbarRepositorio.flCarrefourLoading.esconder()
                            true
                        } ?: false
                    }
                    is Resultado.Erro -> {
                        false
                    }
                }
            } ?: false
        }
    }
    /* Fim ViewModel */


    /* Lista de Exibição */
    //Adapter
    private fun initRepositorioAdapter(repositorio: List<Repositorio>, binding: ActivityRepositorioBinding){
        binding.rvRepositorio.apply {
            layoutManager = LinearLayoutManager(binding.root.context)
            adapter = RecyclerViewRepositorio(repositorio)
        }
    }
    /* Fim Lista de Exibição */

}