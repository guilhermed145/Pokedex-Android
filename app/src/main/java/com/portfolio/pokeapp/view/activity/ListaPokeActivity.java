package com.portfolio.pokeapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.portfolio.pokeapp.R;
import com.portfolio.pokeapp.model.Pokemon;
import com.portfolio.pokeapp.model.repository.PokeRepository;
import com.portfolio.pokeapp.view.recyclerview.ListaPokeRecyclerView;
import com.portfolio.pokeapp.view.recyclerview.adapter.ListaPokeAdapter;
import com.portfolio.pokeapp.view.recyclerview.adapter.listener.OnItemClickListener;

public class ListaPokeActivity extends AppCompatActivity {

    private static ListaPokeAdapter adapter;
    private static PokeRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_poke);
        setTitle("");

        Toolbar mainToolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(mainToolbar);

        repository = new PokeRepository(this);
        configuraListaPoke();
    }

    private void configuraListaPoke() {
        ListaPokeRecyclerView listaPoke = findViewById(R.id.lista_poke_recyclerview);
        adapter = new ListaPokeAdapter(this);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Pokemon pokemon) {
                goToPokeInfo(pokemon);
            }
        });
        listaPoke.setAdapter(adapter);
        for (int i = 1; i <= 151; i++) {
            getPokemon(i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_poke, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.sort_by) {
            return true;
        } else if (item.getItemId() == R.id.favorites) {
            return true;
        } else if (item.getItemId() == R.id.choose_random) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void goToPokeInfo(Pokemon pokemon) {
        Intent intent = new Intent(this, InfoPokeActivity.class);
        intent.putExtra("name", pokemon.getPokeName());
        startActivity(intent);
    }

    public static void getPokemon(int id) {
        repository.getPokemonFromApi(new PokeRepository.DataLoadedCallback<Pokemon>() {
            @Override
            public void ifSuccess(Pokemon pokemon) {
                Log.e("Pegou o getPokemon(id)", "Id e nome: " + id + " " + pokemon.getPokeName(), null);
                adapter.addPokemon(pokemon, Integer.parseInt(pokemon.getId()) - 1);
            }

            @Override
            public void ifFailure(String error) {
                Log.e("Erro no getPokemon(id)", "id:" + id, null);
            }
        }, id);
    }

}
