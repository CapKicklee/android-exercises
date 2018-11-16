package fr.android.androidexercises

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Step1Fragment : Fragment() {

    companion object {
        private const val STEP_1 = "This is step 1"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_step1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var textview = view.findViewById<TextView>(R.id.step1TextView)
        textview.text = Step1Fragment.STEP_1
    }
}
