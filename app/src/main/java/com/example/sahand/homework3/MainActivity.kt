package com.example.sahand.homework3

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.Intent
import android.icu.util.Calendar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView

import java.time.LocalDate
import java.time.Period
import java.util.Locale

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private var dateField: EditText? = null
    private var nameField: EditText? = null
    private var emailField: EditText? = null
    private var usernameField: EditText? = null
    private var descriptionField: EditText? = null
    private var occupationField: EditText? = null
    private var validMessage: TextView? = null
    private var age: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dateField = findViewById(R.id.date_of_birth_field)
        nameField = findViewById(R.id.name_field)
        emailField = findViewById(R.id.email_field)
        usernameField = findViewById(R.id.username_field)
        occupationField = findViewById(R.id.occupation_field)
        descriptionField = findViewById(R.id.description_field)
        validMessage = findViewById(R.id.validation_text)

        if (savedInstanceState != null) {
            validMessage!!.text = savedInstanceState.getString("vMsg")
        }
    }

    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putString("vMsg", validMessage!!.text.toString())

        super.onSaveInstanceState(savedInstanceState)
    }

    fun showDatePickerDialog() {
        val newFragment = DatePickerFragment()
        newFragment.show(fragmentManager, "datePicker")
    }

    public override fun onRestart() {
        super.onRestart()
        dateField!!.setText("")
        nameField!!.setText("")
        emailField!!.setText("")
        usernameField!!.setText("")
        descriptionField!!.setText("")
        occupationField!!.setText("")
    }

    fun submitForm() {

        if (nameField!!.text.toString().isEmpty() or usernameField!!.text.toString().isEmpty()
                or emailField!!.text.toString().isEmpty() or dateField!!.text.toString().isEmpty()
                or descriptionField!!.text.toString().isEmpty() or occupationField!!.text.toString().isEmpty()) {
            validMessage!!.setText(R.string.emptyFields)
        } else if (!isEighteen(dateField!!.text.toString())) {
            validMessage!!.setText(R.string.underEighteen)
        } else {
            val nameAndAge = nameField!!.text.toString() + ", " + age

            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra("NAMEANDAGE", nameAndAge)
            intent.putExtra("OCCUPATION", occupationField!!.text.toString())
            intent.putExtra("DESCRIPTION", descriptionField!!.text.toString())
            startActivity(intent)
        }
    }

    private fun isEighteen(string: String): Boolean {
        val birthDate = string.split("/".toRegex())
        if (birthDate.size == 3) {
            val month = Integer.parseInt(birthDate[0])
            val day = Integer.parseInt(birthDate[1])
            val year = Integer.parseInt(birthDate[2])

            val today = LocalDate.now()

            if ((day < 1) or (day > 31) or (month < 1) or (month > 12) or (year < 1880) or (year > today.year))
                return false

            val birthday = LocalDate.of(year, month, day)
            val p = Period.between(birthday, today)
            age = p.years

            return age >= 18
        } else {
            return false
        }
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        dateField!!.setText(String.format(Locale.ENGLISH, "%1\$d/%2\$d/%3\$d", month + 1, day, year))
    }

    class DatePickerFragment : DialogFragment() {

        override fun onCreateDialog(savedInstanceState: Bundle): Dialog {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            return DatePickerDialog(activity, activity as MainActivity, year, month, day)
        }
    }
}