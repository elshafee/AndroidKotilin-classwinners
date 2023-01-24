package com.elshafee.androidclasswin.auth

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elshafee.androidclasswin.MainActivity
import com.elshafee.androidclasswin.auth.model.ProfileInformation
import com.elshafee.androidclasswin.databinding.ActivityProfileBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

private const val REQUEST_CODE_IMAGE_PICK = 0

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private val profileInformationCollectionRef =
        Firebase.firestore.collection("ProfileInformation")

    val imgRefrence = Firebase.storage.reference
    lateinit var profileData: ProfileInformation
    var currentImage: Uri? = null
    var cureentImg: Bitmap? = null
    var username:String = ""
    var phone:String = ""
    var email:String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageView2.setOnClickListener {
            retrieveProfileDetailsData()
            if (currentImage != null && cureentImg == null) {
                CoroutineScope(Dispatchers.IO).launch {
                    try {

                        currentImage?.let {
                            imgRefrence.child("images/$username").putFile(it).await()

                            withContext(Dispatchers.Main){
                                Toast.makeText(this@ProfileActivity,"Image Uploaded Succefully",Toast.LENGTH_LONG).show()
                            }
                        }
                    }catch (e:Exception){
                        Toast.makeText(this@ProfileActivity,e.message,Toast.LENGTH_LONG).show()

                    }

                }
            }else{
                binding.imageView2.setImageBitmap(cureentImg)
                Intent(Intent.ACTION_GET_CONTENT).also {
                    it.type = "image/*"
                    startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
                }
            }

        }

        binding.btnHome.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        retrieveProfileDetailsData()
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK) {
            data?.data.let {
                currentImage = it
                binding.imageView2.setImageURI(currentImage)
            }
        }
    }


    private fun retrieveProfileDetailsData() {

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val querySnapshot = profileInformationCollectionRef.get().await()

                for (document in querySnapshot.documents) {
                    val profileInformation = document.toObject<ProfileInformation>()
                    if (profileInformation != null) {
                            username = profileInformation.fullName
                            email = profileInformation.email
                            phone = profileInformation.phoneNumber

                    }
                }
                val maxDawonloadSizeByte = 5L * 1024 * 1024
                val imgByte = imgRefrence.child("images/$username").getBytes(maxDawonloadSizeByte).await()


                withContext(Dispatchers.Main) {
                    binding.tvFullName.text = username
                    binding.tvPhone.text = phone
                    binding.tvEmail.text = email
                    cureentImg = BitmapFactory.decodeByteArray(imgByte,0,imgByte.size)

                    Toast.makeText(
                        this@ProfileActivity, "Data Retreived Succefully", Toast.LENGTH_LONG
                    ).show()
                }


            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ProfileActivity, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}