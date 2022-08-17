package guilherme.portfolio.pokeapp.model.repository;

import android.content.Context;
import android.util.Log;

import guilherme.portfolio.pokeapp.model.Pokemon;
import guilherme.portfolio.pokeapp.model.retrofit.PokeApiRetrofit;
import guilherme.portfolio.pokeapp.model.retrofit.callback.PokeCallback;
import guilherme.portfolio.pokeapp.model.retrofit.service.PokeApiService;
import retrofit2.Call;

public class PokeRepository {

    private final PokeApiService service;

    public PokeRepository(Context context) {
        service = new PokeApiRetrofit().getPokeApiService();
    }

    public void getPokemon(DataLoadedCallback<Pokemon> callback) {
        getPokemonFromApi(callback, 1);
    }

    private void getPokemonFromApi(DataLoadedCallback<Pokemon> callback, int id) {
        Call<Pokemon> call = service.getPokemon(id);
        call.enqueue(new PokeCallback<>(
                new PokeCallback.CallbackResponse<Pokemon>() {
                    @Override
                    public void ifFailure(String error) {
                        callback.ifFailure(error);
                    }

                    @Override
                    public void ifSuccess(Pokemon resultado) {
                        callback.ifSuccess(resultado);
                        Log.e("Teste #3", "ifSuccess: " + resultado.getStats(), null);
                    }
                }));
    }


    public interface DataLoadedCallback<T> {
        void ifSuccess(T resultado);
        void ifFailure(String error);
    }

}
