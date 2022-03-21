package com.sevens.brkipedia.data.mappers

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import com.sevens.brkipedia.data.local.models.LocalCharacter
import com.sevens.brkipedia.data.local.models.LocalQuote
import com.sevens.brkipedia.data.remote.models.RemoteCharacter
import com.sevens.brkipedia.data.remote.models.RemoteQuote
import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.domain.common.Status
import com.sevens.brkipedia.domain.models.DomainCharacter
import com.sevens.brkipedia.domain.models.DomainQuote
import java.text.SimpleDateFormat
import java.util.*

fun RemoteCharacter.toDomain() =
    DomainCharacter(
        this.char_id,
        this.name,
        parseDate(this.birthday),
        this.occupation,
        this.img,
        parseStatus(this.status),
        this.nickname,
        this.appearance.toList(),
        this.portrayed,
        parseCategory(this.category)
    )


@JvmName("toDomainRemoteCharacter")
fun List<RemoteCharacter>.toDomain() = this.map { it.toDomain() }


fun RemoteQuote.toDomain() =
    DomainQuote(
        this.quote_id,
        this.quote,
        this.author,
        this.series
    )


@JvmName("toDomainRemoteQuote")
fun List<RemoteQuote>.toDomain() = this.map { it.toDomain() }

fun LocalCharacter.toDomain() =
    DomainCharacter(
        this.id,
        this.name,
        parseDate(this.birthday),
        this.occupation,
        this.img,
        this.status,
        this.nickname,
        this.seasons,
        this.actor,
        parseCategory(this.category)
    )

@JvmName("toDomainLocalCharacter")
fun List<LocalCharacter>.toDomain() = this.map { it.toDomain() }

fun LocalQuote.toDomain() =
    DomainQuote(
        this.id,
        this.text,
        this.author,
        this.series
    )

@JvmName("toDomainLocalQuote")
fun List<LocalQuote>.toDomain() = this.map { it.toDomain() }

fun parseStatus(status: String): Status {
    return when (status) {
        "Alive" -> Status.ALIVE
        "Dead" -> Status.DEAD
        else -> Status.UNKNOWN
    }
}

private fun String.toDrawable(): Drawable {
    TODO("not implemented yet")
/*
    val byteArrayOutputStream = ByteArrayOutputStream()
    val bitmap = BitmapFactory.decode
    val imageBytes: ByteArray = byteArrayOutputStream.toByteArray()
    val imageString: String = Base64.encodeToString(imageBytes, Base64.DEFAULT)*/
}

fun parseCategory(category: String): List<Category> {

    var categories : List<Category>
    category.split(", ").apply {
        categories = parseCategory(this)
    }
    return categories
}

fun parseCategory(categories: List<String>): List<Category> {

    val list = ArrayList<Category>()
    categories.forEach {
        when (it) {
            "Breaking Bad" -> list.add(Category.BREAKING_BAD)
            "Better Call Saul" -> list.add(Category.BETTER_CALL_SAUL)
        }
    }
    return list
}

@SuppressLint("SimpleDateFormat")
fun parseDate(birthday: String): Date? {
    return if (birthday != "Unknown")
        SimpleDateFormat("MM-dd-yyyy").parse(birthday)
    else
        null
}
