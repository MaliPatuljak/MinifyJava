package com.github.merlinths.codegolf.minify

private val coolCharacters = listOf(
    '(', ')',
    '[', ']',
    '{', '}',
    '<', '>',
    '.', ',',
    '+', '-', '*', '/', '%', '='
)

private val coolCharacterMatches = coolCharacters.joinToString(
    separator = "|\\",
    prefix = "\\"
)

private val coolCharacterRegex = "((\\s)*[$coolCharacterMatches]+(\\s)*)".toRegex()

fun String.minify() =
    trim()
        .replace("\n", "")
        .replace(coolCharacterRegex, MatchResult::removeWhitespaces)

private fun MatchResult.removeWhitespaces() =
    value.replace("\\s".toRegex(), "")