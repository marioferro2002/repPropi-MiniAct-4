package udl.eps.reproductormusicapropio

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastReciever : BroadcastReceiver() {
    
    var serviceIntent: Intent? = null

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        when (action) {
            "PLAY_FLOR" -> {
                playSong(context, "flor")
            }
            "PLAY_SEGADORS" -> {
                playSong(context, "segadors")
            }
            "PLAY_LOVE" -> {
                playSong(context, "love")
            }
            "PLAY_BALLIN" -> {
                playSong(context, "ballin")
            }
            "STOP_PLAYBACK" -> {
                stopPlayback(context)
            }
        }
    }
    

    
    private fun playSong(context: Context, song: String) {
        serviceIntent = Intent(context, ElServicio::class.java)
        serviceIntent!!.putExtra("sound_type", song)
        context.startService(serviceIntent!!)
        Toast.makeText(
            context,
            "BroadcastReceiver - Inicio reproducción canción",
            Toast.LENGTH_LONG
        ).show()
    }
    
    private fun stopPlayback(context: Context) {
        serviceIntent?.let { context.stopService(serviceIntent!!) }
        Toast.makeText(
            context,
            "BroadcastReceiver - Detencion reproduccion",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun headSetPlugIn(context: Context) {
        Toast.makeText(context, "BroadcastReceiver - HEADSET_PLUG-ON", Toast.LENGTH_SHORT).show()
        serviceIntent = Intent(context, ElServicio::class.java)
        serviceIntent!!.putExtra("sound_type", "song")
        context.startService(serviceIntent!!)
        Toast.makeText(
            context,
            "BroadcastReceiver - Inicio reproducción canción",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun headSetPlugOut(context: Context) {
        Toast.makeText(
            context,
            "BroadcastReceiver - HEADSET_PLUG-OFF",
            Toast.LENGTH_SHORT
        ).show()
        serviceIntent?.let { context.stopService(serviceIntent!!) }
        Toast.makeText(
            context,
            "BroadcastReceiver - Detencion reproduccion",
            Toast.LENGTH_LONG
        ).show()
    }
}