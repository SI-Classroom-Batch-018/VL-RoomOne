package de.syntax_institut.vl_beispiel_room.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntax_institut.vl_beispiel_room.data.model.Guest

@Database(entities = [Guest::class], version = 1)
abstract class GuestDatabase : RoomDatabase() {
    abstract val dao: GuestDatabaseDao
}

private lateinit var INSTANCE: GuestDatabase

fun getDatabase(context: Context): GuestDatabase {

    synchronized(GuestDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                GuestDatabase::class.java,
                "guest_database"
            ).build()
        }
        return INSTANCE
    }
}