package com.infobooktechnologies.ibpos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.infobooktechnologies.ibpos.R
import com.infobooktechnologies.ibpos.model.MenuItem

class MenuItemListAdapter(context: Context) : RecyclerView.Adapter<MenuItemListAdapter.MenuItemViewHolder>() {
    private var mContext: Context?=null
    private var cartItemList: List<MenuItem?>? = ArrayList()

    init {
        mContext = context
    }

    fun updateTheAdapter(menuItemList:List<MenuItem?>?){
        cartItemList = menuItemList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        return MenuItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_menu_item, parent, false))
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bindView(cartItemList!![position]!!)
    }

    override fun getItemCount(): Int {
        return cartItemList!!.size
    }

    inner class MenuItemViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        private lateinit var itemName:TextView

        fun bindView(menuItem: MenuItem){
            itemName = itemView.findViewById(R.id.item_name)
            itemName.text = menuItem.itemName
        }
    }
}