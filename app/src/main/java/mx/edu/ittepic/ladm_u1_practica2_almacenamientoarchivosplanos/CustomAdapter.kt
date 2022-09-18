package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var arr:Array<String>,var arr2:Array<String>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var images = intArrayOf(
        R.drawable.ic_baseline_shopping_cart_24,
        )

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        var v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = arr[i]
        viewHolder.itemDetail.text=arr2[i]
        viewHolder.itemImage.setImageResource(images[0])

    }

    override fun getItemCount(): Int {
        return arr.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage:ImageView
        var itemTitle:TextView
        var itemDetail:TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImg)
            itemTitle = itemView.findViewById(R.id.itemtitle)
            itemDetail = itemView.findViewById(R.id.itemdeet)

        }//init
    }//inner class
}//customAdapter