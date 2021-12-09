package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        variablesYConstantes()
    }

    //Creacion de funciones y variables en KOTLIN, en este caso para saber como funcionan las variables y constantes
    private fun variablesYConstantes() {

           //Variables
           var primeraVariable = "Este es el contenido"

           //Cambiar valor de variable
           primeraVariable = "Este es el nuevo contenido"

           //Imprimir valor en consola
           println(primeraVariable)

        //Constantes (Variables con valor fijo)
        val primeraConstante = "Primer dato de constante"

    }

    //Creamos una funcion para lograr conocer los tipos de datos de KOTLIN
    private fun tiposdeDatos(){

        // val - STRING - Cadena de texto
        val myString = "Cadena de texto"  //KOTLIN reconoce el tipo de dato de forma automatica, no es necesario definirla como string, caso contrario se da en JAVA

        //Enteros (Byte - Short - Int - Long)
        val myInt = 1

        //Decimales (Float - Double)
        val myDouble = 1.5
        val myFloat = 1.5f

        //Booleanos (True - False)
        val myBooleano1 = false
        val myBooleano2 = true

        ////


    }

    //Creamos nuestra funcionpara lograr conocer las sentencia IF , when
    private fun SentenciaWhen(){

        //creamos una variable y la comparamos creando un menu sin necesidad de varios if
        val mivariableWhen = "Español"
        when (mivariableWhen) {
            "Ingles" -> {
                   //aca hará algo si es que la variablecoincide
            }"Español" -> {
                    //aca hará algo si es que la variablecoincide
            }
        }

    }
}