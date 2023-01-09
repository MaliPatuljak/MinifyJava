package com.github.merlinths.codegolf.minify

internal val MINIFY_REGEX =
    "((\\s)*[$CHARACTER_MATCHES]+(\\s)*)"
        .toRegex()