package com.eachubkov.modernfoodrecipesapp.data.database

import androidx.room.*
import com.eachubkov.modernfoodrecipesapp.data.database.entity.FavoritesEntity
import com.eachubkov.modernfoodrecipesapp.data.database.entity.FoodJokeEntity
import com.eachubkov.modernfoodrecipesapp.data.database.entity.RecipesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    @Query("SELECT * FROM recipes_table ORDER BY id ASC")
    fun readRecipes(): Flow<List<RecipesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteRecipe(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM favorite_table ORDER BY id ASC")
    fun readFavoriteRecipes(): Flow<List<FavoritesEntity>>

    @Delete
    suspend fun deleteFavoriteRecipe(favoritesEntity: FavoritesEntity)

    @Query("DELETE FROM favorite_table")
    suspend fun deleteAllFavoriteRecipes()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodJoke(foodJokeEntity: FoodJokeEntity)

    @Query("SELECT * FROM food_joke_table ORDER BY id ASC")
    fun readFoodJoke(): Flow<List<FoodJokeEntity>>
}