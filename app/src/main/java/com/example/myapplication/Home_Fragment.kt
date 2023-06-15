package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Home_Fragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.Home_Fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSave.setOnClickListener {
            val firstName = editTextFirstName.text.toString()
            val lastName = editTextLastName.text.toString()
            val gpa = editTextGPA.text.toString()

            val bundle = Bundle().apply {
                putString("firstName", firstName)
                putString("lastName", lastName)
                putString("gpa", gpa)
            }

            val profileFragment = Profile_Fragment().apply {
                arguments = bundle
            }

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, profileFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}