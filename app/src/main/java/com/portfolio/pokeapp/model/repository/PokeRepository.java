package com.portfolio.pokeapp.model.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.portfolio.pokeapp.model.Pokemon;
import com.portfolio.pokeapp.model.retrofit.PokeApiRetrofit;
import com.portfolio.pokeapp.model.retrofit.callback.PokeCallback;
import com.portfolio.pokeapp.model.retrofit.service.PokeApiService;
import retrofit2.Call;

public class PokeRepository {

    private final PokeApiService service;
    public Pokemon selectedPokemon;

    public PokeRepository(Context context) {
        service = new PokeApiRetrofit().getPokeApiService();
    }

    public Pokemon getPokemon(int id) {
        getPokemonFromApi(new DataLoadedCallback<Pokemon>()  {
            @Override
            public void ifSuccess(Pokemon pokemon) {
                selectedPokemon = pokemon;
            }

            @Override
            public void ifFailure(String erro) {
                Log.e("Pokemon loading error",erro);
            }
        }, id);
        return selectedPokemon;
    }

    public void getPokemonFromApi(DataLoadedCallback<Pokemon> callback, int id) {
        Call<Pokemon> call = service.getPokemon(id);
        call.enqueue(new PokeCallback<>(
                new PokeCallback.CallbackResponse<Pokemon>() {
                    @Override
                    public void ifFailure(String error) {
                        Log.e("Teste #3", "ifFailure: " + error, null);
                        callback.ifFailure(error);
                    }

                    @Override
                    public void ifSuccess(Pokemon resultado) {
                        Log.e("Teste #3", "ifSuccess: " + resultado.getStats(), null);
                        callback.ifSuccess(resultado);
                    }
                }));
    }


    public interface DataLoadedCallback<T> {
        void ifSuccess(T resultado);
        void ifFailure(String error);
    }

}
