package component.home.orderlist

import com.arkivanov.decompose.value.Value
import data.OrdersModel

interface OrdersList {
  val model: Value<Model>

  data class Model(
    val ordersList: List<OrdersModel> = emptyList(),
    val selectedId: Int? = null,
  )

  fun onLikeClicked(id: Int)

  fun onItemClicked(id: Int)
}
