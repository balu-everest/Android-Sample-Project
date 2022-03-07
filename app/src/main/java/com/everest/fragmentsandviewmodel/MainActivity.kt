package com.everest.fragmentsandviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val secondFragment = SecondFragment()
        //supportFragmentManager
        val transaction2 = supportFragmentManager.beginTransaction()
        transaction2.replace(R.id.second_container, secondFragment)
        transaction2.commit()

        val viewModel = ViewModelProvider(this)[CustomViewModel::class.java]
        viewModel.update.observe(this) { update ->
            showScreen(update)
        }
    }

    private fun showScreen(update: Boolean) {
        if (update) {
            showFragment(R.id.first_container, ThirdFragment(), true)
        } else {
            showFragment(R.id.first_container, FirstFragment())
        }
    }

    private fun showFragment(@IdRes resId: Int, fragment: Fragment, backStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(resId, fragment)
        if (backStack) {
            transaction.addToBackStack("TAG")
        }
        transaction.commit()
    }
}

//LiveData
