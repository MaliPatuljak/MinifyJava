package com.github.merlinths.codegolf.minify.comments

internal val MULTI_LINE_COMMENT_REGEX =
    "(/\\*).*(\\*/)"
        .toRegex()