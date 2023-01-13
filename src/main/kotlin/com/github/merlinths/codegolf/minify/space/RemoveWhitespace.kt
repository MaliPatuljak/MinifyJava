package com.github.merlinths.codegolf.minify.space

import com.github.merlinths.codegolf.minify.remove

fun MatchResult.removeWhitespaces() =
    value.remove(Whitespaces)
