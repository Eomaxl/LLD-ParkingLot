package com.eomaxl.mode;

import com.eomaxl.OutputPrinter;
import com.eomaxl.commands.CommandExecutor;
import com.eomaxl.commands.CommandExecutorFactory;
import com.eomaxl.exception.InvalidCommandException;
import com.eomaxl.model.Command;

import java.io.IOException;

public abstract class Mode {

    private CommandExecutorFactory commandExecutorFactory;
    protected OutputPrinter outputPrinter;

    public Mode(final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter) {
        this.commandExecutorFactory = commandExecutorFactory;
        this.outputPrinter = outputPrinter;
    }

    protected void processCommand(final Command command){
        final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        if (commandExecutor.validate(command)){
            commandExecutor.execute(command);
        } else {
            throw new InvalidCommandException();
        }
    }

    /**
     * Abstract method to process the mode. Each mode will process in its own way.
     *
     * */
    public abstract void process() throws IOException;
}
