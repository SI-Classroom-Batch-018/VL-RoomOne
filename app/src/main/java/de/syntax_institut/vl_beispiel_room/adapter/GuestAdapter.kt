package de.syntax_institut.vl_beispiel_room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import de.syntax_institut.vl_beispiel_room.data.model.Guest
import de.syntax_institut.vl_beispiel_room.databinding.GuestItemBinding

class GuestAdapter(
    private var dataset: List<Guest>
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
    }
}