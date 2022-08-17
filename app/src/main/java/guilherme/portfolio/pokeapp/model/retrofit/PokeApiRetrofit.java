package guilherme.portfolio.pokeapp.model.retrofit;

import guilherme.portfolio.pokeapp.model.retrofit.service.PokeApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeApiRetrofit {

    private static final String URL_BASE = "https://pokeapi.co/api/v2/";
    private static PokeApiService pokeApiService;

    public PokeApiRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokeApiService = retrofit.create(PokeApiService.class);
    }

public PokeApiService getPokeApiService() { return pokeApiService; }
}
