package pro.jsandoval.mvisample.domain.model

data class Pokemon(
    val name: String,
    val url: String
) {
    private fun getNumber(): Int {
        val urlSplitter = url.split("/")
        return Integer.parseInt(urlSplitter[urlSplitter.size - 2])
    }

    fun getImage(): String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${getNumber()}.png"
}