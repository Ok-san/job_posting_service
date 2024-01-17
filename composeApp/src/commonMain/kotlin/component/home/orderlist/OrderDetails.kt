package component.home.orderlist

import com.arkivanov.decompose.value.Value
import data.CommentsModel

interface OrderDetails {
    val model: Value<Model>

    data class Model(
        var comments: List<CommentsModel> = emptyList(),
        var commentText: String? = null
    )

    fun onChangeTextComment(text: String)
    fun onSendCommentClick()
    fun onBackClick()

    //    fun onAnswerClick()
    fun onAuthorCommentClick(authorId: Long)

}