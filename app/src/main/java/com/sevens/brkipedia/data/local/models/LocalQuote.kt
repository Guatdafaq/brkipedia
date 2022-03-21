package com.sevens.brkipedia.data.local.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "quote_table")
data class LocalQuote(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val text: String,
    val author: String,
    val series: String
) : Parcelable