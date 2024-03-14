package br.com.renancsdev.bancocarrefour.di.module

import br.com.renancsdev.bancocarrefour.ui.activity.detalhe.viewmodel.UsuarioDetalheViewModel
import br.com.renancsdev.bancocarrefour.ui.activity.main.viewmodel.MainViewModel
import br.com.renancsdev.bancocarrefour.ui.activity.repositorio.viewmodel.RepositoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val vmModule = module {

    // Provide MainActivityViewModel
    viewModel { MainViewModel(get()) }
    viewModel { UsuarioDetalheViewModel(get()) }
    viewModel { RepositoryViewModel(get()) }

}