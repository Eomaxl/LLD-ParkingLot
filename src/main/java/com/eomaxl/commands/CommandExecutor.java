package com.eomaxl.commands;

import com.eomaxl.OutputPrinter;
import com.eomaxl.model.Command;
import com.eomaxl.service.ParkingLotService;

/**
 * Command executor interface
 * */
public abstract class CommandExecutor {
    protected ParkingLotService parkingLotService;
    protected OutputPrinter outputPrinter;

    public CommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        this.parkingLotService = parkingLotService;
        this.outputPrinter = outputPrinter;
    }
    public boolean commandValidate(Command command){
        if(!command.getCommandName().equals(getName())){
            return false;
        }
        return validate(command);
    }

    protected abstract String getName();

    /**
     * Validate that whether a command is valid to be executed or not.
     *
     * @param command Command to be validated.
     * @return Boolean indicating whether the command is valid or not.
     * */
    public abstract boolean validate(Command command);

    /**
     * Execute the command.
     * @param command Command to be executed.
     * */
    public abstract void execute(Command command);
}
