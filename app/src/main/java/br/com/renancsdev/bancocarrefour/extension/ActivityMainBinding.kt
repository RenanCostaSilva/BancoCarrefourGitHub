package br.com.renancsdev.bancocarrefour.extension

import androidx.recyclerview.widget.GridLayoutManager
import br.com.renancsdev.bancocarrefour.ui.adapter.adapter.RecyclerViewUsuarios
import br.com.renancsdev.bancocarrefour.databinding.ActivityMainBinding
import br.com.renancsdev.bancocarrefour.model.login.Login
import br.com.renancsdev.bancocarrefour.ui.filter.FiltroListaUsuarios


fun ActivityMainBinding.mainAdapterFiltro(logins: List<Login> , listaLoginsEncontrados: List<Login>){
    this.rvCarrefourUsuarios.apply {
        layoutManager = GridLayoutManager(this.context , 2)
        adapter = RecyclerViewUsuarios(logins)
    }
    FiltroListaUsuarios(this , listaLoginsEncontrados).procurarPessoaFiltro()
}
