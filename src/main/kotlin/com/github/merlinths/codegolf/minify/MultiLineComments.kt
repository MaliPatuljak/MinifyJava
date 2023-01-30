package com.github.merlinths.codegolf.minify

internal val MultiLineComments =
    """(/\*).*(\*/)"""
        .toRegex(RegexOption.DOT_MATCHES_ALL)