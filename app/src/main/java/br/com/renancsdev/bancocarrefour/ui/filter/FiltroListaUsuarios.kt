package br.com.renancsdev.bancocarrefour.ui.filter

import android.widget.SearchView
import br.com.renancsdev.bancocarrefour.ui.adapter.adapter.RecyclerViewUsuarios
import br.com.renancsdev.bancocarrefour.databinding.ActivityMainBinding
import br.com.renancsdev.bancocarrefour.model.login.Login

class FiltroListaUsuarios(val mainBinding: ActivityMainBinding , var listaLogins: List<Login>) {

    private  var  usuarioEncontrado: java.util.ArrayList<Login> = arrayListOf()
    private  var  query = ""

    fun procurarPessoaFiltro(){
        mainBinding.svCarrefourUsuarios.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                procurarNaListaFiltro(query)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                procurarNaListaFiltro(newText)
                return true
            }
        })
    }
    private fun procurarNaListaFiltro(text: String?) {
        usuarioEncontrado = arrayListOf()

        listaLogins.forEach { item ->
            if(text?.let { item.login.contains(it , true) } == true){
                query = text
                usuarioEncontrado.add(item)
            }
        }
        RecyclerViewUsuarios(listaLogins).filter.filter(text)
        updateFiltro()
    }
    private fun updateFiltro(){
        mainBinding.rvCarrefourUsuarios.apply {
            adapter = RecyclerViewUsuarios(usuarioEncontrado)
        }
    }

}