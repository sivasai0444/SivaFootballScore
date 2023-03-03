package ca.sivafootballscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import ca.sivafootballscore.databinding.ActivityMainBinding
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    var txt1: TextView? = null
    var txt2:TextView? = null
    var rg: RadioGroup? = null
    var a2: RadioButton? = null
    var a4:RadioButton? = null
    var a6:RadioButton? = null
    var a8:RadioButton? = null
    private var plus: ImageView? = null
    private var minus: ImageView? = null
    var `val` = 0
    var checked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        txt1 = findViewById(R.id.barce) as TextView
        txt2 = findViewById(R.id.arge) as TextView

        binding.swt.setOnCheckedChangeListener(
            CompoundButton.OnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
                checked = if (isChecked) {
                    true
                } else {
                    false
                }
            })

        rg = findViewById(R.id.rg)
        a2 = findViewById(R.id.a2)
        a4 = findViewById(R.id.a4)
        a6 = findViewById(R.id.a6)
        a8 = findViewById(R.id.a8)
        plus = findViewById(R.id.plus)
        plus?.setOnClickListener(View.OnClickListener { v: View? ->
            if (checked) {
                var hh = (txt1?.getText().toString() + "").toInt()
                hh = hh + `val`
                txt1?.setText(hh.toString() + "")
            } else {
                var hh = (txt2?.getText().toString() + "").toInt()
                hh = hh + `val`
                txt2?.setText(hh.toString() + "")
            }
        })



        minus = findViewById(R.id.minus)
        minus?.setOnClickListener(View.OnClickListener { v: View? ->
            if (checked) {
                var hh = (txt1?.getText().toString() + "").toInt()
                hh = hh - `val`
                if (hh < 0) {
                    hh = 0
                }
                txt1?.setText(hh.toString() + "")
            } else {
                var hh = (txt2?.getText().toString() + "").toInt()
                hh = hh - `val`
                if (hh < 0) {
                    hh = 0
                }
                txt2?.setText(hh.toString() + "")
            }
        })


    }


    fun onRadioButtonClicked(view: View) {
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            R.id.a2 -> if (checked) `val` = 2
            R.id.a4 -> if (checked) `val` = 4
            R.id.a6 -> if (checked) `val` = 6
            R.id.a8 -> if (checked) `val` = 8
        }
    }


}