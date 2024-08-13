package de.syntax_institut.vl_beispiel_room.data

import androidx.lifecycle.LiveData
import de.syntax_institut.vl_beispiel_room.data.local.GuestDatabase
import de.syntax_institut.vl_beispiel_room.data.model.Guest

class Repository(private val databse: GuestDatabase) {
    val guestList: LiveData<List<Guest>> = databse.dao.getGuests()

     suspend fun addGuest(guest: Guest) {
        databse.dao.insertGuest(guest)
    }
}