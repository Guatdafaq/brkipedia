package com.sevens.brkipedia.domain.models

import android.graphics.drawable.Drawable
import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.domain.common.Status
import java.util.*

data class Character(
    val id: Int,
    val name: String,
    val birthday: Date?,
    val occupation: List<String>,
    val img: Drawable,
    val status: Status,
    val nickname: String,
    val appearance: List<Int>,
    val portrayed: String,
    val category: List<Category>,
)
