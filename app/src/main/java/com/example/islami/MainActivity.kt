package com.example.islami

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.islami.databinding.ActivityMainBinding
import com.example.islami.fragments.bookfragment
import com.example.islami.fragments.quranfragment
import com.example.islami.fragments.radioFragment
import com.example.islami.fragments.seb7aFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navBar.setOnItemSelectedListener {menuitem->
            var fragment:Fragment = when(menuitem.itemId){
               R.id.nav_quran->{
                   quranfragment()

               }
               R.id.nav_book->{
                   bookfragment()

               }
               R.id.nav_seb7a->{
                   seb7aFragment()

               }
               R.id.nav_radio->{
                   radioFragment()

               }
                else->{
                    radioFragment()
                }

           }
            showFragment(fragment)
            return@setOnItemSelectedListener true
        }



    }
    fun showFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()

    }


}