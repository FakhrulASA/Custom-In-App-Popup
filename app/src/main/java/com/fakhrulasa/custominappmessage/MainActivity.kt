package com.fakhrulasa.custominappmessage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    lateinit var db:FirebaseFirestore
    lateinit var button:Button
    lateinit var popupDialog:PopupDialog
    var appData="2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db= FirebaseFirestore.getInstance()
        button=findViewById(R.id.button)
        popupDialog= PopupDialog()


        val docRef = db.collection("popup").document("payload")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("DataSnapGOT", "DocumentSnapshot data: ${document.data?.get("link")} \n ${document.data?.get("id")}")
                    if(appData != document.data?.get("id").toString().trim()){
                        popupDialog.showDialog(this){
                            val intent =
                                Intent(document.data?.get("link").toString()).setPackage(
                                    packageName
                                )
                             startActivity(intent)
                        }
                    }
                } else {
                    Log.d("DataSnapGOT", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("DataSnapGOT", "get failed with ", exception)
            }

    }
}