package com.gaston.roomriderate.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Gastón Saillén on 19 August 2019
 */
@Entity(tableName = "calificaciones_por_paseo_tabla")
data class CarRide(

    @PrimaryKey(autoGenerate = true)
    var rideId: Long = 0L,

    @ColumnInfo(name = "tiempo_de_partida")
    val startTime: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "tiempo_de_llegada" )
    val endTime: Long = startTime,

    @ColumnInfo(name = "calificacion_paseo")
    var rideRate: Int = -1
)