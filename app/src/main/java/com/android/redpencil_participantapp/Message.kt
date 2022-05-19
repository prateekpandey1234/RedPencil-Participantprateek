package com.android.redpencil_participantapp

data class Message(
    var messageText: String? = "",
    var senderName: String = "",
    var photoUrl: String? = "",
    var time: String = "")