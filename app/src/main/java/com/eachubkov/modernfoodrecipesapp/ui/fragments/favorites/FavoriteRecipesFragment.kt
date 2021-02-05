package com.eachubkov.modernfoodrecipesapp.ui.fragments.favorites

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eachubkov.modernfoodrecipesapp.R
import com.eachubkov.modernfoodrecipesapp.adapters.FavoriteAdapter
import com.eachubkov.modernfoodrecipesapp.databinding.FragmentFavoriteRecipesBinding
import com.eachubkov.modernfoodrecipesapp.viewmodels.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteRecipesFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private val mAdapter: FavoriteAdapter by lazy { FavoriteAdapter(requireActivity(), mainViewModel) }

    private var _binding: FragmentFavoriteRecipesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavoriteRecipesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.mainViewModel = mainViewModel
        binding.mAdapter = mAdapter

        setHasOptionsMenu(true)

        setupRecyclerView(binding.favoriteRecipesRecyclerView)

        mainViewModel.readFavoriteRecipes.observe(viewLifecycleOwner, {
            mAdapter.setData(it)
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favorite_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.deleteAll_favorite_menu) {
            mainViewModel.deleteAllFavoriteRecipes()
            showSnackBar("All Remove")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).setAction("Okay"){}.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mAdapter.clearContextualActionMode()
    }
}