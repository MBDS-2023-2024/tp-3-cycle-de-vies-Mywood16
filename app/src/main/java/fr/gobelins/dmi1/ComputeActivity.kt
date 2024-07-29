package fr.gobelins.dmi1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity() {

    private lateinit var firstOperand: EditText
    private lateinit var secondOperand: EditText
    private lateinit var btnCompute: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)

        firstOperand = findViewById(R.id.first_operand)
        secondOperand = findViewById(R.id.second_operand)
        btnCompute = findViewById(R.id.btn_compute)

        btnCompute.setOnClickListener {
            val firstNumber = firstOperand.text.toString().toDoubleOrNull()
            val secondNumber = secondOperand.text.toString().toDoubleOrNull()

            if (firstNumber != null && secondNumber != null) {
                val result = firstNumber + secondNumber // Par défaut, faisons une addition
                Toast.makeText(this, "Résultat: $result", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Veuillez entrer des nombres valides", Toast.LENGTH_LONG).show()
            }
        }
    }val operation = intent.getStringExtra("operation") ?: "ADD"
}









