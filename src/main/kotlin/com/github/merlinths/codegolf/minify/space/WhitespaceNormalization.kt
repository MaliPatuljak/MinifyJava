package com.github.merlinths.codegolf.minify.space

/**
 * Replaces all types of whitespaces with ' '.
 */
fun String.normalizeWhitespaces() =
    replace(Whitespaces, " ")
