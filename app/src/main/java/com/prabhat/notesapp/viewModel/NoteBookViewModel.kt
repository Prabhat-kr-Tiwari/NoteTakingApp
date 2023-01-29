package com.prabhat.notesapp.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prabhat.notesapp.model.NoteBook
import com.prabhat.notesapp.repository.NoteBookrepo
import kotlinx.coroutines.launch

class NoteBookViewModel:ViewModel() {
    val repo=NoteBookrepo()
    val list=MutableLiveData<List<NoteBook>>()


    fun insert(context: Context,noteBook: NoteBook){
        viewModelScope.launch{
            repo.insert(context, noteBook  )

        }
    }
    fun delete(context: Context,noteBook: NoteBook){
        viewModelScope.launch{
            repo.delete(context, noteBook  )

        }
    }
    fun getAllNoteBook(context: Context){
        viewModelScope.launch{
            list.value=repo.getAllNoteBook(context  )

        }
    }
}