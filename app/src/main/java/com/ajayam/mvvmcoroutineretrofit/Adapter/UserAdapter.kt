package com.ajayam.mvvmcoroutineretrofit.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ajayam.mvvmcoroutineretrofit.Model.User
import com.ajayam.mvvmcoroutineretrofit.R

class UserAdapter(private  val context: Context, private var userList:ArrayList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user:User = userList[position]
        holder.name.text=user.name
        holder.age.text=user.age.toString()
    }

    fun setData(userList: ArrayList<User>)
    {
        this.userList=userList
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val name:TextView=itemView.findViewById(R.id.name)
        val age:TextView=itemView.findViewById(R.id.age)
    }
}