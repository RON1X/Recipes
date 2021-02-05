package com.eachubkov.modernfoodrecipesapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eachubkov.modernfoodrecipesapp.models.FoodRecipe
import com.eachubkov.modernfoodrecipesapp.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(var foodRecipe: FoodRecipe) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}