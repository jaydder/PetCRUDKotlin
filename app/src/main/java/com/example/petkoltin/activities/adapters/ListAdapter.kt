package com.example.petkoltin.activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.petkoltin.R
import model.Pet

class ListAdapter (context: Context, dataArrayList: ArrayList<Pet?>?):
ArrayAdapter<Pet?>(context, R.layout.list_item, dataArrayList!!){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val listData = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }
        val listName: TextView = view!!.findViewById(R.id.listName)
        val listAge: TextView = view!!.findViewById(R.id.listAge)
        val listBreed: TextView = view!!.findViewById(R.id.listBreed)

        if (listData != null) {
            listName.text = listData.name
            listAge.text = listData.age.toString()
            listBreed.text = listData.breed
        }
        return view
    }
}