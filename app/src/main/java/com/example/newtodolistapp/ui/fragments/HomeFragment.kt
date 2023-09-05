package com.example.newtodolistapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newtodolistapp.R
import com.example.newtodolistapp.databinding.FragmentHomeBinding
import com.example.newtodolistapp.ui.adapter.TodoAdapter
import com.example.newtodolistapp.viewmodel.TodoViewModel

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private lateinit var todoViewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]

        todoViewModel.getTodo().observe(viewLifecycleOwner) {
            binding.TodoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.TodoRecyclerView.adapter = TodoAdapter(requireContext(),it)
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_createNoteFragment)
        }

        return binding.root
    }
}
