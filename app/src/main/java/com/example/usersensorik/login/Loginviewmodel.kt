package com.example.usersensorik.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.ApiInterface
import com.example.myapplication.api.RetrofitClient
import com.sensorik.domain.model.user.SignInRequestPostDto
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.lang.Exception


class Loginviewmodel : ViewModel() {
    val userNameLiveDataMessage = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()
    val loginUser = MutableLiveData<String>()

    fun checkUserName(userName: String){

        if (userName.isBlank()){
            userNameLiveDataMessage.value = "Please Enter User Name "
        }else if (android.util.Patterns.EMAIL_ADDRESS.matcher(userName).matches()){
            userNameLiveDataMessage.value = ""
        }else{
            userNameLiveDataMessage.value = "Please Enter Valid Email "
        }

    }
    fun checkPassword(password: String) {
        if (password.isBlank()) {
            passwordLiveData.value = "Please Enter password"
        } else if (password.length<5){
            passwordLiveData.value = "Password Must More than 5 charecter"

        }
        else {
            passwordLiveData.value = ""

        }
    }


    fun loginUser(userName: String, password: String) {
        if (passwordLiveData.value == "" && userNameLiveDataMessage.value == ""){
            val retrofit = RetrofitClient.getInstance()
            val apiInterface = retrofit.create(ApiInterface::class.java)
            viewModelScope.launch {
                try {
                    val response = apiInterface.login(SignInRequestPostDto(userName =userName, password = password ))
                    if (response.isSuccessful()) {
                        loginUser.value = ""
                        Log.e("Login ",response.message())
                    } else {
                        val error = response.errorBody()?.charStream()?.readText().toString()
                        loginUser.value =  JSONObject(error).getString("message") ?: "UnKnow Error"
                        Log.e("Login ",response.errorBody().toString())
                    }
                }catch (Ex: Exception){
                    Log.e("Error",Ex.localizedMessage)
                }
            }
        }


    }



}
