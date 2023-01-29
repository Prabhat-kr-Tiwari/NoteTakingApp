package com.prabhat.notesapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.prabhat.notesapp.R
import com.prabhat.notesapp.adapters.MyAdapter
import com.prabhat.notesapp.viewModel.NoteBookViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    lateinit var navController: NavController
    var adapter=MyAdapter()
    lateinit var viewModel: NoteBookViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel=ViewModelProvider(this)[NoteBookViewModel::class.java]
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController=Navigation.findNavController(view)
        view.add_notebook.setOnClickListener{
            navController.navigate(R.id.action_mainFragment_to_addFragment)
        }
        context?.let { viewModel.getAllNoteBook(it) }


        viewModel.list.observe(viewLifecycleOwner,{
            adapter.setContentList(it)
            recycler.also { recycler.adapter=adapter }

        })
        val recycler=view.findViewById<RecyclerView>(R.id.recycler)


    }


}