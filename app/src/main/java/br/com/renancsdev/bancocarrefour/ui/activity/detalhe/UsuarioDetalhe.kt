package br.com.renancsdev.bancocarrefour.ui.activity.detalhe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.renancsdev.bancocarrefour.R
import br.com.renancsdev.bancocarrefour.api.request.Resultado
import br.com.renancsdev.bancocarrefour.api.request.UsuarioDetalheRepositorio
import br.com.renancsdev.bancocarrefour.databinding.ActivityUsuarioDetalheBinding
import br.com.renancsdev.bancocarrefour.enumerator.user.detalhe.Usuario
import br.com.renancsdev.bancocarrefour.extension.dataGMTParaPTBR
import br.com.renancsdev.bancocarrefour.extension.esconder
import br.com.renancsdev.bancocarrefour.extension.exibirData
import br.com.renancsdev.bancocarrefour.extension.glide
import br.com.renancsdev.bancocarrefour.extension.mostrar
import br.com.renancsdev.bancocarrefour.extension.paraORepositorio
import br.com.renancsdev.bancocarrefour.model.User
import br.com.renancsdev.bancocarrefour.ui.activity.detalhe.viewmodel.UsuarioDetalheViewModel
import br.com.renancsdev.bancocarrefour.ui.activity.main.viewmodel.MainViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.delay
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.TimeZone
import java.util.Timer
import kotlin.concurrent.schedule

class UsuarioDetalhe : AppCompatActivity() {

    private lateinit var binding: ActivityUsuarioDetalheBinding
    var context     = this@UsuarioDetalhe
    var layoutMain  = R.layout.activity_usuario_detalhe
    private val viewModel by viewModel<UsuarioDetalheViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setarLayout()
        setarBinding()
    }

    /*  Configuracao Inicial */
    fun setarLayout(){
        setContentView(layoutMain)
    }
    fun setarBinding(){
        binding = DataBindingUtil.setContentView(context , layoutMain)
    }
    /*  Fim Configuracao Inicial */

    override fun onStart() {
        super.onStart()
        buscarDadosViewModel()
        esconderEventos()
    }

    private fun esconderEventos(){
        //binding.nsv.esconder()
    }

    /* ViewModel */
    private fun buscarDadosViewModel(){
        viewModel.buscaDetalheUsuarios(intent.getStringExtra("login")!!).observe(this) {
            it?.let { resultado ->
                when (resultado) {
                    is Resultado.Sucesso -> {
                        resultado.dado?.let { usuario ->
                            exibirComponentes(usuario)
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



    /* Exibicao de Componentes */
    // 4 - Eventos
    fun exibirComponentes(user: User){
        exibirDadosUsuario(user)
        verRepositorio(user)
    }
    // TextView
    fun exibirDadosUsuario(user: User){

        binding.progressBar2.mostrar()
        binding.glide(context , user , binding.imvUsuarioGithub )
        binding.tvDataCriacaoUsuarioGithub.exibirData(user.created_at.dataGMTParaPTBR())
        binding.tvEmpresaUsuarioGithub.exibirData("Empresa: ${user.company ?: Usuario.SEMEMPRESA.texto}")
        binding.tvNomeUsuarioGithub.exibirData(user.name ?: Usuario.SEMUSUARIO.texto)
        binding.tvLocalizacaoUsuarioLocalizacao.exibirData(user.location ?: Usuario.SEMLOCALIZACAO.texto)
        binding.tvGitUsuarioGithub.exibirData("Repo.:${user.public_repos ?: Usuario.SEMADADOSGIT.texto} / Amo.: ${user.public_gists ?: Usuario.SEMADADOSGIT.texto}")

    }


    //Button
    fun verRepositorio(user: User){
        binding.btnDetalheUsuarioRepositorio.setOnClickListener {
            Intent().paraORepositorio(binding.root.context , user.login)
        }
    }
    /* Fim Exibicao de Componentes */

}