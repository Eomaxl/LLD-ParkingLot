package com.eomaxl.mode;

import com.eomaxl.OutputPrinter;
import com.eomaxl.commands.CommandExecutorFactory;
import com.eomaxl.model.Command;

import java.io.*;

/**
 * Mode running in which input commands are given from a file.
 * */
public class FileMode extends Mode{
    private String fileName;

    public FileMode(final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter, final String fileName){
        super(commandExecutorFactory, outputPrinter);
        this.fileName = fileName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void process() throws IOException {
        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            outputPrinter.invalidFile();
            return;
        }

        String input = reader.readLine();
        while (input != null) {
            final Command command = new Command(input);
            processCommand(command);
            input = reader.readLine();
        }
    }

}
