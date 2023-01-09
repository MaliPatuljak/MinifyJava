package com.github.merlinths.codegolf.minify.comments

internal val SINGLE_LINE_COMMENT_REGEX =
    "//.*\\n*"
        .toRegex()