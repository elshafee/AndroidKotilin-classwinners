package com.elshafee.androidclasswin.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elshafee.androidclasswin.MainActivity
import com.elshafee.androidclasswin.auth.model.ProfileInformation
import com.elshafee.androidclasswin.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    lateinit var auth: FirebaseAuth
    private val profileInformationCollectionRef =
        Firebase.firestore.collection("ProfileInformation")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            val email = binding.etUserName.text.toString()
            val password = binding.etPassword.text.toString()
            val profileInformation = getProfileInformation()
            if (profileInformation != null) {
                saveProfileInformation(profileInformation)
            } else {
                Toast.makeText(this, "Please Fill the required data", Toast.LENGTH_LONG).show()

            }
            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(
                            intent
                        )
                        finish()
                    }
                }
            }
        }
    }

    private fun getProfileInformation(): ProfileInformation {
        val fullName = binding.etFullName.text.toString()
        val email = binding.etUserName.text.toString()
        val password = binding.etPassword.text.toString()
        val phoneNumber = binding.etphone.text.toString()
        return ProfileInformation(fullName, email, phoneNumber, password)
    }

    private fun saveProfileInformation(profileInformation: ProfileInformation) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                profileInformationCollectionRef.add(profileInformation)
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@SignUpActivity,
                        "Data Saved Successfully",
                        Toast.LENGTH_LONG
                    ).show()
                }


            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@SignUpActivity, e.message, Toast.LENGTH_LONG).show()

                }

            }
        }
    }
}