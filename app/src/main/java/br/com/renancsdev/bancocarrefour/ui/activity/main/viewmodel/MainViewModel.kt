package br.com.renancsdev.bancocarrefour.ui.activity.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.renancsdev.bancocarrefour.api.request.Resultado
import br.com.renancsdev.bancocarrefour.api.request.UsuarioRepositorio
import br.com.renancsdev.bancocarrefour.model.User
import br.com.renancsdev.bancocarrefour.model.login.Login
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainViewModel(private val repository: UsuarioRepositorio): ViewModel() {

    private val _listUsuarios = MutableLiveData<LiveData<Resultado<java.util.ArrayList<Login>?>>>()
    init {
        viewModelScope.launch(IO) {
            _listUsuarios.postValue(repository.buscarUsuarios())
        }
    }

    fun buscaListaUsuarios(): LiveData<Resultado<ArrayList<Login>?>> =
        repository.buscarUsuarios()

}