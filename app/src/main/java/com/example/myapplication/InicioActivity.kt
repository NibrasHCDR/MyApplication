package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar


class InicioActivity : AppCompatActivity(), OnMapReadyCallback {

    //Instanciamos la variable que contendrá el mapa
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        //Instanciamos nuestro MapView dentro de la vista
        val fab: View = findViewById(R.id.fab)

        //Instanciamos las variables pque contienen los fragmentos}
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        //val navController = findNavController(R.id.fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.noticiasFragment,
            R.id.inicioFragment,
            R.id.perfilFragment
        ))

        createFragmentMap(bottomNavigationView)

        //bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setItemIconTintList(null)


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Esto es una accion", Snackbar.LENGTH_LONG)
               .setAction("Action", null)
                .show()
       }




    }

    private fun createFragmentMap(botom: BottomNavigationView) {
        val navController = findNavController(R.id.fragment)
        botom.setupWithNavController(navController)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }
}