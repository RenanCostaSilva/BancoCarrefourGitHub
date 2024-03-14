package br.com.renancsdev.bancocarrefour.ui.activity.apresentacao

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.renancsdev.bancocarrefour.R
import br.com.renancsdev.bancocarrefour.databinding.ActivityIntroBinding
import br.com.renancsdev.bancocarrefour.ui.activity.main.MainActivity

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding
    var layoutIntro  = R.layout.activity_intro
    var context  = this@IntroActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setarConfiguracaoInicial()
        animacaoRedirecionamento()

    }


    /*  Configuracao Inicial */
    fun setarConfiguracaoInicial(){
        setarLayout()
        setarBinding()
    }
    fun setarLayout(){
        setContentView(layoutIntro)
    }
    fun setarBinding(){
        binding = DataBindingUtil.setContentView(context , layoutIntro)
    }
    /*  Fim Configuracao Inicial */


    /*  Redirecionamento */
    fun animacaoRedirecionamento(){
        Handler(Looper.getMainLooper()).postDelayed({
            context.startActivity(Intent(this@IntroActivity, MainActivity::class.java))
            overridePendingTransition(R.anim.fade_in , R.anim.fade_out)
        },2000)
    }
    /*  Redirecionamento */



}