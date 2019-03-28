package com.brainfuck.command;

import com.brainfuck.interfaces.Command;
import com.brainfuck.interfaces.Visitor;

import java.util.List;

public class CommandExecutor {

    private List<Command> commands;

    public CommandExecutor(List<Command> commands) {
        this.commands = commands;
    }

    public void acceptExecutor(Visitor visitor) {
        int repetition = 1;
        for (int i = 0; i < commands.size(); i++) {
            Command currentCommand = commands.get(i);
            if (i < commands.size() - 1 && currentCommand.getClass() == commands.get(i + 1).getClass()) {
                ++repetition;
            } else {
                currentCommand.setRepetition(repetition);
                currentCommand.accept(visitor);
                repetition = 1;
            }
            currentCommand.setRepetition(1);
        }
    }
}
