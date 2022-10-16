package com.example.usersensorik.login

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.ApiInterface
import com.example.myapplication.api.RetrofitClient
import com.example.usersensorik.databinding.FragmentLoginBinding
import com.sensorik.domain.model.user.SignInRequestPostDto
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.lang.Exception

class Forgotpassviewmodel :ViewModel() {
    val forgotNameLiveDataMessage = MutableLiveData<String>()
    val loginforget = MutableLiveData<String>()

    fun checkforget(userName: String){
        Log.e("Forget",userName)
        if (userName.isBlank()){
            forgotNameLiveDataMessage.value = "Please Enter User Name "
        }else if (android.util.Patterns.EMAIL_ADDRESS.matcher(userName).matches()){
            forgotNameLiveDataMessage.value = ""
        }else{
            forgotNameLiveDataMessage.value = "Please Enter Valid Email "
        }
}
    fun loginforget(userName: String) {
        if ( forgotNameLiveDataMessage.value == "") {
            val retrofit = RetrofitClient.getInstance()
            val apiInterface = retrofit.create(ApiInterface::class.java)
            viewModelScope.launch {
                try {
                    val response = apiInterface.forgot(SignInRequestPostDto(userName = userName))
                    if (response.isSuccessful()) {
                        loginforget.value = ""
                        Log.e("Login ", response.message())
                    } else {
                        val error = response.errorBody()?.charStream()?.readText().toString()
                        loginforget.value = JSONObject(error).getString("message") ?: "UnKnow Error"
                        Log.e("Login ", response.errorBody().toString())
                    }
                } catch (Ex: Exception) {
                    Log.e("Error", Ex.localizedMessage)
                }
            }
        }}
        }