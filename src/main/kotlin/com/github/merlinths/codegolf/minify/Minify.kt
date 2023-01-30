package com.github.merlinths.codegolf.minify

import com.github.merlinths.codegolf.minify.quotes.withoutQuotes
import com.github.merlinths.codegolf.minify.space.normalizeWhitespaces
import com.github.merlinths.codegolf.minify.space.removeWhitespaces
import com.github.merlinths.codegolf.minify.string.remove

/**
 * Minifies java code.
 *
 * Also removes
 * - single and multiline comments
 * - package declarations
 * ---
 * String literals remain as they are.
 *
 * @receiver Java code to minify
 * @return Minified java code
 */
fun String.minify() =
    removeQuotesInComments()
        .withoutQuotes {
            remove(SingleLineComments)
                .normalizeWhitespaces()
                .remove(MultiLineComments, PackageDeclarations)
                .replace(Keywords, MatchResult::removeWhitespaces)
                .trim()
    }