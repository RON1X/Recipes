package com.eachubkov.modernfoodrecipesapp.bindingadapters

import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eachubkov.modernfoodrecipesapp.adapters.FavoriteAdapter
import com.eachubkov.modernfoodrecipesapp.data.database.entity.FavoritesEntity

class FavoriteBinding {

    companion object {
        @BindingAdapter("setVisibility", "setData", requireAll = false)
        @JvmStatic
        fun setVisibility(view: View, favoritesEntity: List<FavoritesEntity>?, mAdapter: FavoriteAdapter?) {
            when (view) {
                is RecyclerView -> {
                    val dataCheck = favoritesEntity.isNullOrEmpty()
                    view.isInvisible = dataCheck
                    if (!dataCheck) {
                        favoritesEntity?.let { mAdapter?.setData(it) }
                    }
                }
                else -> view.isVisible = favoritesEntity.isNullOrEmpty()
            }
        }
    }
}