package com.github.merlinths.codegolf.minify.space

import com.github.merlinths.codegolf.minify.string.remove

fun MatchResult.removeWhitespaces() =
    value.remove(Whitespaces)
