package Repository

import android.content.Context
import android.util.Log
import database.Database
import model.Pet

class PetRepository(context: Context) {
    val db = Database(context);

    fun create(pet: Pet) {
        val query = "INSERT INTO pets (name, age, breed) VALUES ('${pet.name}', ${pet.age}, '${pet.breed}')"
        db.writableDatabase.execSQL(query)
    }

}