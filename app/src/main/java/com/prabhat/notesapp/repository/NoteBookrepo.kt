package com.prabhat.notesapp.repository

import android.content.Context
import com.prabhat.notesapp.model.NoteBook
import com.prabhat.notesapp.room.NoteBookDatabase

class NoteBookrepo {

    suspend fun insert(context: Context,noteBook: NoteBook){
        NoteBookDatabase.get(context).getNotebookDao().insert(noteBook)
    }
    suspend fun delete(context: Context,noteBook: NoteBook){
        NoteBookDatabase.get(context).getNotebookDao().delete(noteBook)
    }
    suspend fun getAllNoteBook(context: Context):List<NoteBook>{
        return NoteBookDatabase.get(context).getNotebookDao().getAllNoteBook()
    }
}