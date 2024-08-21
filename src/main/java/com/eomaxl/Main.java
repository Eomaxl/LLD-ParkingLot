package com.eomaxl;

import com.eomaxl.commands.CommandExecutorFactory;
import com.eomaxl.exception.InvalidModeException;
import com.eomaxl.mode.FileMode;
import com.eomaxl.mode.InteractiveMode;
import com.eomaxl.service.ParkingLotService;

import java.io.IOException;

public class Main {
    public static void main(final String[] args) throws IOException {
        final OutputPrinter outputPrinter = new OutputPrinter();
        final ParkingLotService parkingLotService = new ParkingLotService();
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);

        if ( isInteractiveMode(args)){
            new InteractiveMode(commandExecutorFactory, outputPrinter).process();
        } else if (isFileInputMode(args)){
            new FileMode(commandExecutorFactory,outputPrinter,args[0]).process();
        } else {
            throw new InvalidModeException();
        }
    }
    /**
     *  Checks whether the program is running using file input mode
     *
     * @param args Command line arguments.
     * @return Boolean indicating whether it is a file mode or not.
     * */
    private static boolean isFileInputMode(final String[] args){return args.length == 1;}

    /**
     * Checks whether the program is running using interactive mode
     *
     * @param args Command line arguments.
     * @return Boolean indicating whether it is a interactive mode or not.
     * */
    private static boolean isInteractiveMode(final String[] args){return args.length == 0;}
}

