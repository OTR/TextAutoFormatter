package app.webinterface.model

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.hasProperty
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import app.webinterface.model.TextEntity

/**
 * This test class holds tests for data model `TextEntity.kt`
 * Text entity should contain these fields:
 *   id: Int | INT | PRIMARY KEY AUTOINCREMENT FROM 1 to MAXINT
 *   unformattedText: String | VARCHAR(255) NOT NULL | initial (raw) text without
 *     formatting
 *   stageOneText: String | VARCHAR(255) NULL | text after execution of auto
 *     formatting function
 *   handFormatterText: String | VARCHAR(255) NULL | user corrected text.
 *     How the user thinks final text should look like. It's needed to run test
 *     against expected (handFormattedText) and actual (stageOneText) to measure
 *     accuracy of auto formatting function and continue improving that function
 *     if tests not passed
 *  posted: boolean | BOOLEAN | Is this text already in use
 */
class TextEntityTests {

    @Test
    @DisplayName("Text Entity has certain fields")
    fun testTextEntityHasCertainFields() {

        val textEntity: TextEntity = TextEntity(1, "","","",true)
        assertThat(textEntity, hasProperty("id"))
        assertThat(textEntity, hasProperty("unformattedText"))
        assertThat(textEntity, hasProperty("stageOneText"))
        assertThat(textEntity, hasProperty("handFormattedText"))
        assertThat(textEntity, hasProperty("posted"))

        assertTrue(textEntity.id is Int)
        assertTrue(textEntity.unformattedText is String)
        assertTrue(textEntity.stageOneText is String)
        assertTrue(textEntity.handFormattedText is String)
        assertTrue(textEntity.posted is Boolean)
    }
}
