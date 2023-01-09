package com.github.merlinths.codegolf.minify

import com.github.merlinths.codegolf.minify.comments.removeMultiLineComments
import com.github.merlinths.codegolf.minify.comments.removeSingleLineComments
import com.github.merlinths.codegolf.minify.quotes.withoutQuotes

/**
 * Minifies java code.
 *
 * Also removes single and multiline comments.
 * String literals remain as they are.
 *
 * @receiver[String] Java code to minify
 * @return Minified java code
 */
fun String.minify() =
    withoutQuotes {
        removeSingleLineComments()
            .replace("\n", " ")
            .removeMultiLineComments()
            .replace(MINIFY_REGEX, MatchResult::removeWhitespaces)
            .trim()
    }

private fun MatchResult.removeWhitespaces() =
    value.replace("\\s".toRegex(), "")