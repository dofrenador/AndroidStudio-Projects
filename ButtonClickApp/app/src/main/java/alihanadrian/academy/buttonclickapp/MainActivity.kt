package alihanadrian.academy.buttonclickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private var TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() {

    private var textView : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val userInput : EditText = findViewById<EditText>(R.id.editText)
        val button : Button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()
        userInput.text.clear()

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?){
                Log.d(TAG,"onClick called")
                textView?.append(userInput.text)
                textView?.append("\n")
                userInput.text.clear()
            }
        })
    }

    override fun onStart(){
        Log.d(TAG,"onStart:called")
        super.onStart()
    }
    //use this in order to change to portrait/landscape
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG,"onRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
        val savedString = savedInstanceState?.getString(TEXT_CONTENTS, "")
        textView?.text = savedString
    }

    override fun onResume() {
        Log.d(TAG,"onResume: called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: called")
        super.onPause()
    }
    //use this in order to change to portrait/landscape
    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstance: called")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS, textView?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG,"onStop: called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG,"onRestart: called")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy: called")
        super.onDestroy()
    }


}
