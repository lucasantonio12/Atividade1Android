package com.example.projeto1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var MY_RESULT_CODE = 99

    var REQUESTCODE1 = 1
    var REQUESTCODE2 = 2
    var REQUESTECODE3 = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var i = Intent(this,Main2Activity::class.java)

        var result1 = 0;
        var result2 = 0;
        var result3 = 0;


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i("TAG","request code = $requestCode,result code = $resultCode")
        when(requestCode){
            MY_RESULT_CODE->{
                when(resultCode){
                    Activity.RESULT_OK->{
                        val param = data?.extras
                        val textoResultado = param?.getString("DADOS_RESPOSTA")
                        Toast.makeText(this,"A resposta é $textoResultado", Toast.LENGTH_LONG).show()
                    }
                    Activity.RESULT_CANCELED->{
                        Toast.makeText(this,"Cancelou", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }


}
