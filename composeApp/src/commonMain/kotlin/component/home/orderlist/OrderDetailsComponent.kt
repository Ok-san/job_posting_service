package component.home.orderlist

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import data.CommentsModel
import network.Database

class OrderDetailsComponent(
  componentContext: ComponentContext,
  database: Database,
  orderId: Int,
  private val onBack: () -> Unit,
) : ComponentContext by componentContext, OrderDetails {
  private val _database = database
  private val _orderId = orderId
  private val _model =
    MutableValue(
      OrderDetails.Model(
        comments = _database.getComments(orderId),
        commentText = "",
        order = _database.getOrdersById(orderId),
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
    _model.value.commentText = text
  }

  override fun onSendCommentClick() {
    val newComment =
      CommentsModel(
        id = 2,
        author = "mav",
        description = _model.value.commentText.toString(),
        publicationDate = "Nov 23, 2023",
      )

    _database.createComment(_orderId, newComment)
  }
}
