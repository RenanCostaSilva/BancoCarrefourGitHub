package br.com.renancsdev.bancocarrefour.api.request

import androidx.lifecycle.liveData
import br.com.renancsdev.bancocarrefour.api.interfaces.Endpoints

class UsuarioDetalheRepositorio(private val api: Endpoints) {

    fun buscarDetalheUsuarios(login: String) = liveData {

        val resposta = api.pegarDetalheUsuarioLiveData(login)
        if(resposta.isSuccessful){
            emit(Resultado.Sucesso(dado = resposta.body()))
        } else {
            emit(Resultado.Erro(exception = Exception("Falha ao buscar os detalhes do usuário")))
        }

    }

}