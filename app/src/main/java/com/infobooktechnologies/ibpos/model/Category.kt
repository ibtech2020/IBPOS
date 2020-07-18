package com.infobooktechnologies.ibpos.model

data class Category(val categoryId:String,
                    val categoryName:String,
                    val categoryDesc:String,
                    val categoryType:String)


data class MenuItem (val itemId:String,
                     val itemName:String,
                     val itemDesc:String,
                     val itemPrice:Double,
                     val itemWeight:String,
                     val itemQty:Int,
                     val itemCategory: Category){
    val level:Level?=null
}

data class Level(val levelId:String,
                 val levelName:String)

data class CartItem(val cartId:String,
                    val menuItem: MenuItem,
                    var addNotes:String)