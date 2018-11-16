package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.*

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // Plant logger cf. Android Timber
        Timber.plant(Timber.DebugTree())

        // TODO build Retrofit
        val retrofit = Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        // TODO create a service
        val service = retrofit.create(HenriPotierService::class.java)
        // TODO listBooks()
        val list = service.listBooks()
        // TODO enqueue call and display book title
        list.enqueue(object: Callback<Array<Book>> {
            override fun onFailure(call: Call<Array<Book>>, t: Throwable) {
                //Timber.e(t.message)
            }

            override fun onResponse(call: Call<Array<Book>>, response: Response<Array<Book>>) {
                response.body()?.forEach {
                    Timber.i("title : %s", it.title)
                }
            }
        })
        // TODO log books
        list.execute().body()?.forEach {
            Timber.i("%s€", "Book : " + it.title + " - " + it.cover + " - " + it.isbn + " - " + it.price)
        }

        // TODO display book as a list

    }

}
