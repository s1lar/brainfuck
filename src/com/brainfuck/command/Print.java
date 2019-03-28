package com.brainfuck.command;

import com.brainfuck.interfaces.Command;
import com.brainfuck.interfaces.Visitor;

public class Print implements Command {

    private int repetition=1;

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
