package com.portfolio.pokeapp.view.recyclerview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.portfolio.pokeapp.R;
import com.portfolio.pokeapp.model.Pokemon;
import com.portfolio.pokeapp.view.recyclerview.adapter.listener.OnItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

public class ListaPokeAdapter extends RecyclerView.Adapter<ListaPokeAdapter.ViewHolder> {

    private final Context context;
    private final List<Pokemon> pokemons = Arrays.asList(new Pokemon[809]);
    public static OnItemClickListener onItemClickListener;
    public boolean allLoaded = false;

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
        Log.e("Teste #1", "onBindViewHolder: " + position, null);
        Pokemon pokemonToBind = pokemons.get(position);
        if (pokemonToBind != null) {
            holder.bindPokemon(pokemonToBind);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        ListaPokeAdapter.onItemClickListener = onItemClickListener;
    }


    public void update(List<Pokemon> pokemons) {
        notifyItemRangeRemoved(0, this.pokemons.size());
        this.notifyItemRangeInserted(0, this.pokemons.size());
    }

    public void addPokemon(Pokemon pokemon, int position) {
        pokemons.set(position, pokemon);
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        //return pokemons.size();
        return 151;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private final CardView cardView;
        private final TextView campoId;
        private final TextView campoNome;
        private final ImageView campoImagem;
        private Pokemon pokemon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.lista_poke_item_cardview);
            campoId = itemView.findViewById(R.id.lista_poke_item_id);
            campoNome = itemView.findViewById(R.id.lista_poke_item_nome);
            campoImagem = itemView.findViewById(R.id.lista_poke_item_imagem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "teste", Toast.LENGTH_SHORT).show();
                    onItemClickListener.onItemClick(pokemon);
                }
            });

        }

        public void bindPokemon(Pokemon pokemon) {
            assert pokemon != null;
            this.pokemon = pokemon;
            campoId.setText(String.valueOf(pokemon.getId()));
            campoNome.setText(pokemon.getPokeName());
            Picasso.get().load(pokemon.getSprite()).into(campoImagem);
        }

        public CardView getCardView() {
            return cardView;
        }

    }

}
