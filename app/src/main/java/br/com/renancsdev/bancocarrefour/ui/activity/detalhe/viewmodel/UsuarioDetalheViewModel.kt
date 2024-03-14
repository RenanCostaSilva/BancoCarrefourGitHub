package br.com.renancsdev.bancocarrefour.ui.activity.detalhe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.renancsdev.bancocarrefour.api.request.Resultado
import br.com.renancsdev.bancocarrefour.api.request.UsuarioDetalheRepositorio
import br.com.renancsdev.bancocarrefour.api.request.UsuarioRepositorio
import br.com.renancsdev.bancocarrefour.model.Repositorio
import br.com.renancsdev.bancocarrefour.model.User
import br.com.renancsdev.bancocarrefour.model.login.Login
import br.com.renancsdev.bancocarrefour.ui.activity.detalhe.UsuarioDetalhe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.ArrayList

class UsuarioDetalheViewModel(private val repository: UsuarioDetalheRepositorio): ViewModel() {

    private val _detalheUsuario = MutableLiveData< LiveData<Resultado<User?>>>()
    val login = ""
    init {
        viewModelScope.launch(IO) {
            _detalheUsuario.postValue(repository.buscarDetalheUsuarios(login))
        }
    }

    fun buscaDetalheUsuarios(login: String): LiveData<Resultado<User?>> =
        repository.buscarDetalheUsuarios(login)

}