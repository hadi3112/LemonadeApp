package com.example.lemonadeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.*
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text
import java.nio.file.FileVisitOption

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tree_img:ImageView = findViewById(R.id.treeimg)
        val textview:TextView  = findViewById(R.id.textView)
        val button:Button = findViewById(R.id.button)

        button.visibility = INVISIBLE


        var squeeze_count:Int = setsqueezecount()  //method declared below

        var usercounter:Int = 0



        tree_img.setOnClickListener()
        {



            if (usercounter == squeeze_count)
            {
                tree_img.setImageResource(R.drawable.lemon_drink)
                textview.setText("Tap to drink your lemonade !")
                button.visibility = VISIBLE


            }
            else
            {
                textview.setText("Tap to juice the lemon !")
                tree_img.setImageResource(R.drawable.lemon_squeeze)

                usercounter++
                val handler = Handler()   //wait for clarity b/w toast msgs
                handler.postDelayed({
                    // your code to run after 2 second
                    val toast = Toast.makeText(this, "Squeeze again", Toast.LENGTH_SHORT).show()
                }, 1000)

            }
        }

        usercounter = 0

        button.setOnClickListener()
        {
            tree_img.setImageResource(R.drawable.lemon_restart)
            textview.setText("All Finished !")
            val snack = Snackbar.make(it,"Want more Lemnoade?",Snackbar.LENGTH_INDEFINITE).
                                        setAction("Restart", View.OnClickListener
                                        {
                                            usercounter = 0
                                            squeeze_count = setsqueezecount()
                                            tree_img.setImageResource(R.drawable.lemon_tree)
                                            button.visibility = INVISIBLE
                                            textview.setText("Click to select a Lemon !")
                                        })
            snack.show()

        }



    }

    //methods here

    private fun setsqueezecount():Int
    {
        val countrange:IntRange = 1..5
        val squeeze_count:Int = countrange.random()
        Log.i("TAG", "Rand No. is " + squeeze_count)
        return squeeze_count
    }
}