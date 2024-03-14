package br.com.renancsdev.bancocarrefour.extension

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.ProgressBar
import br.com.renancsdev.bancocarrefour.R
import br.com.renancsdev.bancocarrefour.databinding.ActivityUsuarioDetalheBinding
import br.com.renancsdev.bancocarrefour.model.User
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target


fun ActivityUsuarioDetalheBinding.glide(context: Context, user: User, imagem: ImageView){

    val bar : ProgressBar = this.progressBar2
    bar.mostrar()

    Glide.with(context)
        .load("https://avatars.githubusercontent.com/u/${user.id}?v=4")
        .error(R.drawable.noimage)
        .listener(object : RequestListener<Drawable>{
            override fun onLoadFailed(e: GlideException?, model: Any?,target: Target<Drawable>,isFirstResource: Boolean): Boolean {
                bar.esconder()
                return false
            }
            override fun onResourceReady(resource: Drawable,model: Any,target: Target<Drawable>?,dataSource: DataSource,isFirstResource: Boolean): Boolean {
                bar.esconder()
                return false
            }
        })
        .apply(RequestOptions.bitmapTransform(RoundedCorners(30) ))
        .into(imagem)
}