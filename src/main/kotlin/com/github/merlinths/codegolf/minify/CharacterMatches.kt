package com.github.merlinths.codegolf.minify

internal val CharacterMatches = CharacterSet.joinToString(
    separator = "|\\",
    prefix = "\\"
)