package component.home.orderlist

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import network.Database

class OrdersListComponent(
  componentContext: ComponentContext,
  database: Database,
  private val onSelected: (id: Int) -> Unit,
) : ComponentContext by componentContext, OrdersList {
  private val _model =
    MutableValue(
      OrdersList.Model(
        ordersList = database.getOrders(),
      ),
    )
  override val model: Value<OrdersList.Model> get() = _model

  override fun onLikeClicked(id: Int) {
    _model.update {
      it.ordersList[id].favorite = it.ordersList[id].favorite.not()
      it.copy(ordersList = it.ordersList)
    }
  }

  override fun onItemClicked(id: Int) {
    onSelected(id)
  }
}
