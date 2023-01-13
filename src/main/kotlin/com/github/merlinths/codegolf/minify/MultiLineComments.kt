package com.github.merlinths.codegolf.minify

internal val MultiLineComments =
    """(/\*).*(\*/)"""
        .toRegex()