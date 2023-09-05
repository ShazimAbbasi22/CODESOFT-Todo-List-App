package com.example.newtodolistapp.ui.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.newtodolistapp.R
import com.example.newtodolistapp.databinding.FragmentCreateNoteBinding
import com.example.newtodolistapp.model.Todo
import com.example.newtodolistapp.viewmodel.TodoViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class CreateNoteFragment : Fragment() {

    private lateinit var binding: FragmentCreateNoteBinding
    private var priority: Int = 3
    private lateinit var todoViewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNoteBinding.inflate(inflater, container, false)

        todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]

        binding.HighPriority.setBackgroundResource(R.drawable.selected_highpriority_button_background)

        binding.saveActionButton.setOnClickListener {

            todoCreated()
        }


        binding.HighPriority.setOnClickListener {
            priority = 3
            binding.HighPriority.setBackgroundResource(R.drawable.selected_highpriority_button_background)
            binding.MediumPriority.setBackgroundResource(R.drawable.onselect_button_background)
            binding.LowPriority.setBackgroundResource(R.drawable.onselect_button_background)
        }

        binding.TaskDueDate.setOnClickListener {

            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog =
                DatePickerDialog(requireContext(), { view, year, monthOfYear, dayOfMonth ->
                    binding.TaskDueDate.setText("$dayOfMonth-${monthOfYear + 1}-$year")
                }, year, month, day)

            datePickerDialog.show()
        }

        binding.MediumPriority.setOnClickListener {
            priority = 2
            binding.MediumPriority.setBackgroundResource(R.drawable.selected_mediumpriority_button_background)
            binding.HighPriority.setBackgroundResource(R.drawable.onselect_button_background)
            binding.LowPriority.setBackgroundResource(R.drawable.onselect_button_background)
        }

        binding.LowPriority.setOnClickListener {
            priority = 1
            binding.LowPriority.setBackgroundResource(R.drawable.selected_lowpriority_button_background)
            binding.MediumPriority.setBackgroundResource(R.drawable.onselect_button_background)
            binding.HighPriority.setBackgroundResource(R.drawable.onselect_button_background)
        }


        return binding.root
    }

    private fun todoCreated() {
        val title = binding.TaskTitle.text.toString()
        val description = binding.TaskDescription.text.toString()
        val date = binding.TaskDueDate.text.toString()

        val data = Todo(0, title = title, description = description, date = date, priority)

        todoViewModel.insertTodo(data)
        Toast.makeText(requireContext(), "Task Added", Toast.LENGTH_SHORT).show()

        findNavController().navigate(R.id.action_createNoteFragment_to_homeFragment)
    }

}


