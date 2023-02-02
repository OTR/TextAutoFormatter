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
        val funOutput: List<String> = businessLogic(input)
        val actual: String = funOutput.joinToString("\n")
        // then
        assertEquals(expected, actual)
    }
}
