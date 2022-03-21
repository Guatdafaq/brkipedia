package com.sevens.brkipedia.domain.models

import android.graphics.drawable.Drawable
import android.os.Parcelable
import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.domain.common.Status
import java.io.Serializable
import java.util.*

data class DomainCharacter(
    val id: Int,
    val name: String,
    val birthday: Date?,
    val occupation: List<String>,
    val img: String,
    val status: Status,
    val nickname: String,
    val seasons: List<Int>,
    val actor: String,
    val category: List<Category>,
) : Serializable
