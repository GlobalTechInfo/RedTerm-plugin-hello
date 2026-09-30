package com.redtermapp.plugin.hello

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Reference RedTerm plugin.
 *
 * It exists to prove the whole path works: discovery, the consent screen, and
 * being installed as an ordinary app. It deliberately does nothing else, so a
 * problem here is a problem with the plugin plumbing rather than with anything
 * the plugin itself is doing.
 */
class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(TextView(this).apply {
            text = getString(R.string.hello)
            textSize = 20f
            setPadding(48, 48, 48, 48)
        })
    }
}
