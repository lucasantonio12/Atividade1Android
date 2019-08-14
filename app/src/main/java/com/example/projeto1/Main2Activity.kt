package com.example.projeto1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        var i = Intent()
        confirmButon.setOnClickListener {
             i.putExtra("DADOS_RESPOSTA", "Deu certo!")
             setResult(Activity.RESULT_OK,i)
             finish()
        }
    }
}
