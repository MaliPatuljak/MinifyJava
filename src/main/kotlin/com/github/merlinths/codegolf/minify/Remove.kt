package com.github.merlinths.codegolf.minify

fun String.remove(vararg regexes: Regex): String =
    regexes.fold(this) { text, regex ->
        text.replace(regex, "")
    }