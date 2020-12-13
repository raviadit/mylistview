package com.example.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class PresidenAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var heroes = arrayListOf<Presiden>()

    override fun getCount(): Int = heroes.size

    override fun getItem(i: Int): Any = heroes[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_presiden, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val presiden = getItem(position) as Presiden
        viewHolder.bind(presiden)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(presiden:Presiden) {
            txtName.text = presiden.name
            txtDescription.text = presiden.description
            imgPhoto.setImageResource(presiden.photo)
        }
    }
}