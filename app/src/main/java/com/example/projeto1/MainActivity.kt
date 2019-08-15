package com.example.projeto1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var REQUESTCODE1 = 100
    var REQUESTCODE2 = 101
    var REQUESTECODE3 = 102

    var result1:Int? = 0;
    var result2:Int? = 0;
    var result3:Int? = 0;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultT1.text = ("$result1")
        resultT2.text = ("$result2")
        resultT3.text = ("$result3")


        verificarButton.setOnClickListener {
            result1 = resultT1.text.toString().toInt()
            result2 = resultT2.text.toString().toInt()
            result3 = resultT3.text.toString().toInt()

            if(result1 == 2 && result2 == 74 && result3 == 5){
                resultFinal.text = ("Você não é daltonico")

            }else{
                resultFinal.text = ("Você é daltonico")

            }
        }
    }

    fun clique(v:View){
        var codImagem = 0
        var codRequest = 0

        var i = Intent(this,Main2Activity::class.java)
        when(v.id){
            R.id.button1->{
                codImagem = 1
                codRequest = REQUESTCODE1
            }

            R.id.button2->{
                codImagem = 2
                codRequest = REQUESTCODE2
            }
            R.id.button3->{
               codImagem = 3
                codRequest = REQUESTECODE3
            }
        }

        i.putExtra("imagemCod",codImagem)
        startActivityForResult(i,codRequest)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i("TAG","request code = $requestCode, result code = $resultCode")
        when(requestCode){
            REQUESTCODE1->{
                when(resultCode) {
                    Activity.RESULT_OK ->{
                        val param = data?.extras
                        val resultado = param?.getString("DADOS_RESPOSTA")
                        resultT1.text = resultado.toString()

                        Toast.makeText(this, "Numero inserido com sucesso", Toast.LENGTH_SHORT).show()
                    }
                    Activity.RESULT_CANCELED -> {
                        Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            REQUESTCODE2->{
                when(resultCode) {
                    Activity.RESULT_OK -> {
                        val param = data?.extras
                        val resultado = param?.getString("DADOS_RESPOSTA")
                        resultT2.text = resultado.toString()

                        Toast.makeText(this, "Numero inserido com sucesso", Toast.LENGTH_SHORT).show()
                    }
                    Activity.RESULT_CANCELED -> {
                        Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            REQUESTECODE3->{
                when(resultCode) {
                    Activity.RESULT_OK -> {
                        val param = data?.extras
                        val resultado = param?.getString("DADOS_RESPOSTA")
                        resultT3.text = resultado.toString()

                        Toast.makeText(this, "Numero inserido com sucesso", Toast.LENGTH_SHORT).show()
                    }
                    Activity.RESULT_CANCELED -> {
                        Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
