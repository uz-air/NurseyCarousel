package com.ankur.nursery

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ApiResponse(
    @SerializedName("status") val status: Int?,
    @SerializedName("message") val message: String?,
    @SerializedName("data") val data: List<PlantDetails?>?
) {
    data class PlantDetails(
        @SerializedName("id") val id: String?,
        @SerializedName("imageUri") val imageUri: String?,
        @SerializedName("plantName") val plantName: String?,
        @SerializedName("description") val description: String?,
        @SerializedName("category") val category: String?,
        @SerializedName("origin") val origin: String?,
        @SerializedName("scientificName") val scientificName: String?,
        @SerializedName("headingSize") val headingSize: Int?,
        @SerializedName("bodySize") val bodySize: Int?,
        @SerializedName("padding") val padding: Int?,
        @SerializedName("backgroundColour") val backgroundColour: String?,
        @SerializedName("textColour") val textColour: String?,
        @SerializedName("cardRadius") val cardRadius: Int?,
    ) : Serializable {
        fun getSizeHeading(): Int = headingSize?.takeUnless { it == 0 } ?: 20
        fun getPad(): Int = padding?.takeUnless { it == 0 } ?: 16
        fun getSizeBody(): Int = bodySize?.takeUnless { it == 0 } ?: 12
        fun getColourBackground(): String = backgroundColour ?: "#FFFFFFFF"
        fun getColourText(): String = textColour ?: "#FF000000"
        fun getRadius(): Int = cardRadius ?: 25
    }
}

