package my.tv.tvt

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import my.tv.tvt.databinding.ActivityMainBinding
import org.videolan.libvlc.LibVLC
import org.videolan.libvlc.Media
import org.videolan.libvlc.MediaPlayer
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var numCanal = 0

    private var mLibVLC: LibVLC? = null
    private var mMediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onCreateLibVLC()
    }

    private fun onCreateLibVLC() {
        mLibVLC = LibVLC(this, ArrayList<String>().apply {
            add("--no-drop-late-frames")
            add("--no-skip-frames")
            add("--rtsp-tcp")
            add("-vvv")
        })
        mMediaPlayer = MediaPlayer(mLibVLC)
        mMediaPlayer?.attachViews(binding.videoLayout, null, true, false)
        changeCanal()
        binding.videoLayout.setOnClickListener {
            changeCanal(1)
        }
    }

    private fun changeCanal(canalPlus: Int = 0) {
        numCanal += canalPlus
        if (numCanal >= Canals.maxCanal)
            numCanal = 0
        else if (numCanal < 0)
            numCanal += Canals.maxCanal
        vlcPlay(Canals.allCanals[numCanal])
    }

    private fun vlcPlay(httpUrl: String) {
        try {
            val uri = Uri.parse(httpUrl)
            Media(mLibVLC, uri).apply {
                setHWDecoderEnabled(true, false);
                addOption(":network-caching=150");
                addOption(":clock-jitter=0");
                addOption(":clock-synchro=0");
                mMediaPlayer?.media = this

            }.release()

            mMediaPlayer?.play()

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_UP) {
            if (event.keyCode == KeyEvent.KEYCODE_DPAD_UP)
                changeCanal(-1)
            else if (event.keyCode == KeyEvent.KEYCODE_DPAD_DOWN)
                changeCanal(1)
        }
        return super.onKeyUp(keyCode, event)
    }

    override fun onStop() {
        super.onStop()
        mMediaPlayer!!.stop()
        mMediaPlayer!!.detachViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMediaPlayer!!.release()
        mLibVLC!!.release()
    }

}