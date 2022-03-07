package com.everest.fragmentsandviewmodel

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.lang.RuntimeException

class FirstFragment : Fragment(R.layout.first_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = activity?.let { ViewModelProvider(it)[CustomViewModel::class.java] } ?: throw RuntimeException("Not a Activity")

        val firstTV = view.findViewById<TextView>(R.id.firstTV)

        viewModel.count.observe(viewLifecycleOwner) {
            firstTV.text = "Count is $it"
        }

    }

}