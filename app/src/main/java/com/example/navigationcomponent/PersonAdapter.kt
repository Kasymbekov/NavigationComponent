package com.example.navigationcomponent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationcomponent.databinding.ItemPersonBinding
import java.util.ArrayList

class PersonAdapter(private val data: ArrayList<Person>, private val onItemClick: OnItemClick) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            ItemPersonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(data.get(position))
        holder.itemView.setOnClickListener {
            onItemClick.onItemClick(position)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class PersonViewHolder(private val binding: ItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person) {
            binding.name.text = person.name
            binding.title.text = person.title
            person.image?.let { binding.image.setImageResource(it) }
        }

    }
}