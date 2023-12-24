package com.example.listview_encyclopediaapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(private val context: Activity, private val arrayList: ArrayList<Item>):
    ArrayAdapter<Item>(context,R.layout.eachitem,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //sets view to see all items with data
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.eachitem,null)

        //finds all item ids through view to view :)
        val name = view.findViewById<TextView>(R.id.tvName)
        val sci_name = view.findViewById<TextView>(R.id.tvSciNmae)
        val species = view.findViewById<TextView>(R.id.tvSpecies)
        val places = view.findViewById<TextView>(R.id.tvPlaces)
        val img = view.findViewById<CircleImageView>(R.id.profile_image)

        //get info from 'Item' data class
        name.text = arrayList[position].name
        sci_name.text = arrayList[position].sci_name
        species.text = arrayList[position].species
        places.text = arrayList[position].placeToFound
        img.setImageResource(arrayList[position].img)

        return view
    }
}