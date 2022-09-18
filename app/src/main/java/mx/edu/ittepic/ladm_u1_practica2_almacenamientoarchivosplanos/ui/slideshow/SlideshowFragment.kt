package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.ui.slideshow

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.R
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.databinding.FragmentSlideshowBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    fun guardar(mensaje:String){
        try {
            if(activity !=null) {
                var c: Context = requireActivity().applicationContext
                var archivo = OutputStreamWriter(c.openFileOutput("carrito.txt",Context.MODE_APPEND))
                archivo.append(mensaje+",")
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
                archivo.append(mensaje+",")
                archivo.flush()
                archivo.close()
                //Toast.makeText(activity,"Se guardó",Toast.LENGTH_LONG).show()
            }
        }catch (e:Error){
            Toast.makeText(activity,e.message,Toast.LENGTH_LONG).show()

        }//catch
    }//guardar2


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root
       /* var btnM =binding.btnMostrar
        var recibo = binding.recibo


        btnM.setOnClickListener {
            try {
                var c: Context = requireActivity().applicationContext
                var archivo = BufferedReader(InputStreamReader(c.openFileInput("carrito.txt")))
                var tot:String=""
                val st = archivo.readLines()
                for(s:String in st){
                    tot+=s
                }
                recibo.text=tot
                archivo.close()

            }catch (e:Error){
                Toast.makeText(activity,e.message,Toast.LENGTH_LONG).show()
            }//catch
        }//clicklistener

        */
        
        binding.prodLi.setOnItemClickListener {adapterView, view, posicion, l ->
            println(binding.prodLi.getItemAtPosition(posicion).toString())
            var pro = binding.prodLi.getItemAtPosition(posicion).toString().split("$")
            guardar(pro[0])
            guardar2("$"+pro[1])


        }//itemclick
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}