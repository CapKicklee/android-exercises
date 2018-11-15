package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView

import org.json.JSONException
import org.json.JSONObject

import java.io.IOException

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_library)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val messageTextView = findViewById<TextView>(R.id.messageTextView)

        val client = OkHttpClient()

        val request = Request.Builder()
                .url("https://api.github.com/users/CapKicklee")
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // Does nothing but could log error
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                try {
                    val user = JSONObject(response.body()!!.string())
                    runOnUiThread {
                        try {
                            messageTextView.text = getString(R.string.hello, user.get("name"))
                        } catch (ignored: JSONException) {
                            // Ignored but could be logged
                        }
                    }
                } catch (ignored: JSONException) {
                    // Ignored but could be logged
                }
            }
        })
    }
}
