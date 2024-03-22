package Gabriel.Alexander

import android.os.Bundle
import android.widget.Button
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
        var txtBase = findViewById<TextView>(R.id.txtBase)
        var txtAltura = findViewById<TextView>(R.id.txtAltura)
        var txtResultado = findViewById<TextView>(R.id.txtResultado)
        var btnCalcular = findViewById<Button>(R.id.btnCalcular)


        val objCalculadora = Calculadora()

        btnCalcular.setOnClickListener {

            val resultado = objCalculadora.area(
                txtBase.text.toString().toDouble(),
                txtAltura.text.toString().toDouble()
            )


            txtResultado.text = "Tu base es de $resultado + metros cuadrados"


        }
    }
}