package com.yash.recyclerexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    lateinit var lyrics : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.songList)
        val songsObjects : MutableList<Song> = mutableListOf<Song>()

        songsObjects.add(Song("Tum Hi ho","Aashiqui 2 Popular Song"))
        songsObjects.add(Song("Chahun Main Ya Naa","Aashiqui 2 Popular Song"))
        songsObjects.add(Song("Raabta","Agent Vinod Popular Song"))
        songsObjects.add(Song("Galiyan","Ek Villian Popular Song"))
        songsObjects.add(Song("Baarish","Yaariyan Popular Song"))
        songsObjects.add(Song("Sunny Sunny","Yaariyan Popular Song"))
        songsObjects.add(Song("Bekhayali","Kabir Singh Popular Song"))
        songsObjects.add(Song("Tera Ban Jaunga","Kabir Singh Popular Song"))
        songsObjects.add(Song("Pehla Pyaar","Kabir Singh Popular Song"))
        songsObjects.add(Song("Kaise Hua","Kabir Singh Popular Song"))
        songsObjects.add(Song("Kaun Tujhe","M.S.Dhoni Untold Story Popular Song"))
        songsObjects.add(Song("Muqabla","Street Dancers Popular Song"))


        lyrics = arrayOf(

            getString(R.string.song_1),
            getString(R.string.song_2),
            getString(R.string.song_3),
            getString(R.string.song_4),
            getString(R.string.song_5),
            getString(R.string.song_6),
            getString(R.string.song_7),
            getString(R.string.song_8),
            getString(R.string.song_9),
            getString(R.string.song_10),
            getString(R.string.song_11),
            getString(R.string.song_12),
        )


        val adapter = MyAdapter(songsObjects)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                Toast.makeText(this@MainActivity,"Clicked $position",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity,LyricsActivity::class.java)
                intent.putExtra("title",songsObjects[position].title)
                intent.putExtra("description",songsObjects[position].description)
                intent.putExtra("lyrics",lyrics[position])
                startActivity(intent)

            }

        })
        recyclerView.layoutManager = LinearLayoutManager(this)



    }
}