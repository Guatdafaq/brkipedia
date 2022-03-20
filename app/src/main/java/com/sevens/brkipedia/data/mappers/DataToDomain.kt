package com.sevens.brkipedia.data.mappers

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import com.sevens.brkipedia.data.remote.models.RemoteCharacter
import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.domain.common.Status
import com.sevens.brkipedia.domain.models.Character
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

fun RemoteCharacter.toDomain(): Character {
    return Character(
        this.id,
        this.name,
        parseDate(this.birthday),
        this.occupation,
        this.img.toDrawable(),
        parseStatus(this.status),
        this.nickname,
        this.appearance.toList(),
        this.portrayed,
        parseCategory(this.category)
    )
}

fun List<RemoteCharacter>.toDomain(): List<Character> {

    val list = ArrayList<Character>()
    this.forEach {
        list.add(it.toDomain())
    }
    return list
}

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

    val categories = ArrayList<Category>()
    category.split(",").apply {
        forEach {
            when (it) {
                "Breaking Bad" -> categories.add(Category.BREAKING_BAD)
                "Better Call Saul" -> categories.add(Category.BETTER_CALL_SAUL)
            }
        }
        return categories
    }
}

@SuppressLint("SimpleDateFormat")
fun parseDate(birthday: String): Date? {
    return if(birthday != "Unknown")
        SimpleDateFormat("MM-dd-yyyy").parse(birthday)
    else
        null
}