package com.example.saudeja22300570

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnConsultar = findViewById<Button>(R.id.btn_consultar)
        btnConsultar.setOnClickListener {
            encontrar();
        }
    }

    fun encontrar(){
        val medicamento = findViewById<EditText>(R.id.medicamento)
        val resultado = findViewById<TextView>(R.id.resultado)
        val nomeMedicamento = medicamento.text.toString().trim()

         val estoqueMedicamentos = mapOf(
            "Paracetamol" to true,
            "Ibuprofeno" to true,
            "Dipirona" to true,
            "Azitromicina" to false,
            "Aspirina" to false
        )
        if (estoqueMedicamentos.containsKey(nomeMedicamento)) {
            val disponivel = estoqueMedicamentos[nomeMedicamento] == true
            if (disponivel) {
                resultado.setText("O medicamento ${nomeMedicamento} está disponível!")
            } else {
                resultado.setText("O medicamento ${nomeMedicamento} não está disponível!")
            }
        }else {
                resultado.setText("O medicamento ${nomeMedicamento} não foi encontrado no sistema!")
            }
        }
}