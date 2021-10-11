package com.yash.recyclerexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var RecyclerView : RecyclerView
    lateinit var lyrics : Array<String>
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


        var adapter = MyAdapter(songsObjects)
        RecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                //Toast.makeText(this@MainActivity,"Clicked $position",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity,LyricsActivity::class.java)
                intent.putExtra("title",songsObjects[position].title)
                intent.putExtra("description",songsObjects[position].description)
                intent.putExtra("lyrics",lyrics[position])
                startActivity(intent)

            }

        })
        RecyclerView.layoutManager = LinearLayoutManager(this)



    }
}