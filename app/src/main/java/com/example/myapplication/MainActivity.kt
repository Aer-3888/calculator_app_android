package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow
import kotlin.math.round

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnPlus : Button
    lateinit var btnMinus : Button
    lateinit var btnMultiply : Button
    lateinit var btnDivide : Button
    lateinit var btnEqual : Button
    lateinit var btnDel : Button
    lateinit var btnReset : Button
    lateinit var btnDot : Button

    lateinit var btnZero : Button
    lateinit var btnOne : Button
    lateinit var btnTwo : Button
    lateinit var btnThree : Button
    lateinit var btnFour : Button
    lateinit var btnFive : Button
    lateinit var btnSix : Button
    lateinit var btnSeven : Button
    lateinit var btnEight : Button
    lateinit var btnNine : Button

    lateinit var tvFirstDigit : TextView
    lateinit var tvSign : TextView
    lateinit var tvAffichage : TextView

    var needReset : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        btnEqual = findViewById(R.id.btnEqual)
        btnDel = findViewById(R.id.btnSuppr)
        btnReset = findViewById(R.id.btnReset)
        btnDot = findViewById(R.id.btnDot)

        btnZero = findViewById(R.id.btn0)
        btnOne = findViewById(R.id.btn1)
        btnTwo = findViewById(R.id.btn2)
        btnThree = findViewById(R.id.btn3)
        btnFour = findViewById(R.id.btn4)
        btnFive = findViewById(R.id.btn5)
        btnSix = findViewById(R.id.btn6)
        btnSeven = findViewById(R.id.btn7)
        btnEight = findViewById(R.id.btn8)
        btnNine = findViewById(R.id.btn9)

        tvFirstDigit = findViewById(R.id.tvFirstDigit)
        tvSign = findViewById(R.id.tvSign)
        tvAffichage = findViewById(R.id.tvAffichage)

        btnPlus.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
        btnEqual.setOnClickListener(this)
        btnDel.setOnClickListener(this)
        btnReset.setOnClickListener(this)
        btnDot.setOnClickListener(this)

        btnZero.setOnClickListener(this)
        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnNine.setOnClickListener(this)
    }

    override fun onClick(button: View?) {

        val x = tvFirstDigit.text
        val y = tvAffichage.text
        var sign = tvSign.text
        var result = 0.0
        if (x.isEmpty() && y.isNotEmpty()) {
            when(button?.id){
                R.id.btnPlus -> {
                    tvSign.text = "+"
                    tvFirstDigit.text = tvAffichage.text
                    tvAffichage.text = ""
                }
                R.id.btnMinus -> {
                    tvSign.text = "-"
                    tvFirstDigit.text = tvAffichage.text
                    tvAffichage.text = ""
                }
                R.id.btnMultiply -> {
                    tvSign.text = "x"
                    tvFirstDigit.text = tvAffichage.text
                    tvAffichage.text = ""
                }
                R.id.btnDivide -> {
                    tvSign.text = "/"
                    tvFirstDigit.text = tvAffichage.text
                    tvAffichage.text = ""
                }
                R.id.btnSuppr -> {
                    tvAffichage.text = tvAffichage.text.substring(0,tvAffichage.text.length-1)
                }

            }

        }
        when (button?.id){
            R.id.btnReset -> {
                reset()
            }
            R.id.btnDot -> {
                if(y.isNotEmpty()){
                    tvAffichage.text = tvAffichage.text.toString().plus(".")
                }
            }
            R.id.btn0 -> {
                if (needReset){
                    reset()
                }
                tvAffichage.text = tvAffichage.text.toString().plus("0")
            }
            R.id.btn1 -> {
                if (needReset){
                    reset()
                }
                tvAffichage.text = tvAffichage.text.toString().plus("1")
            }
            R.id.btn2 -> {
                if (needReset){
                    reset()
                }
                tvAffichage.text = tvAffichage.text.toString().plus("2")
            }
            R.id.btn3 -> {
                if (needReset){
                    reset()
                }
                tvAffichage.text = tvAffichage.text.toString().plus("3")
            }
            R.id.btn4 -> {
                if (needReset){
                    reset()
                }
                tvAffichage.text = tvAffichage.text.toString().plus("4")
            }
            R.id.btn5 -> {
                if (needReset){
                    reset()
                }
                tvAffichage.text = tvAffichage.text.toString().plus("5")
            }
            R.id.btn6 -> {
                if (needReset){
                    reset()
                }
                tvAffichage.text = tvAffichage.text.toString().plus("6")
            }
            R.id.btn7 -> {
                if (needReset){
                    reset()
                }
                tvAffichage.text = tvAffichage.text.toString().plus("7")
            }
            R.id.btn8 -> {
                if (needReset){
                    reset()
                }
                tvAffichage.text = tvAffichage.text.toString().plus("8")
            }
            R.id.btn9 -> {
                if (needReset){
                    reset()
                }
                tvAffichage.text = tvAffichage.text.toString().plus("9")
            }
        }
        if (x.isNotEmpty() && y.isNotEmpty() && button?.id == R.id.btnEqual){
            val valueX = x.toString().toDouble()
            val valueY = y.toString().toDouble()
            when(sign){
                "+" -> {
                    result = valueX + valueY
                }
                "x" -> {
                    result = valueX * valueY
                }
                "-" -> {
                    result = valueX - valueY
                }
                "/" -> {
                    result = valueX / valueY
                }
            }
            tvSign.text = ""
            tvFirstDigit.text = ""
            if (result % 1.0 == 0.0) {
                tvAffichage.text = result.toInt().toString()
            } else {
                tvAffichage.text = result.toString()
            }
            needReset = true
        }

    }
    private fun reset(){
        tvAffichage.text = ""
        tvSign.text = ""
        tvFirstDigit.text = ""
        needReset=false
    }
}