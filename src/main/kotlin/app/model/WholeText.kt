package app.model

/**
 * Data class to keep unformatted text as a big single line.
 */
data class WholeText(override val text: String): TextData

/**
 * Any data class to work with text should implement this interface
 */
interface TextData {
    val text: String
}
