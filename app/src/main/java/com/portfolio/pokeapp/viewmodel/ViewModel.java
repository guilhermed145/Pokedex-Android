package com.portfolio.pokeapp.viewmodel;

import android.content.Context;

import com.portfolio.pokeapp.model.Pokemon;
import com.portfolio.pokeapp.model.repository.PokeRepository;

public class ViewModel {

    Context context;
    PokeRepository repository;

    public ViewModel(){
        repository = new PokeRepository(context);
    }

    public Pokemon getPokemon(int id) {
        return repository.getPokemon(id);
    }

}
