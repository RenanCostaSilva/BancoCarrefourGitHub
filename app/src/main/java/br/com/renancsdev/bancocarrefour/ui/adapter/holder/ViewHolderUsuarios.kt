package br.com.renancsdev.bancocarrefour.ui.adapter.holder

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import br.com.renancsdev.bancocarrefour.R
import br.com.renancsdev.bancocarrefour.databinding.ItemListUsuarioBinding
import br.com.renancsdev.bancocarrefour.extension.esconder
import br.com.renancsdev.bancocarrefour.model.login.Login
import br.com.renancsdev.bancocarrefour.ui.activity.detalhe.UsuarioDetalhe
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class ViewHolderUsuarios(private var binding: ItemListUsuarioBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(login: Login) {
        setarDados(login)
        eventoDeClick(login)
    }

    fun setarDados(login: Login){

        binding.tvItemListaUsuario.text = login.login

        val bar = binding.progressBar2
        Glide.with(binding.root.context)
            .load("https://avatars.githubusercontent.com/u/${login.id}?v=4")
            .error(R.drawable.noimage)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>, isFirstResource: Boolean): Boolean {
                    bar.esconder()
                    return false
                }
                override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable>?, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                    bar.esconder()
                    return false
                }
            })
            .into(binding.imgItemListaUsuario)
    }
    private fun eventoDeClick(login: Login){
        binding.cardItemUserGithub.setOnClickListener {
            binding.root.context.startActivity(Intent(binding.root.context , UsuarioDetalhe::class.java).putExtra("login" , login.login))
        }
    }

}