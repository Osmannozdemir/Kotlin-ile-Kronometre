package com.osmanozdemir.kronometre

import android.app.Activity
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.renderscript.ScriptGroup
import android.text.Layout
import android.view.View
import com.google.android.material.progressindicator.BaseProgressIndicator
import com.osmanozdemir.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var zamaniDurdur: Long = 0
        binding.btnStart.setOnClickListener {
            binding.kronometre.base=SystemClock.elapsedRealtime()+zamaniDurdur
            binding.kronometre.start()
            binding.btnStart.visibility = View.GONE
            binding.btnPause.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))

        }


        binding.btnPause.setOnClickListener {
            zamaniDurdur = binding.kronometre.base-SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

        }

        binding.btnReset.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            zamaniDurdur = 0
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

        }
    }


}