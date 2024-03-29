package component.home.orderlist

import com.arkivanov.decompose.value.Value
import data.CommentsModel
import data.OrderModel

interface OrderDetails {
  val model: Value<Model>

  data class Model(
    var order: OrderModel,
    var comments: MutableList<CommentsModel>,
    var commentText: String? = null,
  )

  fun onChangeTextComment(text: String)

  fun onSendCommentClick()

  fun onBackClick()

  //    fun onAnswerClick()
  fun onAuthorCommentClick(authorId: Int)
}
