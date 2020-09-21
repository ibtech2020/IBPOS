package com.infobooktechnologies.ibpos.room

import android.app.Application
import androidx.lifecycle.LiveData
import com.infobooktechnologies.ibpos.model.Category
import com.infobooktechnologies.ibpos.model.MenuItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MenuItemRepository(application: Application) : CoroutineScope{

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var menuItemDAO:ItemDAO

    init {

        val database: AppDatabase = AppDatabase.getAppDataBase(
            application.applicationContext
        )!!
        menuItemDAO = database.menuItemDAO()
    }

    fun getMenuItems(categoryId: String) = menuItemDAO.getItemsList(categoryId)
    fun getAllMenuItems() = menuItemDAO.getMenuItems()

    fun getCategories() = menuItemDAO.getCategory()

    fun insertMenuItemToDB(menuItem: MenuItem){
        launch { insertMenuItem(menuItem) }
    }

    fun insertCategoryToDB(category: Category){
        launch { insertCategory(category) }
    }

    private suspend fun insertCategory(category: Category){
        withContext(Dispatchers.IO){
            menuItemDAO.insertCategory(category)
        }
    }

    private suspend fun insertMenuItem(menuItem: MenuItem){
        withContext(Dispatchers.IO){
            menuItemDAO.insertMenuItem(menuItem)
        }
    }
}