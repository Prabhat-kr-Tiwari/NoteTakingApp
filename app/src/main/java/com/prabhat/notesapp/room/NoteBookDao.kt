package com.prabhat.notesapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.prabhat.notesapp.model.NoteBook
@Dao
interface NoteBookDao {



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(noteBook: NoteBook)
    @Delete
    suspend fun delete(noteBook: NoteBook)
    @Query("SELECT * FROM NoteBook")
    suspend fun getAllNoteBook():List<NoteBook>

}