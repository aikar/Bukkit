package org.bukkit.event.vehicle;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityEvent; // EMC

/**
 * Represents a vehicle-related event.
 */
public abstract class VehicleEvent extends EntityEvent { // EMC
    protected Entity vehicle; // EMC

    public VehicleEvent(final Entity vehicle) { // EMC
        super(vehicle); // EMC
        this.vehicle = vehicle;
    }

    /**
     * Get the vehicle.
     *
     * @return the vehicle
     */
    public final Entity getVehicle() { // EMC
        return vehicle;
    }
}
