package edu.uw.ischool.zachaz.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.widget.doOnTextChanged
import java.math.BigDecimal
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currency = NumberFormat.getCurrencyInstance()
        currency.maximumFractionDigits = 2

        val tipButton = findViewById<Button>(R.id.btn)
        val amount = findViewById<EditText>(R.id.et)
        val tip = findViewById<Spinner>(R.id.spinner)

        val getTipAmount = { (tip.selectedItem.toString().removeSuffix("%").toDouble() / 100).toBigDecimal() }

        var dollarTotal = BigDecimal.ZERO

        // When the user clicks on the EditText, remove the dollar sign
        amount.setOnClickListener { _,  ->
            if (!amount.text.isNullOrEmpty()) {
                val dollarFormatted = amount.text.toString().replace("$", "")
                amount.setText(dollarFormatted)
            }
        }

        // When the user clicks enter, format the number in USD
        amount.setOnEditorActionListener { _, _, _ ->
            if (!amount.text.isNullOrEmpty() && amount.text.toString() != ".") {
                dollarTotal = amount.text.toString().toBigDecimal()
                val dollarFormatted = currency.format(dollarTotal)
                amount.setText(dollarFormatted)
            }
            false
        }

        amount.doOnTextChanged {
                text, _, _, _ ->
            tipButton.isEnabled = !text.isNullOrEmpty()
        }

        tipButton.setOnClickListener {
            val total = currency.format(getTipAmount() * dollarTotal)
            Toast.makeText(this, "Tip Amount: $total", Toast.LENGTH_SHORT).show()
        }
    }
}