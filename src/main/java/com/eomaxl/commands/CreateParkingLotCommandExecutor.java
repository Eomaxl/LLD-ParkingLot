package com.eomaxl.commands;

import com.eomaxl.OutputPrinter;
import com.eomaxl.model.Command;
import com.eomaxl.model.ParkingLot;
import com.eomaxl.model.parking.strategy.NaturalOrderingParkingStrategy;
import com.eomaxl.service.ParkingLotService;
import com.eomaxl.validator.IntegerValidator;
import com.sun.management.DiagnosticCommandMBean;

import java.util.List;

public class CreateParkingLotCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    protected String getName(){
        return COMMAND_NAME;
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public boolean validate(final Command command) {
        final List<String> params = command.getParams();
        if (params.size() != 1) {
            return false;
        }
        return IntegerValidator.isInteger(params.get(0));
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public void execute(final Command command) {
        final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot, new NaturalOrderingParkingStrategy());
        outputPrinter.printWithNewLine("Created a parking lot with "+parkingLot.getCapacity()+" slots");
    }
}
