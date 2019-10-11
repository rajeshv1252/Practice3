package com.evoke.practice3.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evoke.practice3.R
import com.evoke.practice3.data.network.ApiError
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    companion object {
        val FRAGMENT_NAME: String = HomeFragment::class.java.simpleName
    }

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    private val mMainViewModel: HomeViewModel by lazy {

        ViewModelProviders.of(this, mViewModelFactory).get(HomeViewModel::class.java)
    }

    val adapter: UserAdapter by lazy { UserAdapter(listOf()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()


        get.setOnClickListener(View.OnClickListener {
            loadingView.visibility = View.VISIBLE
            with(mMainViewModel) {

                getUsers().observe(this@HomeFragment, Observer {
                    if (it!!.isNotEmpty()) {



                        adapter.clear()
                        adapter.addUsers(it!!)
                        loadingView.visibility = View.GONE


                    }

                })

                error.observe(this@HomeFragment, Observer {
                    var apiError: ApiError = it!!

                    Log.e("Error", apiError.message)
                })
            }


        })
    }

    fun initView() {
        userRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL
                , false)
        userRecycler.adapter = adapter
    }

}