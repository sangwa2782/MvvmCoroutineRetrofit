package com.ajayam.mvvmcoroutineretrofit.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.ajayam.mvvmcoroutineretrofit.Database.UserDatabase
import com.ajayam.mvvmcoroutineretrofit.Model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepository {

    companion object {
        private var userDatabase:UserDatabase?=null
        fun initaliseDB(context: Context): UserDatabase? {
            return  UserDatabase.getInstance(context)
        }

        fun insert(context: Context,user:User){
            userDatabase = initaliseDB(context)
            CoroutineScope(IO).launch {
                userDatabase?.getDao()?.insert(user)
            }
        }

        fun  getAlluserData(context: Context):LiveData<List<User>>? {
            userDatabase= initaliseDB(context)
            return userDatabase?.getDao()?.getAllUserData()
        }

    }
}