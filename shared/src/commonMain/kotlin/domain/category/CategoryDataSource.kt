package domain.category

interface CategoryDataSource {
  suspend fun getAllCategories(): List<Category>
}
