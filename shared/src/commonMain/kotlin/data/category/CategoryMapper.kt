package data.category

import domain.category.Category
import migrations.Categories

fun Categories.toCategory(): Category {
  return Category(
    id = id,
    name = name
  )
}
