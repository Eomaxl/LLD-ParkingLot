package com.eomaxl.commands;

import com.eomaxl.OutputPrinter;
import com.eomaxl.exception.NoFreeSlotAvailableException;
import com.eomaxl.model.Car;
import com.eomaxl.model.Command;
import com.eomaxl.service.ParkingLotService;

/**
 * Executor to handle command of parking a car into the parking lot. This outputs the alloted slot
 * in which the car is parked.
 */
public class ParkCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "park";

    public ParkCommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter){
        super(parkingLotService,outputPrinter);
    }

    @Override
    protected String getName() {
        return COMMAND_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(final Command command){
        return command.getParams().size() == 2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final Command command){
        final Car car = new Car(command.getParams().get(0), command.getParams().get(1));
        try {
            final Integer slot = parkingLotService.park(car);
            outputPrinter.printWithNewLine("Allocated slot number: "+slot);
        } catch (NoFreeSlotAvailableException exception){
            outputPrinter.parkingLotFull();
        }
    }
}
