package fr.android.androidexercises

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text

class BookAdapter(context: Context, private val books: List<Book>) : BaseAdapter() {

    private var inflater: LayoutInflater? = null

    init {
        // TODO LayoutInflater.from()
        inflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return books.count()
    }

    override fun getItem(position: Int): Book? {
        return books[position]
    }

    override fun getItemId(position: Int): Long {
        return books[position].hashCode().toLong()
    }

    // Il faut ajouter un '?' au View en paramètre car il peut être null au moment de l'initialisation du tableau
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var view = convertView
        if (view == null) {
            view = inflater?.inflate(R.layout.custom_view_item_book, parent, false)
            // !! permet de faire des appels en s'assurant qu'on a un objet (et donc éviter de retourner un optional)
            view!!.tag = BookViewHolder(view!!.findViewById(R.id.nameTextView), view!!.findViewById(R.id.priceTextView))
        }
        val book = getItem(position)
        val bookViewHolder: BookViewHolder = view?.tag as BookViewHolder
        bookViewHolder.titleView.text = book?.name
        bookViewHolder.priceView.text = book?.price.toString()
        return view
    }

    data class BookViewHolder(val titleView: TextView, val priceView: TextView)

}
