package io.github.Axis567_lang.yutuplays

// API : AIzaSyAezV8m_Je3TvoZEOBTf2PeAdjYxCCNGew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

const val YT_VID_ID_KEY = "AW5v4Ohxk5k"
const val PLAYLIST_ID_KEY = "PL-me8j1U9xxLK-iygSIXidC_GP378TNjs"

class yutuActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    val TAG = "YutuActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_yutu)

        val layout = layoutInflater.inflate(R.layout.activity_yutu, null) as ConstraintLayout
        setContentView(layout)

        /*      TEST CODE FOR LAYOUT
        val button1 = Button(this)
        button1.layoutParams = ConstraintLayout.LayoutParams(600, 100)
        button1.text = "Button added"
        layout.addView(button1)
        */

        val playerView = YouTubePlayerView(this)
        playerView.layoutParams = ConstraintLayout.LayoutParams (
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        layout.addView(playerView)

        playerView.initialize(getString(R.string.GOOGLE_API_KEY), this)
    }
//          provider, player, wasRestoresd -> YT Documentation
    /*
    * Parameters
provider	The provider which was used to initialize the YouTubePlayer.
player	    A YouTubePlayer which can be used to control video playback in the provider.
wasRestored	Whether the player was restored from a previously saved state, as part of the
*           YouTubePlayerView or YouTubePlayerFragment restoring its state. true usually means
*           playback is resuming from where the user expects it would, and that a new video should
*           not be loaded.
    * */
    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?, player: YouTubePlayer?, wasRestored: Boolean
    )
    {
        Log.d(TAG, "onInitializationSuccess")
        Toast.makeText(this, "Ola Prro", Toast.LENGTH_LONG).show()

        //  INICIALIZAMOS LOS DOS OBJETOS LISTENERS
        player?.setPlaybackEventListener(playbackEventListener)
        player?.setPlayerStateChangeListener(changeStateListener)

        if(!wasRestored)
        {
            player?.cueVideo(YT_VID_ID_KEY)
        }
    }

    override fun onInitializationFailure(
        provider: YouTubePlayer.Provider?, youTubeInitializationResult: YouTubeInitializationResult?
    )
    {
        Log.d(TAG, "onInitializationFailure")
        val REQUEST_CODE = 0
        if(youTubeInitializationResult?.isUserRecoverableError == true)
        {
            youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show()
        }
        else
        {
            Toast.makeText(this, "Error starting player", Toast.LENGTH_LONG).show()
        }
    }

    private val playbackEventListener = object : YouTubePlayer.PlaybackEventListener
    {
        override fun onPlaying()        // play de un vídeo
        {
            Toast.makeText(this@yutuActivity, "Playing", Toast.LENGTH_SHORT).show()
        }

        override fun onPaused() {
            Toast.makeText(this@yutuActivity, "Paused", Toast.LENGTH_SHORT).show()
        }

        override fun onStopped() {

        }

        override fun onBuffering(p0: Boolean) {

        }

        override fun onSeekTo(p0: Int) {

        }
    }

    private val changeStateListener = object : YouTubePlayer.PlayerStateChangeListener
    {
        override fun onLoading() {

        }

        override fun onLoaded(p0: String?) {

        }

        override fun onAdStarted() {
            Toast.makeText(this@yutuActivity, "Ad", Toast.LENGTH_SHORT).show()
        }

        override fun onVideoStarted() {

        }

        override fun onVideoEnded() {
            Toast.makeText(this@yutuActivity, "Finite", Toast.LENGTH_SHORT).show()
        }

        override fun onError(p0: YouTubePlayer.ErrorReason?) {

        }

    }
}