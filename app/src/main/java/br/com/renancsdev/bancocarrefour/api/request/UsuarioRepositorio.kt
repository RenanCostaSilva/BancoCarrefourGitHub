package br.com.renancsdev.bancocarrefour.api.request

import androidx.lifecycle.liveData
import br.com.renancsdev.bancocarrefour.api.interfaces.Endpoints

class UsuarioRepositorio(private val api: Endpoints) {

    fun buscarUsuarios() = liveData {

        val resposta = api.pegarUsuariosLiveData()
        if(resposta.isSuccessful){
            emit(Resultado.Sucesso(dado = resposta.body()))
        } else {
            emit(Resultado.Erro(exception = Exception("Falha ao buscar os dados do usuario")))
        }

    }

}