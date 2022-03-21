package com.sevens.brkipedia.data.local.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.domain.common.Status
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "character_table")
data class LocalCharacter(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val birthday: String,
    val occupation: List<String>,
    val img: String,
    val status: Status,
    val nickname: String,
    val seasons: List<Int>,
    val actor: String,
    val category: List<String>
) : Parcelable
