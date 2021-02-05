package com.eachubkov.modernfoodrecipesapp.data.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eachubkov.modernfoodrecipesapp.models.FoodJoke
import com.eachubkov.modernfoodrecipesapp.util.Constants.Companion.FOOD_JOKE_TABLE

@Entity(tableName = FOOD_JOKE_TABLE)
class FoodJokeEntity(@Embedded var foodJoke: FoodJoke) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}