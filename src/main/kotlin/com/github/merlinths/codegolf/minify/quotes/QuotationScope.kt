package com.github.merlinths.codegolf.minify.quotes

import java.util.Queue

internal class QuotationScope(
    private val quotations: Queue<String>
) {
    fun String.insertQuotations() =
        replace(PLACEHOLDER_REGEX) {
            quotations.remove()
        }


    fun String.replaceQuotations() =
        replace(QUOTATION_REGEX) { match ->
            quotations.add(match.value)

            PLACEHOLDER_REGEX.pattern
        }
}