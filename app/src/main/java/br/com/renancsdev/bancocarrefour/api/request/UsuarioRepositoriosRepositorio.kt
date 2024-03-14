package br.com.renancsdev.bancocarrefour.api.request

import androidx.lifecycle.liveData
import br.com.renancsdev.bancocarrefour.api.interfaces.Endpoints

class UsuarioRepositoriosRepositorio(private val api: Endpoints) {

    fun buscarRepositoriosUsuario(login: String) = liveData {

        val resposta = api.pegarRepositorioUsuarioLiveData(login)
        if(resposta.isSuccessful){
            emit(Resultado.Sucesso(dado = resposta.body()))
        } else {
            emit(Resultado.Erro(exception = Exception("Falha ao buscar os dados do usuario")))
        }

    }

}