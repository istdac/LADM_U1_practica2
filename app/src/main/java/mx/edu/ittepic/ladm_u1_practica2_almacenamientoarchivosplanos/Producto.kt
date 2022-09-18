package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos

class Producto(val name:String) {
    companion object{
        private var lastProd=0
        fun createCarrito(numProd:Int):ArrayList<Producto>{
            val prods = ArrayList<Producto>()
            for (i in 1..numProd){
                //prods.add(Producto())
            }//for
            return prods
        }//createCarrito

    }//cobject
}