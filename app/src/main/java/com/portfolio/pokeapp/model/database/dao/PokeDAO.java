/*

package guilherme.portfolio.pokeapp.viewmodel.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import guilherme.portfolio.pokeapp.model.Pokemon;

@Dao
public interface PokeDAO {

    @Insert
    long salva(Pokemon pokemon);

    @Update
    void atualiza(Pokemon pokemon);

    @Query("SELECT * FROM Pokemon")
    List<Pokemon> buscaTodos();

    @Query("SELECT * FROM Pokemon WHERE id = :id")
    Pokemon buscaPokemon(long id);

    @Delete
    void remove(Pokemon pokemon);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void salva(List<Pokemon> pokemons);

}


 */