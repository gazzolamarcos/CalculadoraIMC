package com.example.omeuprimeiroprojeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnCalcular: Button=findViewById(R.id.btnCalcular)
        val edtPeso: EditText=findViewById(R.id.edittextPeso)
        val edtAltura: EditText=findViewById(R.id.edittextAltura)

        btnCalcular.setOnClickListener{

            val alturaStr=edtAltura.text.toString()
            val pesoStr=edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){

                val altura: Float=alturaStr.toFloat()
                val peso: Float=pesoStr.toFloat()

                val alturaFinal: Float=altura*altura
                val result: Float=peso/alturaFinal

                val intResult = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intResult)
            }else{
                Toast.makeText(this, "Preencher todos os campos!", Toast.LENGTH_LONG).show()
            }
        }
    }
}