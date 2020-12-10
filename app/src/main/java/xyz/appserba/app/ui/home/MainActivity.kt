package xyz.appserba.app.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import xyz.appserba.app.R
import xyz.appserba.app.databinding.ActivityMainBinding
import xyz.appserba.app.ui.auth.AppserbaAuth
import xyz.appserba.app.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnLogout.setOnClickListener {
            AppserbaAuth.logout(this){
                startActivity(Intent(this, AuthActivity::class.java ))
                finish()
            }
        }
    }
}