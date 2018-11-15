package fr.android.androidexercises

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class BookActivity : AppCompatActivity() {

    private val bookName = "Garry Whopper"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        val messageTextView = findViewById<TextView>(R.id.messageTextView)
        messageTextView.text = bookName

        val sendNameButton = findViewById<Button>(R.id.sendNameButton)
        sendNameButton.setOnClickListener {
            // TODO set result to book name in intent
            // TODO finish current activity
            val returnIntent = Intent()
            returnIntent.putExtra("name", bookName)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}
