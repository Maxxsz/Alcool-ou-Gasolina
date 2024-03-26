package com.example.alcoolougasolina

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("PDM24.1","No onCreate, $percentual")

        percentual=0.7
        val btCalc: Button = findViewById(R.id.btCalcular)
        val textMsg:TextView= findViewById(R.id.textMsg)
        //btCalc.setBackgroundColor(Color.CYAN)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            percentual=0.75
            textMsg.text="Já tenho o percentual"
            Log.d("PDM24","No btCalcular, $percentual")
        })
    }
override fun onResume(){
    super.onResume()
    Log.d("PDM24","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.v("PDM24","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.e("PDM24","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.w("PDM24","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.wtf("PDM24","No Destroy")
}
}