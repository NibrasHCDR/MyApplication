package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.InicioFragment
import com.example.myapplication.fragments.NoticeFragment
import com.example.myapplication.fragments.PerfilFragment

class InicioActivity : AppCompatActivity() {

    private val inicioFragment = InicioFragment()
    private val noticeFragment = NoticeFragment()
    private val perfilFragment = PerfilFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        reemplazarFrament(inicioFragment)


    }

    private fun reemplazarFrament(fragment: Fragment){
        if(fragment !=null){
            val transaccion = supportFragmentManager.beginTransaction()
            transaccion.replace(R.id.fragment_container, fragment)
            transaccion.commit()
        }
    }
}