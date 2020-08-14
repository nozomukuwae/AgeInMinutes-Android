package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {
            openDatePicker(it)
        }
    }

    private fun openDatePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val currentTime = myCalendar.time

        val pickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
            val dateString = "$i3/${i2 + 1}/$i"
            tvSelectedDate.text = dateString

            val selectedDateCalendar = Calendar.getInstance()
            selectedDateCalendar.set(i, i2, i3)
            val date = selectedDateCalendar.time

            val ageInMinutes = (currentTime.time - date.time) / 1000.0 / 60.0

            tvSelectedDateInMinutes.text = ageInMinutes.toInt().toString()
        }, year, month, day)

        pickerDialog.datePicker.maxDate = currentTime.time
        pickerDialog.show()
    }
}