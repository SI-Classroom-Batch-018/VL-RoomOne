package de.syntax_institut.vl_beispiel_room.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntax_institut.vl_beispiel_room.data.model.Guest

class Datasource private constructor() {

    private val _guestList = MutableLiveData<List<Guest>>(listOf())
    private val guestList: LiveData<List<Guest>>
        get() = _guestList

    fun getGuests(): LiveData<List<Guest>> {
        return guestList
    }

    fun insertGuest(guest: Guest) {
        val newList = _guestList.value!!.toMutableList()
        newList.add(guest)
        _guestList.value = newList
    }

    companion object {
        val INSTANCE = Datasource()
    }
}