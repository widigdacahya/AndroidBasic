package com.example.cahyasanote

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Architecture(
    var archName: String,
    var archDesc: String,
    var archUsage: String,
    var archShortcoming: String,
    var archDiagram: Int,
    var archIcon: Int
): Parcelable
