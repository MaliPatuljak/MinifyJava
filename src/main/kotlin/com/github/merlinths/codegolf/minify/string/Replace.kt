package com.github.merlinths.codegolf.minify.string

fun String.replace(
    vararg regexes: Regex,
    transform: (MatchResult) -> CharSequence
) = regexes.fold(this) { text, regex ->
    text.replace(regex, transform)
}