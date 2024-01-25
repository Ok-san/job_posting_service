package component.home.orderlist

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import network.Database

class OrderDetailsComponent(
  componentContext: ComponentContext,
  private val database: Database,
  private val orderId: Int,
  private val userId: Int,
  private val onBack: () -> Unit,
) : ComponentContext by componentContext, OrderDetails {
  private val _model =
    MutableValue(
      OrderDetails.Model(
        comments = database.getComments(orderId) ?: mutableListOf(),
        commentText = "",
        order = database.getOrdersById(orderId),
      ),
    )

  override val model: Value<OrderDetails.Model> get() = _model

  override fun onBackClick() {
    onBack()
  }

//    override fun onAnswerClick() {
//        TODO("Not yet implemented")
//    }

  override fun onAuthorCommentClick(authorId: Int) {
    TODO("Not yet implemented")
  }

  override fun onChangeTextComment(text: String) {
    _model.update {
      it.copy(commentText = text)
    }
  }

  override fun onSendCommentClick() {
    val newCommentsList = _model.value.comments
    newCommentsList.add(database.createComment(orderId, database.getUserName(userId), _model.value.commentText.toString()))
    _model.update {
      it.copy(
        comments = newCommentsList,
        commentText = ""
      )
    }
  }
}
