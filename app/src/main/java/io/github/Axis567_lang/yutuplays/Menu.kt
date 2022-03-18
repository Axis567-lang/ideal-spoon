package io.github.Axis567_lang.yutuplays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.youtube.player.YouTubeIntents.createOpenPlaylistIntent
import com.google.android.youtube.player.YouTubeStandalonePlayer

class Menu : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSingle = findViewById<Button>(R.id.playVid)
        val btnPlaylist = findViewById<Button>(R.id.playPlay)

        //      FIRST VERSION
        //btnSingle.setOnClickListener(object : View.OnClickListener
        //{
        //    override fun onClick(p0: View?) {
        //        TODO("Not yet implemented")
        //    }
        //})

        //      SECOND VERSION : LAMBDA. OBVIA LA CREACIÓN DEL OBJETO
        //btnSingle.setOnClickListener(View.OnClickListener { p0 -> TODO("webos") })

        //      THIRD VERSION
        btnSingle.setOnClickListener(this)
        btnPlaylist.setOnClickListener(this)
    }

    override fun onClick(view: View)
    {
        val intent = when(view.id)
        {
            R.id.playVid -> YouTubeStandalonePlayer.createVideoIntent(
                this, getString(R.string.GOOGLE_API_KEY), YT_VID_ID_KEY
            )
            R.id.playPlay -> YouTubeStandalonePlayer.createPlaylistIntent(
                this, getString(R.string.GOOGLE_API_KEY), PLAYLIST_ID_KEY
            )
            else -> throw IllegalArgumentException("InvalidButton")
        }
        startActivity(intent)       // un intent es para darle "punto de entrada" a una actividad
                                    // o sea, desde actividad X puedes launchear a la actividad Y
    }
}