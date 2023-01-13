package com.github.merlinths.codegolf.minify

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RemoveTest {
    @Test
    fun `String remains the same for empty regex`() {
        val text = "Hello Kotlin!"
        val emptyRegex = "".toRegex()

        assertEquals(
            expected = text,
            actual = text.remove(emptyRegex)
        )
    }

    @Test
    fun `Remove single regex`() {
        val text = "Bob loves programming!"
        val regex = "\\s".toRegex()

        assertEquals(
            expected = "Boblovesprogramming!",
            actual = text.remove(regex)
        )
    }

    @Test
    fun `Remove two regexes`() {
        val text = "Bob do not likes scripting!"
        val doNotRegex = "(do|not)\\s+".toRegex()

        assertEquals(
            expected = "Bob likes scripting!",
            actual = text.remove(doNotRegex)
        )
    }
}