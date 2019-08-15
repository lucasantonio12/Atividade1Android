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

        var params = intent.extras
        var img = params?.getInt("imagemCod")

        when(img){
            1 ->{
                    imageView.setImageResource(R.drawable.im1)
            }

            2->{
                    imageView.setImageResource(R.drawable.im2)
            }

            3->{
                    imageView.setImageResource(R.drawable.im4)
            }
        }

        cancelarButton.setOnClickListener{
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        confirmButon.setOnClickListener {
            var i = Intent()
            i.putExtra("DADOS_RESPOSTA",digiteEdit.text.toString())
            setResult(Activity.RESULT_OK,i)
            finish()

        }

    }

}
