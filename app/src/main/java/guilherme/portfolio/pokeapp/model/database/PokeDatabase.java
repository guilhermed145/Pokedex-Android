
/*
package guilherme.portfolio.pokeapp.viewmodel.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import guilherme.portfolio.pokeapp.model.Pokemon;
import guilherme.portfolio.pokeapp.viewmodel.database.dao.PokeDAO;

@Database(entities = {Pokemon.class}, version = 1, exportSchema = false)
public abstract class PokeDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "pokemon.db";

    public abstract PokeDAO getPokeDao();

    public static PokeDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, PokeDatabase.class, DATABASE_NAME).build();
    }

}
*/