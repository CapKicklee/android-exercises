package fr.android.androidexercises

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val openButton = findViewById<Button>(R.id.openButton)

        openButton.setOnClickListener {
            // TODO replace with startActivityForResult() to start BookActivity
            //Toast.makeText(this@LibraryActivity, R.string.toast_todo, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, BookActivity::class.java)
            startActivityForResult(intent, 3000)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // TODO get back book name
        if (requestCode == 3000) {
            if (resultCode == Activity.RESULT_OK) {
                data?.apply { Toast.makeText(this@LibraryActivity, getStringExtra("name"), Toast.LENGTH_LONG).show() }
            }
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

        return if (id == R.id.action_settings) true else super.onOptionsItemSelected(item)
    }
}
