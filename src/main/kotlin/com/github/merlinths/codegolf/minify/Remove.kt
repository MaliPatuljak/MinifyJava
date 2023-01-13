package com.github.merlinths.codegolf.minify

/**
 * Removes matches for every regex
 * in the order they had been passed as arguments.
 *
 * @param[regexes] The regexes to remove
 * @return The modified String
 */
fun String.remove(vararg regexes: Regex): String =
    regexes.fold(this) { text, regex ->
        text.replace(regex, "")
    }