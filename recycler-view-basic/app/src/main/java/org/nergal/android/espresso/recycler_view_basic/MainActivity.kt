package org.nergal.android.espresso.recycler_view_basic

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val textView = findViewById<TextView>(R.id.text)
        textView.setBackgroundColor(Color.LTGRAY)
        textView.visibility = View.GONE

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NumberedAdapter(
                30,
                object : NumberedAdapter.OnItemClickListener {
                    override fun onItemClick(position: Int) {
                        textView.text = position.toString()
                        textView.visibility = View.VISIBLE
                    }
                }
        )
    }
}