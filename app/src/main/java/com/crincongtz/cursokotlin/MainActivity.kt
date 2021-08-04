package com.crincongtz.cursokotlin

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

const val TAG = "CursoKotlin"
const val KEY_SAVED_NUMBER = "saved_number"

class MainActivity : AppCompatActivity() {

    var boton1: Button? = null

    var tvCounter: TextView? = null
//    private lateinit var tvCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(TAG, "onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)

        tvCounter = findViewById(R.id.textView8)

        // Este es mi boton Intent
        boton1 = findViewById(R.id.button1)
        boton1!!.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Este es el contador
        val boton2 = findViewById<Button>(R.id.button2)
        boton2.setOnClickListener {
            incrementCounter()
        }
    }

    private val positiveButtonClick = { _: DialogInterface, _: Int ->
       Toast.makeText(this, "Ok Clicked", Toast.LENGTH_SHORT).show()
    }

    // Este es el Boton3 - Alerta
    fun showAlert(view: View) {
        val buider = AlertDialog.Builder(this)
        buider.setTitle("Ejemplo Alerta Android!")
        buider.setMessage("Este es un mensaje de advertencia para el usuario")
        buider.setPositiveButton("Ok", DialogInterface.OnClickListener(function = positiveButtonClick))
        buider.show()
    }

    private fun incrementCounter() {
        val numero: Int = if (tvCounter != null) {
            tvCounter?.text.toString().toInt()
        } else {
            0
        }
        tvCounter?.text = numero.inc().toString()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart()")
        super.onRestart()
    }

    override fun onStart() {
        Log.d(TAG, "onStart()")
        super.onStart()
    }

    override fun onResume() {
        Log.i(TAG, "onResume()")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.w(TAG, "onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e(TAG, "onDestroy()")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.w(TAG, "Nuestra app esta a punto de ser destruida!!")
        super.onSaveInstanceState(outState)
        val numberToSave = tvCounter?.text
        outState.putCharSequence(KEY_SAVED_NUMBER, numberToSave)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "Nuestra app esta siendo recreada...")
        val savedNumber = savedInstanceState.getCharSequence(KEY_SAVED_NUMBER)
        tvCounter?.text = savedNumber
    }
}
