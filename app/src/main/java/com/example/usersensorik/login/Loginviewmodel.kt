package com.example.usersensorik.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.ApiInterface
import com.example.myapplication.api.RetrofitClient
import com.example.usersensorik.models.ChangePasswordDto
import com.sensorik.domain.model.user.SignInRequestPostDto
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.lang.Exception


class Loginviewmodel : ViewModel() {
    val userNameLiveDataMessage = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()
    val loginUser = MutableLiveData<String>()

    // Reset Password///////////////////////////////////////////////////////////////////////////////
    var passwordLength = MutableLiveData(false)
    var passwordUpperCase = MutableLiveData(false)
    var passwordNubmber = MutableLiveData(false)
    var saveButton = MutableLiveData(false)
    var confirmPasswordMatch = MutableLiveData<Int>()
    private var passwordHolder = ""
    private var confirmPasswordHolder = ""

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

    fun regxNewPassword(password: String) {
        if (password.isNullOrEmpty()) {
            passwordLength.value = false
            passwordNubmber.value = false
            passwordUpperCase.value = false
            passwordHolder = ""
        } else {
            passwordHolder = password
            var isUpperCase = false
            var isDigit = false
            passwordLength.value = password.length >= 6
            password.forEach { char ->
                if (char.isDigit()) {
                    isDigit = true
                }
                if (char.isUpperCase())
                    isUpperCase = true
            }
            passwordNubmber.value = isDigit
            passwordUpperCase.value = isUpperCase

        }
        enabledResetpassWord()
    }

    fun regxConfirmPassword(confirmPassword: String) {
        if (confirmPassword == passwordHolder) {
            confirmPasswordHolder = confirmPassword
        } else {
           // confirmPasswordMatch.value = R.string.confirm_password_error
            confirmPasswordHolder = ""
        }
        enabledResetpassWord()
    }

    private fun enabledResetpassWord() {
        saveButton.value = passwordNubmber.value == true &&
                passwordUpperCase.value == true &&
                passwordLength.value == true &&
                passwordHolder == confirmPasswordHolder
    }


    fun clearStateChangePassword() {
        saveButton.value = false
        passwordNubmber.value = false
        passwordUpperCase.value = false
        passwordLength.value = false
    }

    fun changePassword (password: String) {
        if (passwordLiveData.value == "") {
            val retrofit = RetrofitClient.getInstance()
            val apiInterface = retrofit.create(ApiInterface::class.java)
            viewModelScope.launch {
                try {
                    val response = apiInterface.changePassword(ChangePasswordDto(password = password,passwordConfirmation=password))
                    if (response.isSuccessful()) {
                        saveButton.value = true
                        Log.e("save ", response.message())
                    } else {
                        val error = response.errorBody()?.charStream()?.readText().toString()
                        saveButton.value = (JSONObject(error).getString("message") ?: "UnKnow Error") as Boolean?
                        Log.e("save ", response.errorBody().toString())
                    }
                } catch (Ex: Exception) {
                    Log.e("Error", Ex.localizedMessage)
                }

            }
        }
    }
}
