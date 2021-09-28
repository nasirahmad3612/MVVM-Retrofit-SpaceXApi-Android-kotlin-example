package com.example.testspacex.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testspacex.model.SpaceXModelItem

@Dao
interface SpaceXDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSapceXList(list:List<SpaceXModelItem>)
    @Query("select *  from spacexdatatable")
    fun getSapceXData(list:List<SpaceXModelItem>)
    @Query("select * from spacexdatatable where id=:id")
    fun getDataById(id:String):LiveData<SpaceXModelItem>
}