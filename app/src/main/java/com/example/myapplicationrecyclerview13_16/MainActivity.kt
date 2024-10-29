package com.example.myapplicationrecyclerview13_16

import adapter.LineAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dataclass.Place


class MainActivity : AppCompatActivity() {

    //criar um array de places para preencher o recyclerview
    private lateinit var myList: ArrayList<Place>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //criar uma lista de lugares para visitar
        myList = ArrayList<Place>()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


        //Add elements to the list of places to visit in the activity 500 array
        for (i in 0 until 500) {
            myList.add(Place("Country $i"
                , i*500, "Capital $i"))
        }

        val recycler_view: RecyclerView = findViewById(R.id.recycler_view)
        recycler_view.adapter = LineAdapter(myList)
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
    }
