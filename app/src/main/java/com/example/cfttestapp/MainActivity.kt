package com.example.cfttestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cfttestapp.databinding.ActivityMainBinding
import com.example.cfttestapp.utilits.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var mToolbar: Toolbar
    private var binding: ActivityMainBinding?= null
    private val mBinding get() = binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        mToolbar = mBinding.toolbar
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(mToolbar)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}