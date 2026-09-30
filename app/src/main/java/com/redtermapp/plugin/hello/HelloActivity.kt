package com.redtermapp.plugin.hello

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
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

    private companion object {
        // Single-quoted on the shell side so the container expands nothing for us.
        const val THEME_DEMO =
            "echo 'A theme plugin can add themes.'; " +
            "echo 'It declares colours, RedTerm validates them.'"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 48, 48, 48)
        }
        root.addView(TextView(this).apply {
            text = getString(R.string.hello)
            textSize = 20f
        })

        // Sending the intent is all a plugin does. RedTerm checks that this app is a
        // granted plugin using the platform referrer, and runs the command as an
        // ordinary terminal session. Nothing is passed through that RedTerm has not
        // checked itself.
        root.addView(Button(this).apply {
            text = getString(R.string.run_in_redterm)
            isAllCaps = false
            setOnClickListener { runInRedTerm() }
        })

        root.addView(Button(this).apply {
            text = getString(R.string.run_theme_demo)
            isAllCaps = false
        })
        setContentView(root)
    }

    private fun runInRedTerm(command: String = getString(R.string.hello_command)) {
        val distro = getSharedPreferences("hello", MODE_PRIVATE)
            .getString("distro", "alpine")
        startActivity(
            Intent("com.redtermapp.action.PLUGIN_RUN").apply {
                setClassName("com.redtermapp", "com.redtermapp.ui.PluginRunActivity")
                putExtra("com.redtermapp.plugin.COMMAND", command)
                putExtra("com.redtermapp.plugin.DISTRO", distro)
            }
        )
    }
}
