package fr.android.androidexercises

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class BookItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
        // TODO findViewById()
    }

    fun bindView(book: Book) {
        // TODO setText()
    }
}
