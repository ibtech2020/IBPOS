package com.infobooktechnologies.ibpos.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.infobooktechnologies.ibpos.model.Category
import com.infobooktechnologies.ibpos.model.MenuItem
import com.infobooktechnologies.ibpos.other.Constants

@Database(entities = [MenuItem::class,Category::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun menuItemDAO() :ItemDAO


    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, Constants.DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }


}