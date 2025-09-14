package LLD_CaseStudies.ParkingLot.Models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ParkingLot {
    private String id;
    private String name;
    private List<Floor> floors = new ArrayList<>();
    private List<Gate> entryGates = new ArrayList<>();
    private List<Gate> exitGates = new ArrayList<>();
    private ParkingManager manager;

    public ParkingLot(String id, String name, ParkingManager manager) {
        this.id = id;
        this.name = name;
        this.manager = manager;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
        // Register spots with ParkingManager
        for (ParkingSpot spot : floor.getParkingSpots()) {
            manager.addSpot(spot);
        }
    }

    public void addEntryGate(Gate gate) {
        entryGates.add(gate);
    }

    public void addExitGate(Gate gate) {
        exitGates.add(gate);
    }

    public List<Floor> getFloors() { return floors; }
    public List<Gate> getEntryGates() { return entryGates; }
    public List<Gate> getExitGates() { return exitGates; }
    public ParkingManager getManager() { return manager; }

}
