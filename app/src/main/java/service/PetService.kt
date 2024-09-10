package service

import Repository.PetRepository
import android.content.Context
import model.Pet

class PetService(context: Context) {
    val repositoryPet : PetRepository = PetRepository(context);

    fun create(pet: Pet) {
        repositoryPet.create(pet)
    }
}