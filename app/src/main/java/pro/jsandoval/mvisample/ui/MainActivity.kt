package pro.jsandoval.mvisample.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pro.jsandoval.mvisample.R
import pro.jsandoval.mvisample.databinding.ActivityMainBinding
import timber.log.Timber

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val pokemonsAdapter by lazy { PokemonsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
        initViewModel()
    }

    private fun init() {
        binding.rvPokemons.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = pokemonsAdapter
        }
    }

    private fun initViewModel() {
        viewModel.pokemonsUiState
            .onEach { state -> handleState(state) }
            .launchIn(lifecycleScope)

        viewModel.actionChannel.offer(PokemonAction.LoadPokemons)
    }

    private fun handleState(state: PokemonUiState) {
        when (state) {
            is PokemonUiState.Loading -> {
                binding.showLoader = state.isLoading
            }
            is PokemonUiState.Success -> pokemonsAdapter.submitList(state.data)
            is PokemonUiState.Error -> {
                val errorMessage = state.errorMessage
                Timber.e("error message: $errorMessage")
            }
        }
    }
}