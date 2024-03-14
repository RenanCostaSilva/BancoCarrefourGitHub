package br.com.renancsdev.bancocarrefour.model.login

import br.com.renancsdev.bancocarrefour.model.User

data class Login(

    var login: String,

    var id: Long,

    var nodeID: String,

    var avatarURL: String,

    var gravatarID: String,

    var url: String,

    var htmlURL: String,

    var followersURL: String,

    var followingURL: String,

    var gistsURL: String,

    var starredURL: String,

    var subscriptionsURL: String,

    var organizationsURL: String,

    var reposURL: String,

    var eventsURL: String,

    var receivedEventsURL: String,

    var type: String,

    var siteAdmin: Boolean

)
