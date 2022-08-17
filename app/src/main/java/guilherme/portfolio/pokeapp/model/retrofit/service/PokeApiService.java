package guilherme.portfolio.pokeapp.model.retrofit.service;

import guilherme.portfolio.pokeapp.model.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeApiService {

    @GET("pokemon/{id}/")
    Call<Pokemon> getPokemon(@Path("id") int id);

}
