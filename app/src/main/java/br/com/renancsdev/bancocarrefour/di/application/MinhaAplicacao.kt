package br.com.renancsdev.bancocarrefour.di.application

import android.app.Application
import br.com.renancsdev.bancocarrefour.di.module.redeModule
import br.com.renancsdev.bancocarrefour.di.module.repositorioModule
import br.com.renancsdev.bancocarrefour.di.module.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MinhaAplicacao: Application() {

    private val appModules = listOf(
        redeModule,
        repositorioModule,
        vmModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MinhaAplicacao)
            modules(appModules)
        }
    }

}