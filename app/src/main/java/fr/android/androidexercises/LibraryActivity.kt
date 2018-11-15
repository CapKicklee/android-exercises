package fr.android.androidexercises

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import java.util.*

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val openButton = findViewById<Button>(R.id.openButton)

        val book = Book("Garry Whopper", "CK Rowling")

        openButton.setOnClickListener { v ->
            val intent = Intent(this@LibraryActivity, BookActivity::class.java)
            // TODO add parcel book to intent
            intent.putExtra(BookActivity.BOOK, book)
            startActivity(intent)
        }

        val dateButton = findViewById<Button>(R.id.dateButton)
        dateButton.setOnClickListener { v ->
            var date = ""
            val calendar = Calendar.getInstance()
            DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                        TimePickerDialog(this@LibraryActivity, TimePickerDialog.OnTimeSetListener {
                            _, hourOfDay, minute ->
                            Toast.makeText(this, "$dayOfMonth/$month/$year $hourOfDay:$minute", Toast.LENGTH_LONG).show()
                        }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), true).show()
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)).show()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_library, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        return when (id) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }

    }
}
