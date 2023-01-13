package com.github.merlinths.codegolf.minify

internal val Keywords =
    """((\s)*[$CharacterMatches]+(\s)*)"""
        .toRegex()