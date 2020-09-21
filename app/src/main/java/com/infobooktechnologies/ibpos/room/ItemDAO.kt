package com.infobooktechnologies.ibpos.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.infobooktechnologies.ibpos.model.Category
import com.infobooktechnologies.ibpos.model.MenuItem

@Dao
interface ItemDAO {

    /*GET ALL MENU ITEM for a given categoryId*/
    @Query("SELECT * FROM MenuItem WHERE categoryId LIKE :categoryId ")
    fun getItemsList(categoryId:String):List<MenuItem>

    /*INSERT NEW category*/
    @Insert
    fun insertCategory(category: Category)

    /*GET all category*/
    @Query("SELECT * FROM Category")
    fun getCategory():LiveData<List<Category>>

    /*INSERT NEW menuItem*/
    @Insert
    fun insertMenuItem(menuItem: MenuItem)

    /*GET ALL MENU ITEM*/
    @Query("SELECT * FROM MenuItem")
    fun getMenuItems():LiveData<List<MenuItem>>
}