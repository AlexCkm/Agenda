package com.example.agenda

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(text:String, length:Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this.context, text, length).show()
}