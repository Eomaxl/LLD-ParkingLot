package com.eomaxl.commands;

import com.eomaxl.OutputPrinter;
import com.eomaxl.model.Command;
import com.eomaxl.service.ParkingLotService;
import com.eomaxl.validator.IntegerValidator;

import java.util.List;

/**
 * Executor to handle command of freeing of slot from a car.
 */
public class LeaveCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "leave";

    public LeaveCommandExecutor(final ParkingLotService parkingLotService,
                                final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    protected String getName() {
        return COMMAND_NAME;
    }

    /**
     * {@inheritDoc}
     */
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
     */
    @Override
    public void execute(final Command command) {
        final int slotNum = Integer.parseInt(command.getParams().get(0));
        parkingLotService.makeSlotFree(slotNum);
        outputPrinter.printWithNewLine("Slot number " + slotNum + " is free");
    }
}