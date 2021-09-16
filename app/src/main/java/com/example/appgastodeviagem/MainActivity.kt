package com.example.appgastodeviagem


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.appgastodeviagem.R.id.*
import com.example.appgastodeviagem.databinding.ActivityMainBinding
import java.lang.NumberFormatException

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalcular?.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == btCalcular) {
            calculate()
        }
    }

    //Aqui ficará a logica do aplicativo!!
    //A ideia aqui é que os valores que o usuário digitar, nós pegaremos e faremos o calculo!!
    private fun calculate() {
        if (validacao()) {
            try {
                val distance = binding.editDistance?.text.toString().toFloat()
                val price = binding.editPrice?.text.toString().toFloat()
                val auto = binding.editAuto?.text.toString().toFloat()

                val totalValue = (distance * price) / auto
                binding.editSoma?.text = "R$ ${"%.2f".format(totalValue)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.erro_digitar), Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(this, getString(R.string.notificacao), Toast.LENGTH_SHORT).show()
        }
    }

    private fun validacao(): Boolean {
        return (binding.editDistance?.text.toString() != ""
                && binding.editPrice?.text.toString() != ""
                && binding.editAuto?.text.toString() != ""
                && binding.editAuto?.text.toString() != "0")

    }
}


