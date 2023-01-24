package com.elshafee.androidclasswin.firebasenotification.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elshafee.androidclasswin.databinding.ActivityCloudMessagingBinding
import com.elshafee.androidclasswin.firebasenotification.model.NotificationData
import com.elshafee.androidclasswin.firebasenotification.model.PushNotification
import com.elshafee.androidclasswin.firebasenotification.services.FirebaseService
import com.elshafee.androidclasswin.firebasenotification.services.Retrofitinstance
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val TOPIC = "/topics/mytopic"

class CloudMessaging : AppCompatActivity() {
    val TAG = "CloudMessagingApp"
    lateinit var binding: ActivityCloudMessagingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCloudMessagingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseService.sharedPref = getSharedPreferences("sharedPrefFile", Context.MODE_PRIVATE)
        FirebaseMessaging.getInstance().token.addOnSuccessListener {
            FirebaseService.token = it
            binding.etNotificationToken.setText(it)
        }
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)


        binding.btnSendNotification.setOnClickListener {
            val notificationTitle = binding.etNotificationTitle.text.toString()
            val notificationMessage = binding.etNotificationMessage.text.toString()
            val recipientToken = binding.etNotificationToken.text.toString()

            if (notificationTitle.isNotEmpty() && notificationMessage.isNotEmpty() && recipientToken.isNotEmpty()){
                PushNotification(NotificationData(notificationTitle,notificationMessage), recipientToken).also {
                    sendNotification(it)
                }
            }
        }

    }

    private fun sendNotification(notification: PushNotification) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val response  = Retrofitinstance.api.postNotification(notification)
            if (response.isSuccessful){
                Log.d(TAG,"done ")
            }else{
                Log.d(TAG,"Error ${response.errorBody().toString()}")
            }

        }
        catch (e:Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(this@CloudMessaging,e.message,Toast.LENGTH_LONG).show()
            }
        }
    }
}