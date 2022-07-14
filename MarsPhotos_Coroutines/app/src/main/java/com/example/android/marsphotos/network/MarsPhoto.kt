package com.example.android.marsphotos.network

import com.squareup.moshi.Json

data class MarsPhoto (
    /**
     * Use the @Json annotation to map the attribute to the data class variable.
     */
    val id: String, @Json(name = "img_src") val imgSrcUrl: String
    )