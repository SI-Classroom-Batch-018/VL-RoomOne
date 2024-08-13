package de.syntax_institut.vl_beispiel_room.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import de.syntax_institut.vl_beispiel_room.data.Datasource
import de.syntax_institut.vl_beispiel_room.data.Repository
import de.syntax_institut.vl_beispiel_room.data.local.getDatabase
import de.syntax_institut.vl_beispiel_room.data.model.Guest
import kotlinx.coroutines.launch

class GuestViewModel(application: Application): AndroidViewModel(application) {
    private val repo = Repository(getDatabase(application))
    val guestList = repo.guestList

    fun addGuest(guest: Guest) {
        viewModelScope.launch {
            repo.addGuest(guest)
        }
    }
}