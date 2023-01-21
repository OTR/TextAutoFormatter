/**
 * This is an educational project in Kotlin. This is a program that takes some
 * piece of a text and makes some predefined string formatting to it. Such as
 * trims extra spaces, puts a dot at the end of a sentence, puts a tab symbol
 * before a paragraph and so on. Makes some addition measurement such as counts
 * symbols, words, sentences, paragraphs.
 *
 * 21.01.2023
 * version 0.0.0
 */

// What symbol use when compiling sentence from words
const val WORD_SEPARATOR: String  = "\n"

/**
 * Returns the amount of [words], i.e. the size of given array
 */
fun countWords(words: Array<String>): Int {
    return words.size
}

/**
 * Splits a whole piece of a text into paragraphs, joins and returns the result
 */
fun splitIntoParagraphs(words: Array<String>): String {
    return words.joinToString(separator = WORD_SEPARATOR)
}

fun main(args: Array<String>) {
    val amountOfWords: Int = countWords(args)
    val formattedText: String
    val lineAboutSize: String

    lineAboutSize = when (amountOfWords) {
        0 -> "Array is empty"
        else -> "The size of array is: $amountOfWords"
    }

    formattedText = splitIntoParagraphs(args)
    println(lineAboutSize)
    println("Program arguments: $formattedText")
}
