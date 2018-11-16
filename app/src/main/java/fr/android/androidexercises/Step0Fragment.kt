package fr.android.androidexercises

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class Step0Fragment : Fragment() {

    companion object {
        private const val STEP_0 = "This is step 0"
    }

    private var textView: TextView? = null
    private var listener: OnNextStep0Listener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        // TODO cast context to listener
        when (context) {
            is OnNextStep0Listener -> listener = context
            else -> throw Exception("C'est la mort")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_step0, container, false)

        // TODO find TextView and set text
        textView = view.findViewById(R.id.textView)
        textView?.text = STEP_0
        // TODO find Button and set listener
        val nextButton: Button
        nextButton = view.findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            // TODO call listener
            listener?.onNext()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO setText(STEP_0)
        var textview = view.findViewById<TextView>(R.id.textView)
        textview.text = STEP_0
    }

    interface OnNextStep0Listener {
        fun onNext()
    }// TODO add onNext() method

}
