package com.havan.network

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*


// Created by HaVan on 5/27/2018.

public class FirebaseDataApi (context: Context) {

    fun init(context: Context){
        FirebaseApp.initializeApp(context)
    }

    var db = FirebaseFirestore.getInstance()

    public fun setData(collectionPath: String, documentPath: String, addData: Any) {

        db.collection(collectionPath).document(documentPath)
                .set(addData)
                .addOnSuccessListener {

                }
                .addOnFailureListener {

                }
    }

    public fun updateData(collectionPath: String, documentPath: String, field: String, updateInfo: Objects) {

        db.collection(collectionPath).document(documentPath)
                .update(field, updateInfo)
                .addOnSuccessListener {

                }
                .addOnFailureListener {

                }
    }

    public fun getData(collectionPath: String, returnData: Objects) {
        db.collection(collectionPath)
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result) {
                        }
                    } else {
                    }
                }

    }
}