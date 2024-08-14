package de.syntax_institut.vl_beispiel_room.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import de.syntax_institut.vl_beispiel_room.data.Datasource
import de.syntax_institut.vl_beispiel_room.data.Repository
import de.syntax_institut.vl_beispiel_room.data.local.getDatabase
import de.syntax_institut.vl_beispiel_room.data.model.Guest
import kotlinx.coroutines.launch

class GuestViewModel(application: Application): AndroidViewModel(application) {
    private val repo = Repository(getDatabase(application))
    val guestList = repo.guestList

    private val _selectedUser = MutableLiveData<Guest>()
    val selectedUser: LiveData<Guest>
        get() = _selectedUser

    fun addGuest(guest: Guest) {
        viewModelScope.launch {
            repo.addGuest(guest)
        }
    }

    fun selectUser(guest: Guest) {
        _selectedUser.value = guest
    }

    fun deleteGuest() {
        if (_selectedUser.value != null) {
            Log.i("DELETE", "deleteGuest: ${_selectedUser.value}")
            viewModelScope.launch {
                repo.deleteGuest(_selectedUser.value!!)
            }
        }
    }

    fun updateGuest(name: String, food: String) {
        _selectedUser.value?.name = name
        _selectedUser.value?.food = food

        viewModelScope.launch {
            repo.updateUser(_selectedUser.value!!)
        }
    }

}