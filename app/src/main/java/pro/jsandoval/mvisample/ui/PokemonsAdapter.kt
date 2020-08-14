package pro.jsandoval.mvisample.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import pro.jsandoval.mvisample.databinding.ItemPokemonBinding
import pro.jsandoval.mvisample.domain.model.Pokemon
import pro.jsandoval.mvisample.util.BindingViewHolder
import pro.jsandoval.mvisample.util.inflater

class PokemonsAdapter : ListAdapter<Pokemon, PokemonViewHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder = PokemonViewHolder(parent)

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.binding.pokemon = item
    }

}

class PokemonViewHolder(
    parent: ViewGroup,
    val binding: ItemPokemonBinding = ItemPokemonBinding.inflate(parent.inflater(), parent, false)
) : BindingViewHolder<ItemPokemonBinding>(binding.root)

class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {
    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.name == newItem.name
    }
}