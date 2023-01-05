package com.github.merlinths.codegolf.minify

internal val CHARACTER_MATCHES = CHARACTER_SET.joinToString(
    separator = "|\\",
    prefix = "\\"
)