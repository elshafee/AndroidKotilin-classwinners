package com.elshafee.androidclasswin

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.window.SplashScreen
import androidx.annotation.RequiresApi
import com.elshafee.androidclasswin.auth.LoginActivity
import com.elshafee.androidclasswin.auth.ProfileActivity
import com.elshafee.androidclasswin.breakingbadapi.ui.BreakingBadActivity
import com.elshafee.androidclasswin.firebasenotification.ui.CloudMessaging
import com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem
import com.elshafee.androidclasswin.shoppingitemlist.ui.ShoppingActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var auth:FirebaseAuth

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        val sinout = findViewById<Button>(R.id.btnSignout)
        val profile = findViewById<Button>(R.id.btnProfile)
        val shoppingitem = findViewById<Button>(R.id.btnShoppingItemlistapp)
        val breakingBad = findViewById<Button>(R.id.btnBreakingBad)
        val notification = findViewById<Button>(R.id.btnnotification)


        sinout.setOnClickListener{
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        shoppingitem.setOnClickListener{
            val intent = Intent(this, ShoppingActivity::class.java)
            startActivity(intent)
        }
        breakingBad.setOnClickListener {
            val intent = Intent(this, BreakingBadActivity::class.java)
            startActivity(intent)
        }
        notification.setOnClickListener {
            val intent = Intent(this, CloudMessaging::class.java)
            startActivity(intent)
        }




    }
}