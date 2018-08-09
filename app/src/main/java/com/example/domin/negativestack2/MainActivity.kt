package com.example.domin.negativestack2

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity;

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.warn


class SomeClass : AnkoLogger {
    suspend fun request(callName : String = "Unknown") : Boolean {

        return async(CommonPool) {
            warn { "Call $callName"}
            true
        }.await()
    }

}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launch {
            SomeClass().request(callName = "Ola")
        }
    }
}
