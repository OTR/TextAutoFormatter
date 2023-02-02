import app.model.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import kotlin.test.assertEquals


/**
 * This test is used ONLY for refactoring purposes.
 * To ensure everything behaves the same as before refactoring.
 */
class MainKtTest {

    @ParameterizedTest
    @CsvFileSource(
        resources = ["/testData1_split_by_dot.csv",],
        numLinesToSkip = 1,
        delimiter = ';'
    )
    fun testBusinessLogic(input: String, expected: String) {
        // when
        val testData: TextData = WholeText(text = input)
        val funOutput: List<String> = businessLogic(testData)
        val actual: String = funOutput.joinToString("\n")
        // then
        assertEquals(expected, actual)
    }
}
