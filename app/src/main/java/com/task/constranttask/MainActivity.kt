package com.task.constranttask

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var etmail: EditText?=null
    var etsub: EditText?=null
    var etbody: EditText?=null
    var etnumb: EditText?=null
    var etmess: EditText?=null
    var btnmove: Button?=null
    var btnsms: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        etmail=findViewById(R.id.etmail)
        etsub=findViewById(R.id.etsub)
        etbody=findViewById(R.id.etbody)
        etnumb=findViewById(R.id.etnumber)
        etmess=findViewById(R.id.etmessage)
        btnmove=findViewById(R.id.btnmove)
        btnsms=findViewById(R.id.btnsms)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnmove?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
                intent.setData(Uri.parse("mailto:"))
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(etmail?.text?.toString()?.trim()))
                intent.putExtra("subject", etsub?.text?.toString()?.trim())
                intent.putExtra("body", etbody?.text?.toString()?.trim())
                startActivity(intent)
        }
        btnsms?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("smsto:${etnumb?.text?.toString()?.trim()}"))
            intent.putExtra("message", etmess?.text?.toString()?.trim())
            startActivity(intent)
        }
    }
}