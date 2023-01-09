package com.github.merlinths.codegolf.minify.comments

fun String.removeSingleLineComments() =
    replace(SINGLE_LINE_COMMENT_REGEX, "")

fun String.removeMultiLineComments() =
    replace(MULTI_LINE_COMMENT_REGEX, "")