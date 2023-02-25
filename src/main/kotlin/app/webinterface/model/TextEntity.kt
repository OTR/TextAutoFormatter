package app.webinterface.model

class TextEntity(
    override val id: Int,
    override val unformattedText: String,
    override val stageOneText: String,
    override val handFormattedText: String,
    override val posted: Boolean
): ITextEntity {

}

interface ITextEntity {
    val id: Int
    val unformattedText: String
    val stageOneText: String
    val handFormattedText: String
    val posted: Boolean
}