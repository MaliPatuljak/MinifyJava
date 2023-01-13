package com.github.merlinths.codegolf.minify

internal val PackageDeclarations =
    """package\s+[^;]*;"""
        .toRegex()