package com.evoke.practice3.ui

import android.os.Bundle
import com.evoke.practice3.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment();

    }

    private fun showFragment() {
        var fragment = HomeFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment, HomeFragment.FRAGMENT_NAME)
        fragmentTransaction.addToBackStack(HomeFragment.FRAGMENT_NAME)
        fragmentTransaction.commit()
    }
}
