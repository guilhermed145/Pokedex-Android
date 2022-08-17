package guilherme.portfolio.pokeapp.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import guilherme.portfolio.pokeapp.R;
import guilherme.portfolio.pokeapp.model.Pokemon;
import guilherme.portfolio.pokeapp.model.repository.PokeRepository;
import guilherme.portfolio.pokeapp.view.recyclerview.ListaPokeRecyclerView;
import guilherme.portfolio.pokeapp.view.recyclerview.adapter.ListaPokeAdapter;

public class ListaPokeActivity extends AppCompatActivity {

    private ListaPokeAdapter adapter;
    private PokeRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_poke);
        setTitle("");

        Toolbar mainToolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(mainToolbar);

        configuraListaPoke();

        repository = new PokeRepository(this);

        getPokemons();
    }

    private void configuraListaPoke() {

        ListaPokeRecyclerView listaPoke = findViewById(R.id.lista_poke_recyclerview);
        adapter = new ListaPokeAdapter(this);
        listaPoke.setAdapter(adapter);

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

    private void getPokemons() {
        repository.getPokemon(new PokeRepository.DataLoadedCallback<Pokemon>() {
            @Override
            public void ifSuccess(Pokemon newPokemon) {
                //adapter.update(newPokemon);
                Log.e("Teste #2", "getPokemon() ifSuccess: " + newPokemon.toString(), null);
            }
            @Override
            public void ifFailure(String error) {
                //Log.e("Teste #2", error, null);
                Toast.makeText(ListaPokeActivity.this,
                        "Falha ao carregar a pokedex.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    };
}
