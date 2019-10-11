package com.evoke.practice3.ui

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evoke.practice3.R
import com.evoke.practice3.data.model.User
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user_view.*

class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var mUserList = userList


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_user_view, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = mUserList.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(mUserList[p1])
    }

    fun clear() {

        mUserList = listOf()
        notifyDataSetChanged()
    }

    fun addUsers(userList: List<User>) {
        var size: Int? = userList.size
        Log.e("Size ", "$size")
        mUserList = listOf()
        mUserList = userList
        notifyDataSetChanged()
    }


    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {


        fun bind(_user: User) {
            with(_user) {

                user.text = _user.name
            }
        }

    }
}