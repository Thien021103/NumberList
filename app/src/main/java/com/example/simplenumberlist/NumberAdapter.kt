package com.example.simplenumberlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class NumberAdapter(val items : ArrayList<Int>) : BaseAdapter() {
    override fun getCount(): Int = items.size

    override fun getItem(p0: Int): Any = items[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val intBox: View = LayoutInflater.from(p2?.context).inflate(R.layout.int_box, p2, false)

        val numberView = intBox.findViewById<TextView>(R.id.number)
        numberView.text = items[p0].toString()
        return intBox
    }

}