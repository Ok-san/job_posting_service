package component.home.orderlist

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import data.CommentsModel
import data.comments

class OrderDetailsComponent(
    componentContext: ComponentContext,
    orderId: Long?,
    private val onBack: () -> Unit
) : ComponentContext by componentContext, OrderDetails {

    private val _model = MutableValue(
        OrderDetails.Model(
//            comments = database.getComments(id)
            comments = comments,
            commentText = ""
        )
    )

    override val model: Value<OrderDetails.Model> = _model

    override fun onBackClick() {
        onBack()
    }

//    override fun onAnswerClick() {
//        TODO("Not yet implemented")
//    }

    override fun onAuthorCommentClick(authorId: Long) {
        TODO("Not yet implemented")
    }

    override fun onChangeTextComment(text: String) {
        _model.value.commentText = text
    }

    override fun onSendCommentClick() {
        val newComment = CommentsModel(
            id = 2,
            author = "mav",
            description = "jfjeifj",
            publicationDate = "Nov 23, 2023"
        )
        comments.add(newComment)
//        database.createComment(model.value.commentText)
    }
}