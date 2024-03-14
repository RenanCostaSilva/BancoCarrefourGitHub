package br.com.renancsdev.bancocarrefour.extension

import android.content.Context
import android.content.Intent
import br.com.renancsdev.bancocarrefour.ui.activity.repositorio.RepositorioActivity

fun Intent.paraORepositorio(context: Context , dataEnvio: String){
    val intent = Intent(context , RepositorioActivity::class.java)
    intent.putExtra("repositorio" , dataEnvio)
    context.startActivity(intent)
}
