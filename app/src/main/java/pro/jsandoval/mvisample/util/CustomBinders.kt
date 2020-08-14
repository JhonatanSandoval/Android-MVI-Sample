package pro.jsandoval.mvisample.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load

object CustomBinders {

    @JvmStatic
    @BindingAdapter("loadPokemonImage")
    fun loadPokemonImage(imageView: ImageView, imageUrl: String?) {
        imageUrl?.let { imageView.load(imageUrl) { crossfade(true) } }
    }

}