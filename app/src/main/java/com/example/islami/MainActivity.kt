package com.example.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.databinding.ActivityMainBinding
import com.example.islami.fragments.bookfragment
import com.example.islami.fragments.quran.Quranfragment
import com.example.islami.fragments.radioFragment
import com.example.islami.fragments.seb7aFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load QuranFragment by default when app starts
        if (savedInstanceState == null) {
            showFragment(Quranfragment())
        }

        // Set default selected item in BottomNavigationView
        binding.navBar.selectedItemId = R.id.nav_quran

        // Handle bottom navigation clicks
        binding.navBar.setOnItemSelectedListener { menuItem ->
            val fragment: Fragment = when (menuItem.itemId) {
                R.id.nav_quran -> Quranfragment()
                R.id.nav_book -> bookfragment()
                R.id.nav_seb7a -> seb7aFragment()
                R.id.nav_radio -> radioFragment()
                else -> Quranfragment()
            }

            showFragment(fragment)
            true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // Allows back navigation
            .commit()
    }
}
