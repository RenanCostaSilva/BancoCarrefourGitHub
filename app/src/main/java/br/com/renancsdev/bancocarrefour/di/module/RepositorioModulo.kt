package br.com.renancsdev.bancocarrefour.di.module

import br.com.renancsdev.bancocarrefour.api.request.UsuarioDetalheRepositorio
import br.com.renancsdev.bancocarrefour.api.request.UsuarioRepositorio
import br.com.renancsdev.bancocarrefour.api.request.UsuarioRepositoriosRepositorio
import org.koin.core.scope.get
import org.koin.dsl.module

val repositorioModule = module {

    // Provide GithubRepository
    single { UsuarioRepositorio(get()) }
    single { UsuarioDetalheRepositorio(get()) }
    single { UsuarioRepositoriosRepositorio(get()) }

}