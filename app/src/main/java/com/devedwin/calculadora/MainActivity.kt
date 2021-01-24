package com.devedwin.calculadora

import android.icu.text.DecimalFormatSymbols
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private var num1: Int = 0;
    private var num2: Int = 0;
    private var operation: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        oneButton.setOnClickListener {pressedNumber("1")}
        twoButton.setOnClickListener {pressedNumber("2")}
        threeButton.setOnClickListener {pressedNumber("3")}
        fourButton.setOnClickListener {pressedNumber("4")}
        fiveButton.setOnClickListener {pressedNumber("5")}
        sixButton.setOnClickListener {pressedNumber("6")}
        sevenButton.setOnClickListener {pressedNumber("7")}
        eightButton.setOnClickListener {pressedNumber("8")}
        nineButton.setOnClickListener {pressedNumber("9")}
        zeroButton.setOnClickListener {pressedNumber("0")}

        plusButton.setOnClickListener {pressedOperation(ADD)}
        subtractButton.setOnClickListener {pressedOperation(SUBSTRAC)}
        multiplyButton.setOnClickListener {pressedOperation(MULTIPLY)}
        divideButton.setOnClickListener {pressedOperation(DIVIDE)}

        clearButton.setOnClickListener {
            num1 = 0
            num2 = 0
            operation = NOOPER

            resultTextView.text = ""
        }

        equalsButton.setOnClickListener {
            var result: Int = when(operation){
                ADD -> num1 + num2
                SUBSTRAC -> num1 - num2
                MULTIPLY -> num1 * num2
                DIVIDE -> num1 / num2
                else -> 0
            }

            //resultTextView.text = result.toString()
            num1 = 0
            num2 = 0
            operation = NOOPER
        }
        
    }

    companion object {
        const val ADD = 1
        const val SUBSTRAC = 2
        const val MULTIPLY = 3
        const val DIVIDE = 4
        const val NOOPER = 0
    }

    private fun pressedNumber(digit: String){
        resultTextView.text = "${resultTextView.text}$digit"
        if (operation == NOOPER){
            num1 = resultTextView.text.toString().toInt()
        }else {
            resultTextView.text = digit
            num2 = resultTextView.text.toString().toInt()
        }
    }

    private fun pressedOperation(operation: Int){
        this.operation = operation
    }

}