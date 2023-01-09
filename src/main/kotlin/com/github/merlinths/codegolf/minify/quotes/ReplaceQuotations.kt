package com.github.merlinths.codegolf.minify.quotes

import java.util.LinkedList
import java.util.Queue

/**
 * Replaces quotes with invalid identifier while being processed
 * in [modify]. Inserts original quotes after modifications is done.
 *
 * @receiver Java code to modify
 * @param[quotations] Queue to add and remove quotes in FIFO order
 * @param[modify] String modifications with replaced quotes
 */
fun String.withoutQuotes(
    quotations: Queue<String> = LinkedList(),
    modify: String.() -> String
) = with(QuotationScope(quotations)) {
        replaceQuotations()
            .modify()
            .insertQuotations()
    }