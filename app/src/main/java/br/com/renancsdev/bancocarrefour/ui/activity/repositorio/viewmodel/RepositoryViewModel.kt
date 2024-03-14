package br.com.renancsdev.bancocarrefour.ui.activity.repositorio.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.renancsdev.bancocarrefour.api.request.Resultado
import br.com.renancsdev.bancocarrefour.api.request.UsuarioDetalheRepositorio
import br.com.renancsdev.bancocarrefour.api.request.UsuarioRepositoriosRepositorio
import br.com.renancsdev.bancocarrefour.model.Repositorio
import br.com.renancsdev.bancocarrefour.model.User
import br.com.renancsdev.bancocarrefour.model.login.Login
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RepositoryViewModel(private val repository: UsuarioRepositoriosRepositorio): ViewModel() {

    private val _detalheUsuario = MutableLiveData<LiveData<Resultado<ArrayList<Repositorio>?>>>()
    val login = ""
    init {
        viewModelScope.launch(Dispatchers.IO) {
            _detalheUsuario.postValue(repository.buscarRepositoriosUsuario(login))
        }
    }

    fun buscaReposotoriosUsuario(login: String): LiveData<Resultado<ArrayList<Repositorio>?>> =
        repository.buscarRepositoriosUsuario(login)

}