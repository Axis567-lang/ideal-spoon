package io.github.Axis567_lang.yutuplays

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlaySingle = findViewById<Button>(R.id.singleVid)
        val btnMenu = findViewById<Button>(R.id.btnSub)

        btnPlaySingle.setOnClickListener(this)
        btnMenu.setOnClickListener(this)
    }

    override fun onClick(view: View)
    {
        val intent = when(view.id)
        {                       // a qué actividad tiene que regresar,
                                //                  traeme la clase compilada de kotlin -> cast a
                                    //                                           una clase de java

            R.id.singleVid -> Intent(this, yutuActivity::class.java)
            R.id.btnSub -> Intent(this, Menu::class.java)

            else -> throw IllegalArgumentException("Invalid button")
        }
    }
}