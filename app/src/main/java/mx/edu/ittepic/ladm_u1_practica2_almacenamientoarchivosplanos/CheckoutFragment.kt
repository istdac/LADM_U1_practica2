package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.withTimeout
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckoutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckoutFragment : Fragment() {
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
                var archivo = OutputStreamWriter(c.openFileOutput("carrito.txt",Context.MODE_APPEND))
                archivo.append(mensaje)
                archivo.flush()
                archivo.close()
                //Toast.makeText(activity,"Se guardó",Toast.LENGTH_LONG).show()
            }
        }catch (e:Error){
            Toast.makeText(activity,e.message,Toast.LENGTH_LONG).show()

        }//catch
    }//guardar
    fun guardar2(mensaje:String){
        try {
            if(activity !=null) {
                var c: Context = requireActivity().applicationContext
                var archivo = OutputStreamWriter(c.openFileOutput("precio.txt",Context.MODE_APPEND))
                archivo.append(mensaje)
                archivo.flush()
                archivo.close()
                //Toast.makeText(activity,"Se guardó",Toast.LENGTH_LONG).show()
            }
        }catch (e:Error){
            Toast.makeText(activity,e.message,Toast.LENGTH_LONG).show()

        }//catch
    }//guardar
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =inflater.inflate(R.layout.fragment_checkout, container, false)
        var btnP =view.findViewById<Button>(R.id.btnPagar)
       // var btnM =view.findViewById<Button>(R.id.btnLimpiar)
       // var recibo = view.findViewById<TextView>(R.id.recibo)

        btnP.setOnClickListener {
            guardar("Test,")
            guardar2("$20,")
            Toast.makeText(activity,"Se ha pagado su pedido",Toast.LENGTH_LONG).show()
            //guardar("continuacion")
        }//onclicklistener
/*
        btnM.setOnClickListener {
            /*try {
                var c: Context = requireActivity().applicationContext
                var archivo = BufferedReader(InputStreamReader(c.openFileInput("carrito.txt")))
                var strings =archivo.readLine().split(",")
                println("Strings:"+strings)
                println(strings.size)
                var str:String=""
                for(s:String in strings){
                    if(s.isEmpty())break
                    str=str+s
                    println("s:"+s)
                }
                recibo.setText(str)
                archivo.close()

            }catch (e:Error){
                Toast.makeText(activity,e.message,Toast.LENGTH_LONG).show()
            }//catch
             */
            try {
                if(activity !=null) {
                    var c: Context = requireActivity().applicationContext
                    var archivo = OutputStreamWriter(c.openFileOutput("carrito.txt",Context.MODE_PRIVATE))
                    archivo.write("")
                    archivo.flush()
                    archivo.close()
                    //Toast.makeText(activity,"Se guardó",Toast.LENGTH_LONG).show()
                }
            }catch (e:Error){
                Toast.makeText(activity,e.message,Toast.LENGTH_LONG).show()

            }//catch
            try {
                if(activity !=null) {
                    var c: Context = requireActivity().applicationContext
                    var archivo = OutputStreamWriter(c.openFileOutput("precio.txt",Context.MODE_PRIVATE))
                    archivo.append("")
                    archivo.flush()
                    archivo.close()
                    //Toast.makeText(activity,"Se guardó",Toast.LENGTH_LONG).show()
                }
            }catch (e:Error){
                Toast.makeText(activity,e.message,Toast.LENGTH_LONG).show()

            }//catch
            var c: Context = requireActivity().applicationContext

            var archivo = BufferedReader(InputStreamReader(c.openFileInput("carrito.txt")))
            println("archvo:"+archivo)
            var strings =archivo.readLine()//.split(",")
            var archivo2= BufferedReader(InputStreamReader(c.openFileInput("precio.txt")))
            var strings2 = archivo2.readLine()//.split(",")
            println("Strings:"+strings)
            println("Strings2:"+strings2)

        }//clicklistener

 */
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CheckoutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                CheckoutFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}