package com.portfolio.pokeapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pokemon {

    @PrimaryKey
    private final String id;
    private final String name;
    private final PokemonSprites sprites;
    private final List<PokemonTypes> types;
    private final String height;
    private final String weight;
    private final List<PokemonStats> stats;

    public Pokemon (String id, String name, PokemonSprites sprites, List<PokemonTypes> types, String height, String weight, List<PokemonStats> stats) {
        this.id = id;
        this.name = name;
        this.sprites = sprites;
        this.types = types;
        this.height = height;
        this.weight = weight;
        this.stats = stats;
    }

    public String getId() {
        return id;
    }

    public String getPokeName() {
        return name;
    }

    public String getSprite() {
        return sprites.frontDefault;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public String getArtworkSprite() {
        return sprites.otherSprites.officialArtwork.artworkFrontDefault;
    }

    public List<String> getTypes() {
        if (types == null) return null;
        List<String> typesToString = new ArrayList<>();
        PokemonTypes firstType = types.get(0);
        typesToString.add(firstType.type.typeName);
        if (types.size() < 2) {
            return typesToString;
        }
        PokemonTypes secondType = types.get(1);
        typesToString.add(secondType.type.typeName);
        return typesToString;
    }

    public List<String> getStats() {
        if (stats == null) return null;
        List<String> statsToString = new ArrayList<>();
        for (int i = 0; i < stats.size(); i++) {
            statsToString.add(stats.get(i).baseStat);
        }
        return statsToString;
    }

    private class PokemonSprites {
        @SerializedName("front_default")
        private final String frontDefault;
        @SerializedName("other")
        private final OtherSprites otherSprites;

        PokemonSprites(String frontDefault, OtherSprites otherSprites){
            this.frontDefault = frontDefault;
            this.otherSprites = otherSprites;
        }

        private class OtherSprites {
            @SerializedName("official-artwork")
            private final OfficialArtwork officialArtwork;

            OtherSprites(OfficialArtwork officialArtwork) {
                this.officialArtwork = officialArtwork;
            }

            private class OfficialArtwork {
                @SerializedName("front_default")
                private final String artworkFrontDefault;

                OfficialArtwork(String artworkFrontDefault) {
                    this.artworkFrontDefault = artworkFrontDefault;
                }

            }
        }
    }

    private class PokemonTypes {
        @SerializedName("type")
        private final PokemonType type;

        PokemonTypes(PokemonType type) {
            this.type = type;
        }

        private class PokemonType {
            @SerializedName("name")
            private final String typeName;

            PokemonType(String typeName) {
                this.typeName = typeName;
            }
        }

    }

    private class PokemonStats {
        @SerializedName("base_stat")
        private final String baseStat;

        PokemonStats(String baseStat){
            this.baseStat = baseStat;
        }

    }
}

