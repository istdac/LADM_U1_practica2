package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.ui.gallery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.CustomAdapter
import mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.databinding.FragmentGalleryBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.btnMostrar.setOnClickListener {
            var c: Context = requireActivity().applicationContext
            var archivo = BufferedReader(InputStreamReader(c.openFileInput("carrito.txt")))
            var archivo2= BufferedReader(InputStreamReader(c.openFileInput("precio.txt")))
            var line1=archivo.readLine()
            var line2=archivo2.readLine()
            if((line1)!=null&&(line2)!=null){
                var strings2 = line2.split(",")
                var strings =line1.split(",")
                strings = strings.subList(0,strings.size-1)
                strings2 = strings2.subList(0,strings2.size-1)
                println("Strings:"+strings)
                println("Strings2:"+strings2)
                binding.recyclerView.layoutManager = LinearLayoutManager(activity)
                binding.recyclerView.adapter = CustomAdapter(strings.toTypedArray(),strings2.toTypedArray())

            }//if not vacio

        }//mostrarclick
        binding.btnEliminar.setOnClickListener {
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
                Toast.makeText(activity,e.message, Toast.LENGTH_LONG).show()

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
                Toast.makeText(activity,e.message, Toast.LENGTH_LONG).show()

            }//catch

        }
        //var strings2 = archivo2.readLine().split(",")
        //var strings =archivo.readLine().split(",")


        return root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter=CustomAdapter()
        }
    }*/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}