package br.com.renancsdev.bancocarrefour.model

import java.util.Date

data class User(
    var login: String,
    var id: Long,
    var node_id: String,
    var avatar_url: String,
    var gravatar_id: String,
    var url: String,
    var html_url: String,
    var followers_url: String,
    var following_url: String,
    var gists_url: String,
    var starred_url: String,
    var subscriptions_url: String,
    var organizations_url: String,
    var repos_url: String,
    var events_url: String,
    var received_events_url: String,
    var type: String,
    var site_admin: Boolean,
    var name:  String?,
    var company:  String?,
    var blog: String,
    var location:  String?,
    var email:  String,
    var hireable:  String,
    var bio:  String,
    var twitter_username: String,
    var public_repos: Int?,
    var public_gists: Int?,
    var followers: Int,
    var following: Int,
    var created_at: Date,
    var updated_at: Date?
)