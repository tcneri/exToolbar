package com.example.aula20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val TAG:String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instanciando a toolbar
        setSupportActionBar(toolbar)

        //Evento click navigationIcon
        toolbar.setNavigationOnClickListener{
            Log.i(TAG,"Clicando no navigation")
        }

    }

    override fun onCreateOptionsMenu(menu:Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemView = item.itemId

        when(itemView){
            R.id.menu_add -> showToast("Adicionando")
            R.id.menu_notification -> showSnackbar("Notificando")
        }
        return false
    }

    fun showToast(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showSnackbar(msg:String){
        var snack = Snackbar.make(home,msg, Snackbar.LENGTH_LONG)
        snack.setAction("ok", View.OnClickListener {
            Log.i(TAG,"Clicando em ok")
        })
        
        snack.show()


    }
}