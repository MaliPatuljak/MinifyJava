package com.github.merlinths.codegolf.minify

fun String.minify() =
    replace("\n", " ")
        .trim()
        .replace(MINIFY_REGEX, MatchResult::removeWhitespaces)

private fun MatchResult.removeWhitespaces() =
    value.replace("\\s".toRegex(), "")