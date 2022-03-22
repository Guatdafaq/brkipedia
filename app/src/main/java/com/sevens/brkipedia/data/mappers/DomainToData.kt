package com.sevens.brkipedia.data.mappers

import android.annotation.SuppressLint
import com.sevens.brkipedia.data.local.models.LocalCharacter
import com.sevens.brkipedia.data.local.models.LocalQuote
import com.sevens.brkipedia.domain.models.DomainCharacter
import com.sevens.brkipedia.domain.models.DomainQuote
import java.text.SimpleDateFormat
import java.util.*

fun DomainCharacter.toDataBase() =
    LocalCharacter(
        this.id,
        this.name,
        parseDate(this.birthday),
        this.occupation,
        this.img,
        this.status,
        this.nickname,
        this.seasons,
        this.actor,
        this.category.map{ it.value }
    )


@JvmName("toDataBaseDomainCharacter")
fun List<DomainCharacter>.toDataBase() = this.map { it.toDataBase() }

fun DomainQuote.toDataBase() =
    LocalQuote(
        this.id,
        this.text,
        this.author,
        this.series
    )


@JvmName("toDataBaseDomainQuote")
fun List<DomainQuote>.toDataBase() = this.map { it.toDataBase() }

@SuppressLint("SimpleDateFormat")
fun parseDate(birthday: Date?): String {
    return if (birthday != null)
        SimpleDateFormat("MM-dd-yyyy").format(birthday)
    else
        "Unknown"
}