package guilherme.portfolio.pokeapp.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import guilherme.portfolio.pokeapp.R;

public class InfoPokeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_poke);
        setTitle("");

        Toolbar mainToolbar = findViewById(R.id.toolbar_main);
        mainToolbar.inflateMenu(R.menu.menu_lista_poke);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Setinha de voltar
    }
}