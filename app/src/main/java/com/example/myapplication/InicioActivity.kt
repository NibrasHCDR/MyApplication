package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.InicioFragment
import com.example.myapplication.fragments.NoticeFragment
import com.example.myapplication.fragments.PerfilFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mapbox.maps.MapboxMap
import com.mapbox.maps.MapView
import com.mapbox.maps.Style

class InicioActivity : AppCompatActivity() {

    //Instanciamos las variables pque contienen los fragmentos
    private val inicioFragment = InicioFragment()
    private val noticeFragment = NoticeFragment()
    private val perfilFragment = PerfilFragment()

    //Instanciamos la variable que contendrá el mapa
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        //Instanciamos nuestro MapView dentro de la vista


        //Instanciamos INICIO como el fragmento donde inicará nuestro navigation
       // createFragment()
        reemplazarFrament(inicioFragment)


        //Instanciamos el boton de navegación (barra inferior de navegación)
        val bottom_navigation = findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottom_navigation.getMenu().getItem(1).setChecked(true);

        //Creamos evento para agregar un icono de notificación rojo
        bottom_navigation.getOrCreateBadge(R.id.ic_favoritos).apply {
            //isVisible = true
            number = 19
        }


        //Creamos el boton de selección para cambiar entre los fragmentos de cada item
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_Buscar -> reemplazarFrament(inicioFragment)
                R.id.ic_perfil -> reemplazarFrament(perfilFragment)
                R.id.ic_favoritos -> reemplazarFrament(noticeFragment)
            }
            true
        }

    }


    //Creamos la funcion para reemplazar los fragmentos
    private fun reemplazarFrament(fragment: Fragment) {
        if (fragment != null) {
            val transaccion = supportFragmentManager.beginTransaction()
            transaccion.replace(R.id.fragment_container, fragment)
            transaccion.commit()
        }
    }

    //Creamos las funciones de creacion del los mapas


    private fun crearMarcador(){
        val coordenadas = LatLng(-29.942853, -71.276966)
        val marker = MarkerOptions().position(coordenadas).title("Este es un marcador de pruebas")
        map.addMarker(marker)

    }

    internal fun onOpenMap() {
        supportFragmentManager.beginTransaction().replace(R.id.container, InicioFragment()).commitNow()
    }


}