package com.sensorik.domain.model.user

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


data class SignInRequestPostDto(
    @SerializedName("username")
    val userName: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("extra")
    val extra: ExtraRequest? = null,
    val fcmToken: String? = null
)

data class ExtraRequest(
    @SerializedName("appId")
    val appId: Int = 1,
    @SerializedName("appHash")
    val appHash: String? = null,
    @SerializedName("appVersion")
    val appVersion: String? = null,
    @SerializedName("platform")
    val platform: String? = "ANDROID"
)
