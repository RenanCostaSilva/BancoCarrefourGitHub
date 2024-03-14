package br.com.renancsdev.bancocarrefour.api.interfaces

import br.com.renancsdev.bancocarrefour.model.Repositorio
import br.com.renancsdev.bancocarrefour.model.User
import br.com.renancsdev.bancocarrefour.model.login.Login
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoints {

    @GET("/users")
    suspend fun pegarUsuariosLiveData(): Response<ArrayList<Login>>

    @GET("/users/{login}")
    suspend fun pegarDetalheUsuarioLiveData(@Path("login") login: String): Response<User>

    @GET("/users/{login}/repos")
    suspend fun pegarRepositorioUsuarioLiveData(@Path("login") login: String): Response<ArrayList<Repositorio>>

}