package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CarritoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarritoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    fun guardar(mensaje:String){
        try {
            if(activity !=null) {
                var c: Context = requireActivity().applicationContext
                var archivo = OutputStreamWriter(c.openFileOutput("carrito.txt",Context.MODE_PRIVATE))
                archivo.write(mensaje)
                archivo.flush()
                archivo.close()
                //Toast.makeText(activity,"Se guardó",Toast.LENGTH_LONG).show()
            }
        }catch (e:Error){
            Toast.makeText(activity,e.message, Toast.LENGTH_LONG).show()

        }//catch
    }//guardar
    fun guardar2(mensaje:String){
        try {
            if(activity !=null) {
                var c: Context = requireActivity().applicationContext
                var archivo = OutputStreamWriter(c.openFileOutput("precio.txt",Context.MODE_PRIVATE))
                archivo.write(mensaje)
                archivo.flush()
                archivo.close()
                //Toast.makeText(activity,"Se guardó",Toast.LENGTH_LONG).show()
            }
        }catch (e:Error){
            Toast.makeText(activity,e.message, Toast.LENGTH_LONG).show()

        }//catch
    }//guardar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =inflater.inflate(R.layout.fragment_carrito, container, false)
        var id = view.findViewById<EditText>(R.id.numPos)
        var btnObtener = view.findViewById<Button>(R.id.btnObtener)
        var nombre = view.findViewById<EditText>(R.id.editProd)
        var precio = view.findViewById<EditText>(R.id.editPrice)
        var btnGuardar =view.findViewById<Button>(R.id.btnGuardar)
        var btnBorrar =view.findViewById<Button>(R.id.btnBorrar)
        btnObtener.setOnClickListener {
            //Obtener id
            var c: Context = requireActivity().applicationContext
            var archivo = BufferedReader(InputStreamReader(c.openFileInput("carrito.txt")))
            var archivo2= BufferedReader(InputStreamReader(c.openFileInput("precio.txt")))
            var line1=archivo.readLine()
            var line2=archivo2.readLine()
            var pos = id.text.toString().trim()
            if( !id.text.toString().isEmpty()
                && !pos.contains(".")
                && !pos.contains(",")
                && !pos.contains("-")
                &&(line1)!=null&&(line2)!=null){
                //Checar si outofbounds
                var pos = pos.toInt()
                var arrid = line1.split(",")
                var arrpr = line2.split(",")
                if(pos<=arrid.size-1){
                    println("id correcto")
                    nombre.setText(arrid[pos-1])
                    precio.setText(arrpr[pos-1])
                    nombre.isEnabled=true
                    precio.isEnabled=true
                    btnGuardar.isEnabled=true
                    btnBorrar.isEnabled=true
                }//if pos out of bounds
                println("id incorrecto")
            }//if archivo no vacío
            else{
                Toast.makeText(c,"Valor no valido",Toast.LENGTH_LONG).show()
            }
        }//btnClick
        btnGuardar.setOnClickListener {
            var c: Context = requireActivity().applicationContext
            var archivo = BufferedReader(InputStreamReader(c.openFileInput("carrito.txt")))
            var archivo2= BufferedReader(InputStreamReader(c.openFileInput("precio.txt")))
            var line1=archivo.readLine()
            var line2=archivo2.readLine()
            var pos = id.text.toString().trim()
            if( !id.text.toString().isEmpty()
                && !pos.contains(".")
                && !pos.contains(",")
                && !pos.contains("-")
                &&(line1)!=null&&(line2)!=null){
                //Checar si outofbounds
                var pos = pos.toInt()
                var arrid = line1.split(",").toMutableList()
                var arrpr = line2.split(",").toMutableList()
                if(pos<=arrid.size-1){
                    println("id correcto")
                    arrid[pos-1]=nombre.text.toString()
                    arrpr[pos-1]=precio.text.toString()
                    println("arrid"+arrid[pos-1])
                    println("arrpr"+arrpr[pos-1])
                    var nombres:String=""
                    for(s:String in arrid){
                        nombres=nombres+s+","
                        println("nombres:"+nombres)
                    }
                    var precios:String=""
                    for(s:String in arrpr){
                        precios=precios+s+","
                        println("precios:"+precios)
                    }
                    println("sub1:"+nombres.substring(0,nombres.length-1))
                    println("sub2:"+precios.substring(0,precios.length-1))
                    nombres=nombres.substring(0,nombres.length-1)
                    precios=precios.substring(0,precios.length-1)
                    //Guardar
                    guardar(nombres)
                    guardar2(precios)

                }//if pos out of bounds
                println("id incorrecto")

            }//if archivo no vacío
            else{

            }//else

        }
        btnBorrar.setOnClickListener {
            var c: Context = requireActivity().applicationContext
            var archivo = BufferedReader(InputStreamReader(c.openFileInput("carrito.txt")))
            var archivo2= BufferedReader(InputStreamReader(c.openFileInput("precio.txt")))
            var line1=archivo.readLine()
            var line2=archivo2.readLine()
            var pos = id.text.toString().trim()
            if( !id.text.toString().isEmpty()
                && !pos.contains(".")
                && !pos.contains(",")
                && !pos.contains("-")
                &&(line1)!=null&&(line2)!=null){
                //Checar si outofbounds
                var pos = pos.toInt()
                var arrid = line1.split(",").toMutableList()
                var arrpr = line2.split(",").toMutableList()
                if(pos<=arrid.size-1){
                    arrid.removeAt(pos-1)
                    arrpr.removeAt(pos-1)
                    var nombres:String=""
                    for(s:String in arrid){
                        nombres=nombres+s+","
                        println("nombres:"+nombres)
                    }
                    var precios:String=""
                    for(s:String in arrpr){
                        precios=precios+s+","
                        println("precios:"+precios)
                    }
                    println("sub1:"+nombres.substring(0,nombres.length-1))
                    println("sub2:"+precios.substring(0,precios.length-1))
                    nombres=nombres.substring(0,nombres.length-1)
                    precios=precios.substring(0,precios.length-1)
                    //Guardar
                    guardar(nombres)
                    guardar2(precios)

                }//if pos out of bounds
                println("id incorrecto")
            }//if archivo no vacío
            else{

            }//else
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CarritoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CarritoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}