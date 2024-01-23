package component.home.orderlist

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import data.CommentsModel
import java.time.LocalDate
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
        comments = database.getComments(orderId),
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
    _model.value.commentText = text
  }

  override fun onSendCommentClick() {
    val newComment =
      CommentsModel(
        id = 2,
        author = database.getUserName(userId),
        description = _model.value.commentText.toString(),
        publicationDate = LocalDate.now().toString(),
      )

    database.createComment(orderId, newComment)
  }
}
