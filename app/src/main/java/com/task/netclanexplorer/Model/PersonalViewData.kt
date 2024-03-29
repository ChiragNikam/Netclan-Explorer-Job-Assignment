package com.task.netclanexplorer.Model

data class PersonalViewData(
    val name: String,
    val location: String = "Nagpur",
    val jobType: String,
    val withinKm: String,
    val purpose: String = "Coffee | Business | Friendship",
    val status: String = "Hi community! I am open to new connections\"\uD83D\uDE0A\"",
    val completeDescription: String,
    val experience: Int = 0
)
