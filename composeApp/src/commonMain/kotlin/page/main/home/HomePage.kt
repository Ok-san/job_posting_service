package page.main.home

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import component.home.orderlist.OrderDetails
import component.home.orderlist.OrdersList

interface HomePage {
  val childStack: Value<ChildStack<*, Child>>

  sealed interface Child {
    class OrderListChild(val component: OrdersList) : Child

    class OrderDetailsChild(val component: OrderDetails) : Child
  }
}
