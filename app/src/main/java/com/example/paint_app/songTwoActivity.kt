package com.example.paint_app

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_song_one.*

class songTwoActivity : AppCompatActivity() {

    lateinit var runnable: Runnable
    private var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_two)

        val musicplayer = MediaPlayer.create(this, R.raw.bol4)
        bar.progress = 0
        //adding music duration
        bar.max = musicplayer.duration
        play_music.setOnClickListener{
            //checking if the music is playing or not
            if(!musicplayer.isPlaying){
                musicplayer.start()
                play_music.setImageResource(R.drawable.ic_baseline_pause_24)
            }
            else{
                musicplayer.pause()
                play_music.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }

        //changing the song position according to the bar so that when we move the position of the song, it'll move to that part of that song

        bar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, position: Int, moved: Boolean) {
                if(moved){
                    musicplayer.seekTo(position)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        //doing this so that te bar moves along with the songs
        runnable = Runnable {
            bar.progress = musicplayer.currentPosition
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)
        //doing this so that the bar goes back to the starting position when the song is finished
        musicplayer.setOnCompletionListener {
            play_music.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            bar.progress=0
        }
    }
}