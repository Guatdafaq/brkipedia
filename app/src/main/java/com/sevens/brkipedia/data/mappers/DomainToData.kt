package com.sevens.brkipedia.data.mappers

import com.sevens.brkipedia.data.local.models.LocalCharacter
import com.sevens.brkipedia.data.local.models.LocalQuote
import com.sevens.brkipedia.domain.models.DomainCharacter
import com.sevens.brkipedia.domain.models.DomainQuote

fun DomainCharacter.toDataBase() =
    LocalCharacter(
        this.id,
        this.name,
        this.birthday.toString(),
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
