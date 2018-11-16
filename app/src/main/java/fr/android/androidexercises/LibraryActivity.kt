package fr.android.androidexercises

import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout

class LibraryActivity : AppCompatActivity(), Step0Fragment.OnNextStep0Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        var landscape = resources.getBoolean(R.bool.landscape)

        // TODO replace Step0Fragment in containerFrameLayout
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, Step0Fragment())
                //.addToBackStack(Step0Fragment::class.java.name)
                .commit()
        findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.GONE

        if (landscape) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.containerFrameLayout2, Step1Fragment())
                    .commit()
            findViewById<FrameLayout>(R.id.containerFrameLayout).visibility = View.VISIBLE
            findViewById<FrameLayout>(R.id.containerFrameLayout2).visibility = View.VISIBLE
        }
    }

    // TODO implement onNext() from Step0Fragment.OnNextStep0Listener

    override fun onNext() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, Step1Fragment())
                .addToBackStack(Step0Fragment::class.java.name)
                .commit()

        var landscape = resources.getBoolean(R.bool.landscape)

        if (landscape) {
            findViewById<FrameLayout>(R.id.containerFrameLayout).visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.popBackStack()
    }

}
