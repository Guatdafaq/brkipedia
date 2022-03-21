package com.sevens.brkipedia.data.remote.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RemoteQuote(
    val quote_id: Int,
    val quote: String,
    val author: String,
    val series: String
) : Parcelable