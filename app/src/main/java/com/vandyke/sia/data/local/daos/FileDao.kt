/*
 * Copyright (c) 2017 Nicholas van Dyke. All rights reserved.
 */

package com.vandyke.sia.data.local.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.vandyke.sia.data.models.renter.RenterFileData
import io.reactivex.Flowable
import io.reactivex.Single
import org.intellij.lang.annotations.Language

@Dao
interface FileDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(file: RenterFileData)

    @Language("RoomSql")
    @Query("SELECT * FROM files WHERE path LIKE :path || '/%' AND path NOT LIKE :path || '/%/%' ORDER BY name")
    fun filesInDir(path: String): Flowable<List<RenterFileData>>

    @Language("RoomSql")
    @Query("SELECT * FROM files WHERE path LIKE :path || '/%'")
    fun getFilesUnder(path: String): Single<List<RenterFileData>>

    @Query("SELECT * FROM files WHERE path LIKE :path || '/%' AND name LIKE '%' || :name || '%' ORDER BY name")
    fun filesWithNameUnderDir(name: String, path: String): Flowable<List<RenterFileData>>

    @Language("RoomSql")
    @Query("DELETE FROM files")
    fun deleteAll()

    @Language("RoomSql")
    @Query("DELETE FROM files WHERE path == :path")
    fun deleteFile(path: String)

    @Language("RoomSql")
    @Query("DELETE FROM files WHERE path LIKE :path || '/%'")
    fun deleteFilesUnder(path: String)
}