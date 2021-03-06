package alihanadrian.academy.youtubeplayer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_standalone.*
import java.lang.IllegalArgumentException

class StandAloneActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)

        btnPlayVideo.setOnClickListener(this)
        btnPlayList.setOnClickListener(this)



//       val listener = View.OnClickListener { v ->
//           TODO("Not Implemented")
//       }
//       btnPlayVideo.setOnClickListener(listener)
//        btnPlayList.setOnClickListener(listener)
    }

    override fun onClick(view: View) {
        val intent = when(view.id){
            R.id.btnPlayVideo -> YouTubeStandalonePlayer.createVideoIntent(
                this,getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_ID, 0, true, false)

            R.id.btnPlayList -> YouTubeStandalonePlayer.createPlaylistIntent(
                this,getString(R.string.GOOGLE_API_KEY), YOUTUBE_PLAYLIST,0 , 0 ,true ,true)

            else -> throw IllegalArgumentException("Undefined button Clicked")
        }
        startActivity(intent)
    }
}