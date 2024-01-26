package com.n1akai.toastmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.n1akai.toastymaster.ToastMaster

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            ToastMaster.Builder(baseContext)
                .setText("Hello")
                .setDescription("Hello2")
                .setDuration(Toast.LENGTH_SHORT)
                .show()
        }

    }
}