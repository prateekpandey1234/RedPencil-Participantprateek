package com.android.redpencil_participantapp

import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageList: ArrayList<Message>
    private lateinit var layoutManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var messageEditText : EditText = findViewById(R.id.messageEditText)
        val msgPhotoPickerImageView : ImageView = findViewById(R.id.photoPickerButton)
        val sendBtn : Button = findViewById(R.id.sendButton)
        val progressBar : ProgressBar = findViewById(R.id.progressBar)
        messageList = ArrayList()

        val sharedPrefs : SharedPreferences = getSharedPreferences("username", MODE_PRIVATE)
        val userName : String = sharedPrefs.getString("name", "")!!

        setupRecyclerViewAndAdapter()

        //READ MESSAGES FROM DATABASE AND UPDATE UI

        val msgPhotoPicker : ActivityResultLauncher<String> =
            registerForActivityResult(ActivityResultContracts.GetContent(),
                ActivityResultCallback<Uri>(){
                    //BONUS:
                    //PICK PHOTO FOR MESSAGE FROM LOCAL STORAGE
            })

        msgPhotoPickerImageView.setOnClickListener(View.OnClickListener {
        })


        sendBtn.setOnClickListener(View.OnClickListener {
            if (messageEditText.text.toString().isNotEmpty()) {
                val sdf : SimpleDateFormat = SimpleDateFormat("HH:mm")
                val timeOfMessage : String = sdf.format(Date())

                //ADD MESSAGE TO DATABASE
            }
        })
    }

    private fun setupRecyclerViewAndAdapter() {
        recyclerView = findViewById(R.id.msgRecyclerView)
        layoutManager = LinearLayoutManager(this)
        messageAdapter = MessageAdapter()

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = messageAdapter
    }
}