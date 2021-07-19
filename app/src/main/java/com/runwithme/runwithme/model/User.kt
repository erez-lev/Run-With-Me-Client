package com.runwithme.runwithme.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class User(
    @SerializedName("_id")
    var _id: String,
    @SerializedName("firstName")
    var firstName: String,
    @SerializedName("lastName")
    var lastName: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("photoUri")
    var photoUri : String,
    @SerializedName("runs")
    var runs : ArrayList<Run>,
)