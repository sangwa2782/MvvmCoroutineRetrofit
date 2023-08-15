package com.ajayam.mvvmcoroutineretrofit.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ajayam.mvvmcoroutineretrofit.Model.User
import com.ajayam.mvvmcoroutineretrofit.Repository.UserRepository

class UserViewModel: ViewModel() {

    fun insert(context: Context, user: User) {
        UserRepository.insert(context,user)
    }

    fun getAllUserData(context: Context):LiveData<List<User>>?
    {
        return UserRepository.getAlluserData(context)
    }

}