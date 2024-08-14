package de.syntax_institut.vl_beispiel_room.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.syntax_institut.vl_beispiel_room.data.model.Guest

@Dao
interface GuestDatabaseDao {

    @Insert
    suspend fun insertGuest(guest: Guest)

    @Query("SELECT * FROM guest")
    fun getGuests(): LiveData<List<Guest>>

    // Beispiel für weitere Livedata
    @Query("SELECT * FROM guest WHERE food = 'Pizza'")
    fun getGuestsWhoLikePizza(): LiveData<List<Guest>>

    @Delete
    suspend fun deleteGuest(guest: Guest)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(guest: Guest)
}