package com.android.redpencil_participantapp

import android.net.Uri
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask

class Database() {
private val firebaseDatabase : FirebaseDatabase
private val messagesDatabaseReference : DatabaseReference
private val firebaseStorage : FirebaseStorage
private val msgImageReference : StorageReference

//Initializer Block.
    init {
        firebaseDatabase = FirebaseDatabase.getInstance()
        messagesDatabaseReference = firebaseDatabase.reference.child("Messages")
        firebaseStorage = FirebaseStorage.getInstance()
        msgImageReference = firebaseStorage.reference.child("Chat_Photos")
    }

    public fun addMessage(message : Message) : Unit {
        //ADD MESSAGE TO DATABASE
    }

    public fun addPhoto() {
        //BONUS
        //ADD PHOTO TO DB
    }

    public fun readMessage() : Unit {
        //READ MESSAGES FROM DATABASE
    }

    public fun deleteMessage() {
        //BONUS
        //DELETE MESSAGES FROM DB
    }

}