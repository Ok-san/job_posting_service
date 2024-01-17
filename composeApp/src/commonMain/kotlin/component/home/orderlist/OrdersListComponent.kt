package component.home.orderlist

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import data.orders
import network.Database

class OrdersListComponent(
    componentContext: ComponentContext,
    database: Database,
    private val onSelected: (id: Long) -> Unit
) : ComponentContext by componentContext, OrdersList {

    private val _model = MutableValue(
        OrdersList.Model(
//            ordersList = database.getOrders()
            ordersList = orders,
        )
    )
    override val model: Value<OrdersList.Model> = _model


    override fun onLikeClicked(id: Long) {
        val order = this._model.value.ordersList
        order.get(id.toInt()).favorite = order.get(id.toInt()).favorite.not()
        _model.update { it.copy(ordersList = order)}
    }

    override fun onItemClicked(id: Long) {
        onSelected(id)
    }
}