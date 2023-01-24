package com.elshafee.androidclasswin.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elshafee.androidclasswin.MainActivity
import com.elshafee.androidclasswin.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()


        binding.btnLogin.setOnClickListener {
            val email: String = binding.etUserName.text.toString()
            val password: String = binding.etPassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this,"SignedIn Succefully",Toast.LENGTH_LONG).show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Authentication Failed", Toast.LENGTH_LONG)
                                .show()
                        }

                    }
            } else {
                Toast.makeText(this, "Please enter your email and password", Toast.LENGTH_LONG)
                    .show()
            }



        }

binding.txRegister.setOnClickListener{
    val intent = Intent(this,SignUpActivity::class.java)
    startActivity(intent)
    finish()
}
    }

    public override fun onStart(){
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}