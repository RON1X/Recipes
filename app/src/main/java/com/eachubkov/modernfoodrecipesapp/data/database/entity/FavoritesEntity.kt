package com.eachubkov.modernfoodrecipesapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eachubkov.modernfoodrecipesapp.models.Result
import com.eachubkov.modernfoodrecipesapp.util.Constants.Companion.FAVORITE_TABLE

@Entity(tableName = FAVORITE_TABLE)
data class FavoritesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)