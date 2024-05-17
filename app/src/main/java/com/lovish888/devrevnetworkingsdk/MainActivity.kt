package com.lovish888.devrevnetworkingsdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lovish888.devrev.networking.ApiRequest

data class Response(
    val time: Time,
    val disclaimer: String,
)

data class Time(
    val updated: String,
    val updatedISO: String,
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sample API Request
        ApiRequest.get<Response>(
            url = "https://api.coindesk.com/v1/bpi/currentprice.json",
            onSuccess = {result ->
                // Handle result
                Log.d("Log", "Result: $result")
            },
            onFailure = {error ->
                Log.d("Log", "Error Occurred: " + error.message)
            }
        )
    }


}