package com.example.barisonerr

import android.app.Application
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_splash.*

fun internetKontrol(application: Application): Boolean {
    val connectivityManager = application.getSystemService(
        Application.CONNECTIVITY_SERVICE
    ) as ConnectivityManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ->    true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ->   true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ->   true
            else ->     false
        }
    }
    else {
        if (connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnectedOrConnecting) {
            return true
        }
    }
    return false
}

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            imageView.isVisible = true;
            if(internetKontrol(application) == true){
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }, 2000)
            }else{
               Toast.makeText(getApplicationContext(),"İnternet kapalı. Programdan çıkılıyor..",Toast.LENGTH_LONG).show();
                finish()
            }
        },1000)

        buttonHakkimda.setOnClickListener { view ->
            val intent = Intent(this,HakkimdaActivity::class.java)
            startActivity(intent)
        }
    }




}