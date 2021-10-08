package com.yash.recyclerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var RecyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RecyclerView = findViewById(R.id.songList)
        val songsObjects : MutableList<Song> = mutableListOf<Song>()

        songsObjects.add(Song("Hello","Just the description"))
        songsObjects.add(Song("ABCD","John Lennon"))
        songsObjects.add(Song("Dance","The Rolling Stones"))
        songsObjects.add(Song("Chill","The Beatles"))
        songsObjects.add(Song("Coders Life","Just the description"))
        songsObjects.add(Song("Adayein Bhi Hain Mohobbat","Ok Jaanu"))
        songsObjects.add(Song("Aye Udi Udi","Sathiya"))
        songsObjects.add(Song("Enna Sona","Random Data"))
        songsObjects.add(Song("IT IT IT","Hello"))
        songsObjects.add(Song("Agar Tum Mil Jao","Ok Jaanu"))
        songsObjects.add(Song("Ban Ja Rani","Sulu"))
        songsObjects.add(Song("Mukkabla","Street Dancers"))


        var adapter = MyAdapter(songsObjects)
        RecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                Toast.makeText(this@MainActivity,"Clicked $position",Toast.LENGTH_SHORT).show()

            }

        })
        RecyclerView.layoutManager = LinearLayoutManager(this)



    }
}