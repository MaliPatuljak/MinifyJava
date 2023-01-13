package com.github.merlinths.codegolf.minify

import com.github.merlinths.codegolf.minify.quotes.withoutQuotes
import com.github.merlinths.codegolf.minify.space.normalizeWhitespaces
import com.github.merlinths.codegolf.minify.space.removeWhitespaces

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
    withoutQuotes {
        remove(SingleLineComments)
            .normalizeWhitespaces()
            .remove(MultiLineComments, PackageDeclarations)
            .replace(Keywords, MatchResult::removeWhitespaces)
            .trim()
    }