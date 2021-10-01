package com.example.krestikinoliki

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ContentInfoCompat
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.nichya.*
import kotlinx.android.synthetic.main.nichya.view.*
import kotlinx.android.synthetic.main.pobeda_o.view.*
import kotlinx.android.synthetic.main.pobeda_x.view.*
import java.lang.Integer.getInteger

class MainActivity : AppCompatActivity() {
    private var counter: Int = 0

    fun SetImge(cell: View) {
        counter++
        if (counter % 2 == 0) {
            cell.setBackgroundResource(R.drawable.cola_sqv)
        } else {
            cell.setBackgroundResource(R.drawable.pepsi)
        }
        cell.isClickable = false
    }
    fun delete_text(vararg cells: TextView){
        cells.forEach {
            it.text = ""
            kostil.text = ""
        }
    }
    fun delete(vararg cells: View) {
        cells.forEach {
            it.setBackgroundColor(4294967295.toInt())
            it.isClickable = true

            delete_text(it as TextView)
        }

    }

    fun text_x(vararg cell: TextView) {
        cell.forEach {
            it.text = "x"
        }
    }

    fun text_o(vararg cell: TextView) {
        cell.forEach {
            it.text = "o"
        }
    }
    var cunter_kr = 0
    var cunter_nol = 0
    var cunter_nich = 0
    fun nichya(cell1:TextView,cell2:TextView,cell3:TextView,cell4:TextView,cell5:TextView,cell6:TextView,cell7:TextView,cell8:TextView,cell9:TextView){
        if (cell1.isClickable==false && cell2.isClickable==false && cell3.isClickable==false && cell4.isClickable==false && cell5.isClickable==false && cell6.isClickable==false && cell7.isClickable==false && cell8.isClickable==false && cell9.isClickable==false){
            cunter_nich++
            counter_nich.text = cunter_nich.toString()
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.nichya,null)
            builder.setView(dialogLayout)
            val dialog:AlertDialog = builder.show()

            dialogLayout.play_again0.setOnClickListener {
                delete(i1, i2, i3, i4, i5, i6, i7, i8, i9)
                dialog.dismiss()
            }
            dialog.setOnDismissListener {
                delete(i1, i2, i3, i4, i5, i6, i7, i8, i9)
            }
        }
    }
    fun cheker(cells: TextView,cell: TextView, cell1: TextView) {

        if (cells.text == "x" && cell.text == "x" && cell1.text == "x") {
            if (kostil.text == "") {
                cunter_kr++
                counter_kr.text = cunter_kr.toString()
                val builder = AlertDialog.Builder(this)
                val inflater = layoutInflater
                val dialogLayout = inflater.inflate(R.layout.pobeda_x, null)
                builder.setView(dialogLayout)
                val dialog: AlertDialog = builder.show()
                kostil.text = "x"
                dialogLayout.play_again.setOnClickListener {
                    delete(i1, i2, i3, i4, i5, i6, i7, i8, i9)
                    dialog.dismiss()
                }
                dialog.setOnDismissListener {
                    delete(i1, i2, i3, i4, i5, i6, i7, i8, i9)
                }
            }
        }
            if (cells.text == "o" && cell.text == "o" && cell1.text == "o") {
                if (kostil.text == "") {
                    cunter_nol++
                    counter_nol.text = cunter_nol.toString()
                    val builder = AlertDialog.Builder(this)
                    val inflater = layoutInflater
                    val dialogLayout = inflater.inflate(R.layout.pobeda_o, null)
                    builder.setView(dialogLayout)
                    val dialog: AlertDialog = builder.show()
                    kostil.text = "o"
                    dialogLayout.play_again1.setOnClickListener {
                        delete(i1, i2, i3, i4, i5, i6, i7, i8, i9)
                        dialog.dismiss()
                    }
                    dialog.setOnDismissListener {
                        delete(i1, i2, i3, i4, i5, i6, i7, i8, i9)
                    }
                }

            }

    }

    fun massive(vararg cells: TextView, ) {
        cells.forEach {
            it.setOnClickListener {
                counter++
                if (counter % 2 == 0) {
                    it.setBackgroundResource(R.drawable.cola_sqv)
                    ran.text = "Ходят нолики"
                    text_x(it as TextView)
                    it.isClickable = false
                    //vertical
                    cheker(i1,i4,i7)
                    cheker(i2, i5, i8)
                    cheker(i3, i6, i9)
                    //horizontal
                    cheker(i1, i2, i3)
                    cheker(i4, i5, i6)
                    cheker(i7, i8, i9)
                    //diagonal
                    cheker(i1, i5, i9)
                    cheker(i3, i5, i7)
                    if (kostil.text == "") {
                        nichya(i1, i2, i3, i4, i5, i6, i7, i8, i9)
                    }
                } else {
                    it.setBackgroundResource(R.drawable.pepsi)
                    text_o(it as TextView)
                    ran.text = "Ходят крестики"
                    it.isClickable = false
                    //vertical
                    cheker(i1,i4,i7)
                    cheker(i2, i5, i8)
                    cheker(i3, i6, i9)
                    //horizontal
                    cheker(i1, i2, i3)
                    cheker(i4, i5, i6)
                    cheker(i7, i8, i9)
                    //diagonal
                    cheker(i1, i5, i9)
                    cheker(i3, i5, i7)

                    if (kostil.text =="") {
                        nichya(i1, i2, i3, i4, i5, i6, i7, i8, i9)
                    }
                }


            }
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val random = (1 until 2).random()
        ran.text = "Ходят нолики"
        counter_kr.text = "0"
        counter_nol.text =  "0"

        massive(i1, i2, i3, i4, i5, i6, i7, i8, i9)

        val img = (R.drawable.cola_sqv).toDrawable()
//vertical
        cheker(i1,i4,i7)
        cheker(i2, i5, i8)
        cheker(i3, i6, i9)
        //horizontal
        cheker(i1, i2, i3)
        cheker(i4, i5, i6)
        cheker(i7, i8, i9)
        //diagonal
        cheker(i1, i5, i9)
        cheker(i3, i5, i7)

        val timer = object : CountDownTimer(100000000, 500) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {

            }
        }

        val timer1 = object : CountDownTimer(100000000, 500) {
            override fun onTick(p0: Long) {
                //vertical

            }

            override fun onFinish() {
                timer.start()
            }
        }

        timer1.start()

    }
}
