package br.com.renancsdev.bancocarrefour.model

import br.com.renancsdev.bancocarrefour.model.login.Login

data class Repositorio(

    val id: Long,

    val nodeID: String,

    val name: String?,

    val fullName: String,

    val private: Boolean,

    val owner: Login,

    val htmlURL: String,

    val description: String?,

    val fork: Boolean,

    val url: String,

    val forksURL: String,

    val keysURL: String,

    val collaboratorsURL: String,

    val teamsURL: String,

    val hooksURL: String,

    val issueEventsURL: String,

    val eventsURL: String,

    val assigneesURL: String,

    val branchesURL: String,

    val tagsURL: String,

    val blobsURL: String,

    val gitTagsURL: String,

    val gitRefsURL: String,

    val treesURL: String,

    val statusesURL: String,

    val languagesURL: String,

    val stargazersURL: String,

    val contributorsURL: String,

    val subscribersURL: String,

    val subscriptionURL: String,

    val commitsURL: String,

    val gitCommitsURL: String,

    val commentsURL: String,

    val issueCommentURL: String,

    val contentsURL: String,

    val compareURL: String,

    val mergesURL: String,

    val archiveURL: String,

    val downloadsURL: String,

    val issuesURL: String,

    val pullsURL: String,

    val milestonesURL: String,

    val notificationsURL: String,

    val labelsURL: String,

    val releasesURL: String,

    val deploymentsURL: String,

    val createdAt: String,

    val updatedAt: String?,

    val pushedAt: String,

    val gitURL: String,

    val sshURL: String,

    val cloneURL: String,

    val svnURL: String,

    val homepage: String,

    val size: Long,

    val stargazersCount: Long,

    val watchersCount: Long,

    val language: String?,

    val hasIssues: Boolean,

    val hasProjects: Boolean,

    val hasDownloads: Boolean,

    val hasWiki: Boolean,

    val hasPages: Boolean,

    val hasDiscussions: Boolean,

    val forksCount: Long,

    val archived: Boolean,

    val disabled: Boolean,

    val openIssuesCount: Long,

    val license: License?,

    val allowForking: Boolean,

    val isTemplate: Boolean,

    val webCommitSignoffRequired: Boolean,

    val topics: List<Any>,

    val visibility: String,

    val forks: Long,

    val openIssues: Long,

    val watchers: Long,

    val defaultBranch: String
)
