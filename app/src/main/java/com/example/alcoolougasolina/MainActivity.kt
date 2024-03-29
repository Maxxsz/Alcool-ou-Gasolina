package com.example.alcoolougasolina

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var etPrecoAlcool: EditText
    lateinit var etPrecoGasolina: EditText
    lateinit var btCalc: Button
    lateinit var textMsg: TextView
    var swPercentual: Int = 70

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            swPercentual=savedInstanceState.getInt("swPercentual")
        }

        etPrecoAlcool = findViewById(R.id.edAlcool)
        etPrecoGasolina = findViewById(R.id.edGasolina)
        btCalc = findViewById(R.id.btCalcular)
        textMsg = findViewById(R.id.textMsg)

        val switch = findViewById<Switch>(R.id.swPercentual)

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            swPercentual = if (isChecked) { 75 } else { 70 }
        }

        btCalc.setOnClickListener {
            val precoAlcoolText = etPrecoAlcool.text.toString()
            val precoGasolinaText = etPrecoGasolina.text.toString()

            if (precoAlcoolText.isNotEmpty() && precoGasolinaText.isNotEmpty()) {
                val precoAlcool = precoAlcoolText.toDouble()
                val precoGasolina = precoGasolinaText.toDouble()

                val percentual = precoAlcool / precoGasolina * 100

                if (percentual <= swPercentual) {
                    textMsg.text = "É mais vantajoso abastecer com álcool."
                } else {
                    textMsg.text = "É mais vantajoso abastecer com gasolina."
                }
            } else {
                textMsg.text = "Por favor, insira os valores de preço do álcool e da gasolina."
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val savedResult: String = textMsg.text.toString()
        outState.putString("savedResult", textMsg.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle ) {
        super.onRestoreInstanceState(savedInstanceState)

        val savedString = savedInstanceState.getString("savedResult", "Por favor, insira os valores de preço do álcool e da gasolina.")
        textMsg.text = savedString
    }
}