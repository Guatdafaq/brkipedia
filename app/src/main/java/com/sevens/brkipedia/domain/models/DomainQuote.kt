package com.sevens.brkipedia.domain.models

import java.io.Serializable

data class DomainQuote(
    val id: Int,
    val text: String,
    val author: String,
    val series: String
) : Serializable