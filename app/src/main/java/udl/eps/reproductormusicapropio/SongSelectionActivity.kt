package udl.eps.reproductormusicapropio

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import udl.eps.reproductormusicapropio.databinding.ActivityMainBinding

class SongSelectionActivity : AppCompatActivity(), View.OnClickListener {

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.btnFin.visibility = View.GONE

        setContentView(binding.root)

        binding.btnFlor.setOnClickListener(this)
        binding.btnSegadors.setOnClickListener(this)
        binding.btnLove.setOnClickListener(this)
        binding.btnBallin.setOnClickListener(this)
    }

    override fun onClick(src: View) {
        val resultIntent = Intent()
        when(src.id) {
            binding.btnFlor.id -> {
                resultIntent.data = Uri.parse("android.resource://" + packageName + "/" + R.raw.flor)
            }
            binding.btnSegadors.id -> {
                resultIntent.data = Uri.parse("android.resource://" + packageName + "/" + R.raw.segadors)
            }
            binding.btnLove.id -> {
                resultIntent.data = Uri.parse("android.resource://" + packageName + "/" + R.raw.love)
            }
            binding.btnBallin.id -> {
                resultIntent.data = Uri.parse("android.resource://" + packageName + "/" + R.raw.ballin)
            }
        }
        setResult(RESULT_OK, resultIntent)
        finish()
    }
}
