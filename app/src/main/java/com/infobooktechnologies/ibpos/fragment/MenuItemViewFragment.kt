package com.infobooktechnologies.ibpos.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infobooktechnologies.ibpos.R
import com.infobooktechnologies.ibpos.adapter.CategoryListAdapter
import com.infobooktechnologies.ibpos.adapter.MenuItemListAdapter
import com.infobooktechnologies.ibpos.model.Category
import com.infobooktechnologies.ibpos.model.Level
import com.infobooktechnologies.ibpos.model.MenuItem
import com.infobooktechnologies.ibpos.other.EqualSpacingItemDecoration
import com.infobooktechnologies.ibpos.viewmodels.MenuItemViewModel
import java.util.ArrayList

class MenuItemViewFragment : Fragment(),LifecycleOwner {
    private lateinit var menuItemViewModel:MenuItemViewModel
    private var menuItemListAdapter :MenuItemListAdapter?=null
    private var categoryListAdapter:CategoryListAdapter?=null
    private var recyclerViewMenuItem: RecyclerView?=null
    private var recyclerViewCategory: RecyclerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//         menuItemViewModel = ViewModelProviders.of(activity!!).get(MenuItemViewModel::class.java)
        menuItemViewModel = ViewModelProvider(activity!!).get(MenuItemViewModel::class.java)
//        selectedCategoryId("1")

//        loadTestMenuItem()
        menuItemViewModel!!.searchWithCategoryId("1")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu_item_view,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewMenuItem = view.findViewById(R.id.menu_item_list) as RecyclerView
        recyclerViewCategory = view.findViewById(R.id.category_list) as RecyclerView

        recyclerViewCategory!!.layoutManager = LinearLayoutManager(activity,
            RecyclerView.VERTICAL, false)
        categoryListAdapter = CategoryListAdapter(activity!!,this)
        recyclerViewCategory!!.adapter = categoryListAdapter

        menuItemListAdapter = MenuItemListAdapter(activity!!)
        recyclerViewMenuItem!!.layoutManager = GridLayoutManager(activity, 3)
        recyclerViewMenuItem!!.addItemDecoration(
            EqualSpacingItemDecoration(
                55,
                EqualSpacingItemDecoration.GRID
            )
        )
        recyclerViewMenuItem!!.adapter = menuItemListAdapter

//        selectedCategoryId("0")



        menuItemViewModel!!.menuItemList.observe(activity!!, Observer {

            println(it)
            if (!it.isNullOrEmpty()) {
                menuItemListAdapter!!.updateTheAdapter(it)
                menuItemListAdapter!!.notifyDataSetChanged()
            }
        })

        menuItemViewModel!!.getListOfCategory().observe(activity!!, Observer {
            categoryListAdapter!!.loadAllCategory(it)
        })
    }


    fun loadTestMenuItem(){

//        var category_List = ArrayList<Category>()
//        var level_List = ArrayList<Level>()
//        category_List.add(Category("1", "Appetizer", "Appetizer is a menu", "Lunch"))
//        category_List.add(Category("2", "MainCourse", "Appetizer is a menu", "Breakfast"))
//        category_List.add(Category("3", "Dessert", "Appetizer is a menu", "Dinner"))
//        category_List.add(Category("4", "Bread", "Appetizer is a menu", "Lunch"))
//
//        menuItemViewModel!!.insertCategory(category_List)
//
//        level_List.add(Level("1","Hot"))
//        level_List.add(Level("2","Medium"))
//        level_List.add(Level("3","Mild"))
//
//
//
//        menuItemViewModel!!.insertMenuItem( MenuItem("1", "Idilly", "Idilly is a menu Item", "2 pcs", "10.00","2",category_List[3],true))
//        menuItemViewModel!!.insertMenuItem( MenuItem("2", "Dosa", "Idilly is a menu Item", "2 pcs", "10.00","2", category_List[1],false))
//        menuItemViewModel!!.insertMenuItem( MenuItem("3", "Poori", "Idilly is a menu Item", "2 pcs", "10.00","2", category_List[0],false))
//        menuItemViewModel!!.insertMenuItem( MenuItem("4", "VADAI", "Idilly is a menu Item", "2 pcs", "10.00","2", category_List[2],true))


//        GlobalScope.launch {
//            db!!.menuItemDAO().insertMenuItem( MenuItem("111", "Idilly", "Idilly is a menu Item", "2 pcs", "10.00","2"))
//            println(db!!.menuItemDAO().getMenuItems())
//        }
//        menuItemViewModel!!.getListOfItems("3")

    }

    /*Request From CategoryList Adapter*/

    fun selectedCategoryId(categoryId:String){
//        menuItemViewModel!!.triggerMenuItemRepo(categoryId)
        menuItemViewModel!!.searchWithCategoryId(categoryId)
    }
}