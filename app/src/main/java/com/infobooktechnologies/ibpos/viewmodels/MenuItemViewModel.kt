package com.infobooktechnologies.ibpos.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.infobooktechnologies.ibpos.model.Category
import com.infobooktechnologies.ibpos.model.MenuItem
import com.infobooktechnologies.ibpos.room.MenuItemRepository
import kotlinx.coroutines.*


class MenuItemViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: MenuItemRepository = MenuItemRepository(application)

    val menuItemList = MutableLiveData<List<MenuItem>>()

    init {

    }


    fun getListOfCategory() = repository.getCategories()

    fun searchWithCategoryId(categoryId: String): LiveData<List<MenuItem>> {

        GlobalScope.launch {
            withContext(Dispatchers.Default) {
                menuItemList.postValue(repository.getMenuItems(categoryId))
            }
        }
        return menuItemList
    }

    fun insertCategory(categories: List<Category>) {
        categories.forEach{
            repository.insertCategoryToDB(it)
        }
    }

    fun insertMenuItem(menuItem: MenuItem) = repository.insertMenuItemToDB(menuItem)

}