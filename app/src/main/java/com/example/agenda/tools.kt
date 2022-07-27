package com.example.agenda

import android.widget.Toast
import androidx.fragment.app.Fragment

const val DATABASE = "AddressBook.db"

fun Fragment.toast(text:String, length:Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this.context, text, length).show()
}