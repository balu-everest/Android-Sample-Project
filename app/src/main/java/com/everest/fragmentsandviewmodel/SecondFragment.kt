package com.everest.fragmentsandviewmodel

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.lang.RuntimeException

class SecondFragment : Fragment(R.layout.second_fragment){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = activity?.let { ViewModelProvider(it)[CustomViewModel::class.java] } ?: throw RuntimeException("Not a Activity")

        val increaseButton = view.findViewById<Button>(R.id.increaseButton)
        increaseButton.setOnClickListener {
            viewModel.incrementCount()
        }

        val updateButton = view.findViewById<Button>(R.id.updateButton)
        updateButton.setOnClickListener {
            viewModel.showUpdateScreen()
        }
    }
}