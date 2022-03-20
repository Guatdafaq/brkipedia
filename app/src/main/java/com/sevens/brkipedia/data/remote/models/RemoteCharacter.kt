package com.sevens.brkipedia.data.remote.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RemoteCharacter(
    val id: Int,
    val name: String,
    val birthday: String,
    val occupation: ArrayList<String>,
    val img: String,
    val status: String,
    val nickname: String,
    val appearance: ArrayList<Int>,
    val portrayed: String,
    val category: String,
    val better_call_saul_appearance: ArrayList<Int>
) : Parcelable
