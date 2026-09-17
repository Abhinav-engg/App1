package com.abhinav.app1

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            showSetupDialog()
        }
    }

    private fun showSetupDialog() {

        val dialog = Dialog(this)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_setup_path)
        dialog.setCancelable(false)

        val window = dialog.window

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.setDimAmount(0.5f)

        dialog.show()

        window?.setLayout(
            (resources.displayMetrics.widthPixels * 0.8).toInt(),
            android.view.ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val talentSeeker = dialog.findViewById<CheckBox>(R.id.cbTalentSeeker)
        val jobHunter = dialog.findViewById<CheckBox>(R.id.cbJobHunter)
        val nextButton = dialog.findViewById<Button>(R.id.btnNext)

        talentSeeker.setOnCheckedChangeListener { button, checked ->

            if (checked) {
                jobHunter.isChecked = false
                nextButton.isEnabled = true

                nextButton.setBackgroundColor(android.graphics.Color.parseColor("#1F41BB"))

                nextButton.setTextColor(android.graphics.Color.WHITE)
            }
        }

        jobHunter.setOnCheckedChangeListener { button, checked ->

            if (checked) {
                talentSeeker.isChecked = false
                nextButton.isEnabled = true

                nextButton.setBackgroundColor(android.graphics.Color.parseColor("#1F41BB"))

                nextButton.setTextColor(android.graphics.Color.WHITE)
            }
        }

        nextButton.setOnClickListener {

            if (talentSeeker.isChecked) {

                dialog.dismiss()

            } else if (jobHunter.isChecked) {

                dialog.dismiss()
            }
        }
    }
}