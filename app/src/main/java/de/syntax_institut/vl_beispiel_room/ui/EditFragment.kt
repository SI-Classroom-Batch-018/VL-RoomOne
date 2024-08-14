package de.syntax_institut.vl_beispiel_room.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import de.syntax_institut.vl_beispiel_room.data.model.Guest
import de.syntax_institut.vl_beispiel_room.databinding.FragmentEditBinding

class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding
    private val viewModel: GuestViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedUser.observe(viewLifecycleOwner) { guest: Guest ->
            binding.editNameET.setText(guest.name)
            binding.editFoodET.setText(guest.food)
        }

        binding.deleteBTN.setOnClickListener {
            viewModel.deleteGuest()
        }

        binding.saveBTN.setOnClickListener {
            val name = binding.editNameET.text.toString()
            val food = binding.editFoodET.text.toString()

            viewModel.updateGuest(name, food)
        }
    }
}