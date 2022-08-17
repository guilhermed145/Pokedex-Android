package guilherme.portfolio.pokeapp.view.recyclerview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import guilherme.portfolio.pokeapp.R;
import guilherme.portfolio.pokeapp.model.Pokemon;

public class ListaPokeAdapter extends RecyclerView.Adapter<ListaPokeAdapter.ViewHolder> {

    private final Context context;
    private final List<Pokemon> pokemons = new ArrayList<>();

    public ListaPokeAdapter(Context context) {

        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_lista_poke, parent, false);
        return new ViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.e("Teste #1", "onBindViewHolder: " + pokemons.toString(), null);
        Pokemon pokemon = pokemons.get(position);
        holder.bindPokemons(pokemon);
    }

    public void update(List<Pokemon> pokemons) {
        notifyItemRangeRemoved(0, this.pokemons.size());
        this.pokemons.clear();
        this.pokemons.addAll(pokemons);
        this.notifyItemRangeInserted(0, this.pokemons.size());
    }

    @Override
    public int getItemCount() {
        return 809;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final CardView cardView;
        private final TextView campoId;
        private final TextView campoNome;
        private Pokemon pokemon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.lista_poke_item_cardview);
            campoId = itemView.findViewById(R.id.lista_poke_item_id);
            campoNome = itemView.findViewById(R.id.lista_poke_item_nome);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "teste", Toast.LENGTH_SHORT).show();
                }
            });

        }

        public void bindPokemons(Pokemon pokemon) {
            this.pokemon = pokemon;
            //campoId.setText(String.valueOf(pokemon.getId()));
            campoNome.setText(pokemon.getPokeName());
        }

        public CardView getCardView() {
            return cardView;
        }


    }

}
