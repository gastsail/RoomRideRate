package com.gaston.roomriderate

/**
 * Created by Gastón Saillén on 19 August 2019
 */

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.gaston.roomriderate.data.CarRide
import com.gaston.roomriderate.data.CarRideDao
import com.gaston.roomriderate.data.RideDatabase
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


/**
 * Tests para asegurar que funciona la lógica antes de implementar la UI
 */

@RunWith(AndroidJUnit4::class)
class CarRideTest {

    private lateinit var rideDao: CarRideDao
    private lateinit var db: RideDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, RideDatabase::class.java)
                // Allowing main thread queries, just for testing.
                .allowMainThreadQueries()
                .build()
        rideDao = db.rideDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetRide() {
        val ride = CarRide()
        rideDao.insert(ride)
        val lastRide = rideDao.getLastRide()
        assertEquals(lastRide?.rideRate, -1)
    }
}