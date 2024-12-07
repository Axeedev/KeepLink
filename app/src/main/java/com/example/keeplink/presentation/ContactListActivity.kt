package com.example.keeplink.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.keeplink.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ContactListActivity : AppCompatActivity() {

    private lateinit var addContactFAB: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_list)
        initViews()
        addListeners()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initViews() {
        addContactFAB = findViewById(R.id.fab)
    }

    private fun addListeners() {
        addContactFAB.setOnClickListener {
            val intent = AddContactActivity.newIntent(this)
            startActivity(intent)
        }
    }
    companion object{
        fun newIntent(context: Context) : Intent
        {
            return Intent(context, ContactListActivity::class.java)
        }
    }

}