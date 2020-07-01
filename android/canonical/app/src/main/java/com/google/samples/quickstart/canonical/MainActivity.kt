package com.google.samples.quickstart.canonical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val runFragment = RunFragment()
    supportFragmentManager
      .beginTransaction()
      .replace(R.id.content_view, runFragment)
      .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
      .commit()

    val bottomNavigation : BottomNavigationView = findViewById(R.id.bottom_navigation_view)
    bottomNavigation.setOnNavigationItemSelectedListener { item ->
      when (item.itemId) {

        R.id.bottom_navigation_item_run -> {
          val autocompleteFrameLayout : FrameLayout = findViewById(R.id.autocomplete_view)
          autocompleteFrameLayout.visibility = View.INVISIBLE

          val runFragment = RunFragment()
          supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_view, runFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
          true
        }

        R.id.bottom_navigation_item_map -> {
          val autocompleteFrameLayout : FrameLayout = findViewById(R.id.autocomplete_view)
          autocompleteFrameLayout.visibility = View.VISIBLE

          val mapsFragment = MapsFragment()
          val autocompleteFragment = AutocompleteFragment()
          supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_view, mapsFragment)
            .replace(R.id.autocomplete_view, autocompleteFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
          true
        }

        R.id.bottom_navigation_item_profile -> {
          val autocompleteFrameLayout : FrameLayout = findViewById(R.id.autocomplete_view)
          autocompleteFrameLayout.visibility = View.INVISIBLE

          val meFragment = MeFragment()
          supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_view, meFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
          true
        }

        else -> false
      }
    }
  }



}