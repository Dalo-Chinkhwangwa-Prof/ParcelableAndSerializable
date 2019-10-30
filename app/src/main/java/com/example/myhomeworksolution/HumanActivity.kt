package com.example.myhomeworksolution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_human.*

class HumanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_human)

        val humanIn: HumanJava = intent?.getParcelableExtra("my_human_key") as HumanJava

        humanIn.let { human ->
            val string = "${human.name} has hair color ${human.hairColor}"
            human_textview.text = string
        }


    }
}
