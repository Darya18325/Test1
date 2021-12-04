package com.example.fragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationMenu: BottomNavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMenu= findViewById(R.id.bottom_navigation_menu)


        bottomNavigationMenu.setOnItemSelectedListener { item ->
            var fragment:Fragment? = null
           when(item.itemId){
               R.id.calculate -> {
                   fragment=CalculateFragment()

               }
               R.id.info ->{
                   fragment=InfoFragment()
               }
           }

            replaceFragment(fragment!!)

            true
        }

        bottomNavigationMenu.selectedItemId = R.id.calculate

    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }
    }