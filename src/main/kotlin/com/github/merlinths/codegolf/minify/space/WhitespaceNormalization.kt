package com.github.merlinths.codegolf.minify.space

import com.github.merlinths.codegolf.minify.remove

/**
 * Replaces all types of whitespaces with ' '.
 */
fun String.normalizeWhitespaces() =
    replace(Whitespaces, " ")
