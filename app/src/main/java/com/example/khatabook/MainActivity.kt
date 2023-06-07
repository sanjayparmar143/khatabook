package com.example.khatabook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.khatabook.Fragment.AddFragment
import com.example.khatabook.Fragment.HomeFragment
import com.example.khatabook.Fragment.Transaction
import com.example.khatabook.databinding.ActivityMainBinding
import me.ibrahimsn.lib.OnItemSelectedListener

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.bottomBar.onItemSelectedListener = object : OnItemSelectedListener
             {

            override fun onItemSelect(pos: Int): Boolean {

                when(pos) {
                    0->{
                        loadFragment(HomeFragment())

                    }
                    1->{
                        loadFragment(Transaction())
                    }
                    2->{

                        loadFragment(AddFragment())
                    }

                }

                return false
            }


        }


    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.FrameFragment, fragment)
            .commit()
    }
}