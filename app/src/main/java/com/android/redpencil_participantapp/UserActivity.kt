package com.android.redpencil_participantapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class UserActivity : AppCompatActivity() {

    private lateinit var userNameEditText: EditText
    private lateinit var submitBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        userNameEditText = findViewById(R.id.userName)
        submitBtn = findViewById(R.id.submitBtn)

        var sharedPreferences : SharedPreferences = getSharedPreferences("username", MODE_PRIVATE)
        var editor : SharedPreferences.Editor = sharedPreferences.edit()

        if (sharedPreferences.getBoolean("loggedIn", false)) {
            //loggedIn
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        submitBtn.setOnClickListener(View.OnClickListener {
            editor.putString("name", userNameEditText.text.toString())
            editor.putBoolean("loggedIn", true)
            editor.apply()

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        })

    }
}