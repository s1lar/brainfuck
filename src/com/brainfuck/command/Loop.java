package com.brainfuck.command;

import com.brainfuck.interfaces.Command;
import com.brainfuck.interfaces.Visitor;

import java.util.List;

public class Loop implements Command {

    private List<Command> innerCommands;
    private int repetition=1;

    public Loop(List<Command> innerCommands) {
        this.innerCommands = innerCommands;
    }

    public List<Command> getInnerCommands() {
        return innerCommands;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public int getRepetition() {
        return repetition;
    }
}
