package com.infobooktechnologies.ibpos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.infobooktechnologies.ibpos.R
import com.infobooktechnologies.ibpos.fragment.MenuItemViewFragment
import com.infobooktechnologies.ibpos.model.Category


class CategoryListAdapter(context: Context,menuItemViewFragment: MenuItemViewFragment) : RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>() {

    private var mContext:Context?=null
    private var mMenuItemViewFragment : MenuItemViewFragment?=null
    private var categoryList: List<Category> = ArrayList<Category>()

    init {
        mContext = context
        mMenuItemViewFragment= menuItemViewFragment
    }

    fun loadAllCategory(categories: List<Category>){
        categoryList = categories
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_item_category,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindView(categoryList[position], position)
    }

    override fun getItemCount(): Int {
       return categoryList.size
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        lateinit var categoryName:TextView
        fun bindView(category: Category, position: Int){
            categoryName = itemView.findViewById(R.id.category_name)
            categoryName.text = category.categoryName

            itemView.setOnClickListener {
                mMenuItemViewFragment!!.selectedCategoryId(category.categoryId)
            }
        }
    }
}