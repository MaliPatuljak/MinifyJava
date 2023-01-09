package com.github.merlinths.codegolf.minify.quotes

internal val QUOTATION_REGEX = """
        "([^\\"]|(\\.))*"
    """.trimIndent()
    .toRegex()