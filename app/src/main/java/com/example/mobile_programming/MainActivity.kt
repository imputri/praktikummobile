package com.example.mobile_programming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        panjang= findViewById(R.id.edt_length)
        lebar= findViewById(R.id.edt_width)
        tinggi= findViewById(R.id.edt_height)
        btn= findViewById(R.id.btn_result)
        teks_hasil= findViewById(R.id.result)

        btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id==R.id.result){
            val panjang = panjang.text.toString().trim()
            val lebar = lebar.text.toString().trim()
            val tinggi = tinggi.text.toString().trim()
            val volume = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
            teks_hasil.text = volume.toString()
        }
    }
}