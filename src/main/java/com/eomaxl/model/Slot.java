package com.eomaxl.model;

public class Slot {
    private Integer slotNumber;
    private Car parkedCar;

    public Slot(final Integer slotNumber) { this.slotNumber = slotNumber;}

    public Integer getSlotNumber() { return slotNumber; }

    public boolean isSlotFree(){
        return parkedCar == null;
    }

    public void assignCar(Car car){ this.parkedCar = car; }

    public void unassignCar(){ this.parkedCar = null; }
}
