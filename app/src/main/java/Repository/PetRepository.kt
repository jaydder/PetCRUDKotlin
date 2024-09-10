package Repository

import android.content.Context
import database.Database
import model.Pet

class PetRepository(context: Context) {
    val db = Database(context);

    fun create(pet: Pet) {
        val query = "INSERT INTO pets (name, age, breed) VALUES ('${pet.name}', ${pet.age}, '${pet.breed}')"
        db.writableDatabase.execSQL(query)
    }

    fun getAll(): ArrayList<Pet?> {
        val query = "SELECT * FROM pets"
        val cursor = db.readableDatabase.rawQuery(query, null)
        val pets = ArrayList<Pet?>()
        while (cursor.moveToNext()) {
            val pet = Pet(
                cursor.getString(cursor.getColumnIndex("name")),
                cursor.getInt(cursor.getColumnIndex("age")).toString(),
                cursor.getString(cursor.getColumnIndex("breed"))
            )
            pets.add(pet)
        }
        cursor.close()
        return pets
    }

}