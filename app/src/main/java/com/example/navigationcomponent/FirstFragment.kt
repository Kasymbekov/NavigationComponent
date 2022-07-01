package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), OnItemClick {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var list: ArrayList<Person>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = arrayListOf(
            Person(
                "Rick Sanchez",
                "Alive",
                R.drawable.rick

            ),
            Person(
                "Morty Smith",
                "Alive",
                R.drawable.morty

            ),
            Person(
                "Albert Einstein",
                "Dead",
                R.drawable.albert

            ),
            Person(
                "Jerry Smith",
                "Alive",
                R.drawable.jerry

            ),
            Person(
                "Rick Sanchez",
                "Alive",
                R.drawable.rick

            )

        )
        val adapter = PersonAdapter(list, this)
        binding.recyclerview.adapter = adapter
    }

    override fun onItemClick(position: Int) {
//        Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment, Bundle().apply {
            putString("key1", list.get(position).name)
            putString("key2", list.get(position).title)
            list.get(position).image?.let { putInt("key3", it) }
        })
    }
}