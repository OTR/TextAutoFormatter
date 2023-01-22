/**
 * This is an educational project in Kotlin. This is a program that takes some
 * piece of a text and makes some predefined string formatting to it. Such as
 * trims extra spaces, puts a dot at the end of a sentence, puts a tab character
 * before a paragraph and so on. Makes some addition measurement such as counts
 * characters, words, sentences, paragraphs.
 *
 * 21.01.2023
 * version 0.0.0
 */

// What character use when compiling sentence from words
const val WORD_SEPARATOR: String  = " "
// What character use when splitting whole text into sentences
// LineEndedByDot
val SENTENCE_SEPARATOR: Regex = Regex("(?<=\\.)")

/**
 * Returns the amount of words in given text
 */
fun countWords(wholeText: String): Int {
    val words: List<String> = wholeText.split(WORD_SEPARATOR)
    return words.size
}

/**
 * Splits a whole piece of a text into separated sentences using dot character
 * as a delimiter.
 */
fun splitByDot(wholeText: String): List<String> {
    return wholeText.split(SENTENCE_SEPARATOR)
}

/**
 * Splits a whole piece of a text into paragraphs, joins and returns the result
 */
fun splitIntoParagraphs(words: Array<String>): String {
    return words.joinToString(separator = WORD_SEPARATOR)
}

/**
 * Get line about amount of words given us as an program input arguments
 */
fun getLineAboutSize(amountOfWords: Int): String {
    val lineAboutSize: String = when (amountOfWords) {
        0 -> "Array is empty"
        1 -> "Interesting that when you split an empty string you'll get an array with only element which is empty string"
        else -> "The size of array is: $amountOfWords"
    }

    return lineAboutSize
}

fun main(args: Array<String>) {
    val stdInLine: String? = readLine()
    val wholeText: String = if (stdInLine != null) stdInLine.toString() else ""
    val amountOfWords: Int = countWords(wholeText)
    val lineAboutSize: String = getLineAboutSize(amountOfWords)
    val separateSentences: List<String> = splitByDot(wholeText)

    println(lineAboutSize)

    for (sentence in separateSentences) {
        println(sentence)
    }
}
