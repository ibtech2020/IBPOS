package com.infobooktechnologies.ibpos.model

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity
data class Category(@PrimaryKey val categoryId:String,
                    @NonNull val categoryName:String,
                    @NonNull val categoryDesc:String,
                    @NonNull val categoryType:String)

@Entity
data class MenuItem (@PrimaryKey val itemId:String,
                     @NonNull val itemName:String,
                     @NonNull val itemDesc:String,
                     @NonNull val itemPrice:String,
                     @NonNull val itemWeight:String,
                     @NonNull val itemQty:String,
                     @Embedded val category: Category,
                     val isLevel:Boolean
                    )

@Entity
data class Level(@PrimaryKey val levelId:String,
                 @NonNull val levelName:String)
@Entity
data class CartItem(@PrimaryKey val cartId:String,
                    @NonNull val menuItem: MenuItem,
                    @NonNull var addNotes:String)