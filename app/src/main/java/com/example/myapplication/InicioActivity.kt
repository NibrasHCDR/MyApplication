package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.InicioFragment
import com.example.myapplication.fragments.NoticeFragment
import com.example.myapplication.fragments.PerfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class InicioActivity : AppCompatActivity() {

    //Instanciamos las variables pque contienen los fragmentos
    private val inicioFragment = InicioFragment()
    private val noticeFragment = NoticeFragment()
    private val perfilFragment = PerfilFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        //Instanciamos INICIO como el fragmento donde inicará nuestro navigation
        reemplazarFrament(inicioFragment)

        //Instanciamos el boton de navegación (barra inferior de navegación)
        val bottom_navigation = findViewById(R.id.bottom_navigation) as BottomNavigationView

        //Creamos evento para agregar un icono de notificación rojo
        bottom_navigation.getOrCreateBadge(R.id.ic_favoritos).apply {
            //isVisible = true
            number = 19
        }


        //Creamos el boton de selección para cambiar entre los fragmentos de cada item
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_Buscar -> reemplazarFrament(inicioFragment)
                R.id.ic_perfil -> reemplazarFrament(perfilFragment)
                R.id.ic_favoritos -> reemplazarFrament(noticeFragment)
            }
            true
        }



    }

    //Creamos la funcion para reemplazar los fragmentos
    private fun reemplazarFrament(fragment: Fragment){
        if(fragment !=null){
            val transaccion = supportFragmentManager.beginTransaction()
            transaccion.replace(R.id.fragment_container, fragment)
            transaccion.commit()
        }
    }
}