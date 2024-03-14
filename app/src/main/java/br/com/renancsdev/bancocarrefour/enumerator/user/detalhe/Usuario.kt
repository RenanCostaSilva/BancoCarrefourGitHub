package br.com.renancsdev.bancocarrefour.enumerator.user.detalhe

enum class Usuario(val texto: String) {
    SEMUSUARIO("Usuário Inexistente"),
    SEMDATACRIACAO("Data não Obtida"),
    SEMEMPRESA("Empresa não Informada"),
    SEMLOCALIZACAO("Localização Desconhecida"),
    SEMADADOSGIT(" - ")
}