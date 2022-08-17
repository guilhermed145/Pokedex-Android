package guilherme.portfolio.pokeapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonList {
    @SerializedName("results")
    public List<Pokemon> pokemonList;

}
