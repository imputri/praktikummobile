package com.example.mobile_programming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var panjang: EditText
    private lateinit var lebar: EditText
    private lateinit var tinggi: EditText
    private lateinit var btn: Button
    private lateinit var teks_hasil: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        panjang = findViewById(R.id.edt_length)
        lebar = findViewById(R.id.edt_width)
        tinggi = findViewById(R.id.edt_height)
        btn = findViewById(R.id.btn_result)
        teks_hasil = findViewById(R.id.result)
        btn.setOnClickListener(this)

        if (savedInstanceState != null) {
            teks_hasil.text = savedInstanceState.getString(STATE_RESULT)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, teks_hasil.text.toString())
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_result) {
            val panjangText = panjang.text.toString().trim()
            val lebarText = lebar.text.toString().trim()
            val tinggiText = tinggi.text.toString().trim()

            if (panjangText.isNotEmpty() && lebarText.isNotEmpty() && tinggiText.isNotEmpty()) {
                val panjangValue = panjangText.toDouble()
                val lebarValue = lebarText.toDouble()
                val tinggiValue = tinggiText.toDouble()
                val volume = panjangValue * lebarValue * tinggiValue
                teks_hasil.text = volume.toString()
            } else {
                teks_hasil.text = "Mohon isi semua input"
            }
        }
    }
}
