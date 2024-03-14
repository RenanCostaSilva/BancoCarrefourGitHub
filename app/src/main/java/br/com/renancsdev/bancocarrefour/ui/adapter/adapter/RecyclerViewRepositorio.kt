package br.com.renancsdev.bancocarrefour.ui.adapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.renancsdev.bancocarrefour.ui.adapter.holder.ViewHolderRepositorio
import br.com.renancsdev.bancocarrefour.ui.adapter.holder.ViewHolderUsuarios
import br.com.renancsdev.bancocarrefour.databinding.ItemListRepositorioBinding
import br.com.renancsdev.bancocarrefour.databinding.ItemListUsuarioBinding
import br.com.renancsdev.bancocarrefour.model.Repositorio
import br.com.renancsdev.bancocarrefour.model.login.Login

class RecyclerViewRepositorio(private var repositorio: List<Repositorio>): RecyclerView.Adapter<ViewHolderRepositorio>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRepositorio {
        return ViewHolderRepositorio(ItemListRepositorioBinding.inflate(LayoutInflater.from(parent.context), parent , false))
    }
    override fun getItemCount() = repositorio.size
    override fun onBindViewHolder(holder: ViewHolderRepositorio, position: Int) = holder.bind(repositorio[position])

}