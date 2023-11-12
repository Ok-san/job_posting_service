package org.example.job_posting_service.data

data class MastersModel(
    val name: String = "Oksana",
    val description: String = "I'm very smart and cool. I’ve been working for a thousand years and in general everything is great for me.",
    val price: String? = null,
    val city: String = "Santiago",
    val publicationDate: String = "Oct 22, 2023",
    val favorite: Boolean = false,
    val avatar: String = "avatar"
)
