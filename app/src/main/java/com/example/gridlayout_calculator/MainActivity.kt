package com.example.gridlayout_calculator
import android.graphics.Color
import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    private lateinit var textTv: TextView
    private lateinit var inputText: TextView

    var op1 = "";
    var op2 = "";
    var operation = ""
    var result: Double? = null
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        finish()
        return super.onOptionsItemSelected(item)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textTv = findViewById(R.id.textTv)
        inputText = findViewById(R.id.inputTtext)

        toolbar = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setBackgroundColor(Color.BLUE)
        title = "Калькулятор"

    }


    fun onClickButton(v: View) {

        if (result != null) return

        if (v is Button) {
            inputText.append(v.text)

            if (operation.isEmpty()) op1 += v.text else op2 += v.text }
                                }

    fun onClickOperation(v: View) {
        if (op1.isEmpty() or operation.isNotEmpty()) return

          if (v is Button) {
              operation = v.text.toString()
            inputText.append(" ${operation} ") }
                                 }

    fun onClickResult(v: View){

        if ((result != null) or op2.isEmpty()) return

         result = when(operation){
            "+" -> op1.toDouble()+op2.toDouble()
            "-" -> op1.toDouble()-op2.toDouble()
            "/" -> op1.toDouble()/op2.toDouble()
            "*" -> op1.toDouble()*op2.toDouble()
            else -> 0.0 }
        inputText.append(" =")
        textTv.text = result.toString() }

     fun onClickReset(v: View){

         inputText.text = "";textTv.text = "";
         op1 = "";op2 = "";operation = ""
         result = null

     }

}

