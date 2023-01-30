package com.github.merlinths.codegolf.minify

import com.github.merlinths.codegolf.minify.string.replace

fun String.removeQuotesInComments() =
    replace(SingleLineComments, MultiLineComments) {
        it.value.replace("\"", "")
    }