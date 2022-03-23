package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

/* Create Moshi object */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/* Retrofit builder to build and create a Retrofit object */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/* How Retrofit talks to the web server using HTTP request
   Since we are fetching data, we will use GET command. */
interface MarsApiService{
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

/* Public object to initialize Retrofit service
   Public singleton to access from the rest of the app */
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)

    }
}

