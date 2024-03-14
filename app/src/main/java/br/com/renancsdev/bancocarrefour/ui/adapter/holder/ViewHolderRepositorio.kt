package br.com.renancsdev.bancocarrefour.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import br.com.renancsdev.bancocarrefour.databinding.ItemListRepositorioBinding
import br.com.renancsdev.bancocarrefour.enumerator.repository.license
import br.com.renancsdev.bancocarrefour.extension.exibirData
import br.com.renancsdev.bancocarrefour.model.Repositorio

class ViewHolderRepositorio(private var binding: ItemListRepositorioBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(repositorio: Repositorio) {
        exibirDados(repositorio)
    }

    fun exibirDados(repositorio: Repositorio){
        binding.tvRepositorioNome.exibirData(repositorio.name ?: license.SEMREPOSITORIO.texto)
        binding.tvRepositorioDescricao.exibirData(repositorio.description ?: license.SEMDESCRICAO.texto)
        binding.tvRepositorioVisibilidade.exibirData( repositorio.visibility)
        binding.tvRepositorioLinguagem.exibirData(repositorio.language ?: license.SEMLINGUAGEM.texto)
        binding.tvRepositorioLicensa.exibirData(repositorio.license?.name ?: license.SEMLICENSA.texto)
        binding.tvRepositorioDataAtualizacao.exibirData(repositorio.updatedAt ?: license.SEMATUALIZACAO.texto)
    }

}