package com.dito.fundamental1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val username: String,
    val password: String
) : Parcelable