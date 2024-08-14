package de.syntax_institut.vl_beispiel_room.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import de.syntax_institut.vl_beispiel_room.R
import de.syntax_institut.vl_beispiel_room.adapter.GuestAdapter
import de.syntax_institut.vl_beispiel_room.data.model.Guest
import de.syntax_institut.vl_beispiel_room.databinding.FragmentGuestBinding


class GuestFragment : Fragment() {

    private lateinit var binding: FragmentGuestBinding
    private val viewModel: GuestViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuestBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        viewModel.guestList.observe(viewLifecycleOwner) {
            binding.rvGuestList.adapter = GuestAdapter(it, viewModel)
        }

        binding.btAddGuest.setOnClickListener {
            val name = binding.etName.text.toString()
            val food = binding.etFood.text.toString()
            if(name.isNotBlank() && food.isNotBlank()) {
                viewModel.addGuest(
                    Guest(null, name, food)
                )
                binding.etName.text.clear()
                binding.etFood.text.clear()
            }
        }
    }
}