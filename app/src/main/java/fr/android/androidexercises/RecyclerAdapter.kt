package fr.android.androidexercises

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RecyclerAdapter(context: Context, val books: List<Book>) : RecyclerView.Adapter<MyViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder =
            MyViewHolder(inflater.inflate(R.layout.custom_view_item_book,
                parent,
                false))

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, position: Int) {
        val view = p0.itemView
        when (view) {
            is BookItemView -> view.bindView(books[position])
        }
    }

}

class MyViewHolder(v: View): RecyclerView.ViewHolder(v)