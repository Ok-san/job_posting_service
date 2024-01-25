package data.category

import domain.category.Category
import domain.category.CategoryDataSource
import shared.storage.sql.Database

class SqlDelightCategoryDataSource(database: Database): CategoryDataSource {
  private val queries = database.categoryQueries

  override suspend fun getAllCategories(): List<Category> {
    return queries
      .getAllCategories()
      .executeAsList()
      .map { it.toCategory() }
  }
}
