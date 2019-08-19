package com.gaston.roomriderate.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Created by Gastón Saillén on 19 August 2019
 */

@Dao
interface CarRideDao {

    @Insert
    fun insert(ride: CarRide)

    @Update
    fun update(ride: CarRide)

    @Query("SELECT * from calificaciones_por_paseo_tabla WHERE rideId = :key")
    fun get(key:Long): CarRide?

    @Query("DELETE FROM calificaciones_por_paseo_tabla")
    fun clear()

    @Query("SELECT * FROM calificaciones_por_paseo_tabla ORDER BY rideId DESC LIMIT 1")
    fun getLastRide(): CarRide?

    @Query("SELECT * FROM calificaciones_por_paseo_tabla ORDER BY rideId DESC")
    fun getAllRides(): LiveData<List<CarRide?>>
}