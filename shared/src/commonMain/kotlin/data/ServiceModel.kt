package data

data class ServiceModel(
    val id: Int,
    val category: String,
    val specialization: String,
    val publicationDate: String,
    val coast: String? = null,
    val description: String? = null,
    val master: ProfileModel,
    val city: String? = null,
    val favorite: Boolean = false,
)
