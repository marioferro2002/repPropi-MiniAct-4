package udl.eps.manejoserviciokotlininc

import android.content.Intent
import android.content.IntentFilter
import android.media.MediaMetadataRetriever
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import udl.eps.manejoserviciokotlininc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var broadcastReciever: BroadcastReciever
    private lateinit var readCSongsReqPermLaunc: ActivityResultLauncher<String>
    
    
    private val filter = IntentFilter()
    init {
        filter.addAction("PLAY_FLOR")
        filter.addAction("PLAY_SEGADORS")
        filter.addAction("PLAY_LOVE")
        filter.addAction("PLAY_BALLIN")
        filter.addAction("STOP_PLAYBACK")
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        broadcastReciever = BroadcastReciever()
        registerReceiver(broadcastReciever, filter)


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnFin.setOnClickListener(this)
        binding.btnFlor.setOnClickListener(this)
        binding.btnSegadors.setOnClickListener(this)
        binding.btnLove.setOnClickListener(this)
        binding.btnBallin.setOnClickListener(this)
    
        readCSongsReqPermLaunc = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                songUri = uri
            }
        }
    
    }

    override fun onDestroy() {
        unregisterReceiver(broadcastReciever)
        super.onDestroy()
    }

    override fun onClick(src: View) {

        when(src.id) {
            binding.btnFlor.id -> {
                val intent = Intent("PLAY_FLOR")
                sendBroadcast(intent)
            }
            binding.btnSegadors.id -> {
                val intent = Intent("PLAY_SEGADORS")
                sendBroadcast(intent)
            }
            binding.btnLove.id -> {
                val intent = Intent("PLAY_LOVE")
                sendBroadcast(intent)
            }
            binding.btnBallin.id -> {
                val intent = Intent("PLAY_BALLIN")
                sendBroadcast(intent)
            }
            binding.btnFin.id -> {
                val intent = Intent("STOP_PLAYBACK")
                sendBroadcast(intent)
            }

        }
    }
}