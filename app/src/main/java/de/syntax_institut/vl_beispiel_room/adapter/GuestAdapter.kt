package de.syntax_institut.vl_beispiel_room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import de.syntax_institut.vl_beispiel_room.R
import de.syntax_institut.vl_beispiel_room.data.model.Guest
import de.syntax_institut.vl_beispiel_room.databinding.GuestItemBinding
import de.syntax_institut.vl_beispiel_room.ui.GuestViewModel

class GuestAdapter(
    private var dataset: List<Guest>,
    private var viewModel: GuestViewModel
): RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {
    inner class GuestViewHolder(val binding: GuestItemBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GuestViewHolder {
        val binding = GuestItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GuestViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(
        holder: GuestViewHolder,
        position: Int
    ) {
        val guest = dataset[position]

        holder.binding.tvGuestName.text = guest.name
        holder.binding.tvGuestFood.text = guest.food

        holder.binding.cvGuestItem.setOnClickListener {
            viewModel.selectUser(guest)
            holder.itemView.findNavController().navigate(R.id.editFragment)
        }
    }
}