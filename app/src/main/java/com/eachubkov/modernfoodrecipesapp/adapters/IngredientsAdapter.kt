package com.eachubkov.modernfoodrecipesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.eachubkov.modernfoodrecipesapp.R
import com.eachubkov.modernfoodrecipesapp.databinding.IngredientsRowLayoutBinding
import com.eachubkov.modernfoodrecipesapp.models.ExtendedIngredient
import com.eachubkov.modernfoodrecipesapp.util.Constants.Companion.BASE_IMAGE_URL
import com.eachubkov.modernfoodrecipesapp.util.MyDiffUtil
import java.util.*

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {

    private var ingredientsList = emptyList<ExtendedIngredient>()

    class ViewHolder(val binding: IngredientsRowLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(IngredientsRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.ingredientsImageView.load(BASE_IMAGE_URL + ingredientsList[position].image) {
            crossfade(600)
            error(R.drawable.ic_error_placeholder)
        }
        holder.binding.ingredientsName.text = ingredientsList[position].name.capitalize(Locale.ROOT)
        holder.binding.ingredientsAmount.text = ingredientsList[position].amount.toString()
        holder.binding.ingredientsUnit.text = ingredientsList[position].unit
        holder.binding.ingredientsConsistency.text = ingredientsList[position].consistency
        holder.binding.ingredientsOriginal.text = ingredientsList[position].original
    }

    override fun getItemCount(): Int {
        return ingredientsList.size
    }

    fun setData(newIngredients: List<ExtendedIngredient>) {
        val ingredientsDiffUtil = MyDiffUtil(ingredientsList, newIngredients)
        val diffUtilResult = DiffUtil.calculateDiff(ingredientsDiffUtil)
        ingredientsList = newIngredients
        diffUtilResult.dispatchUpdatesTo(this)
    }
}