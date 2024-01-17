package component.home.orderlist

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
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
        var order = this._model.value.ordersList.get(id.toInt())
        order.favorite = order.favorite.not()
    }

    override fun onItemClicked(id: Long) {
        onSelected(id)
    }
}