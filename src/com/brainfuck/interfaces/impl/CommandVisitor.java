package com.brainfuck.interfaces.impl;

import com.brainfuck.command.*;
import com.brainfuck.interfaces.Command;
import com.brainfuck.interfaces.Visitor;
import com.brainfuck.memory.Memory;

public class CommandVisitor implements Visitor {

    private Memory memory;

    public CommandVisitor(Memory memory) {
        this.memory = memory;
    }

    @Override
    public void visit(Decrement decrement) {
        char[] data = memory.getData();
        int index = memory.getIndex();
        data[index] = (char) ((char) (data[index] - decrement.getRepetition()) % 256);
    }


    @Override
    public void visit(Increment increment) {
        char[] data = memory.getData();
        int index = memory.getIndex();
        data[index] = (char) ((char) (data[index] + increment.getRepetition()) % 256);
    }

    @Override
    public void visit(Print print) {
        int repetition = print.getRepetition();
        while (repetition != 0) {
            System.out.print(memory.getData()[memory.getIndex()]);
            --repetition;
        }
    }

    @Override
    public void visit(PreviousCell previousCell) {
        memory.setIndex(memory.getIndex() - previousCell.getRepetition());
    }

    @Override
    public void visit(NextCell nextCell) {
        memory.setIndex(memory.getIndex() + nextCell.getRepetition());
    }

    @Override
    public void visit(Loop loop) {
        while (memory.getData()[memory.getIndex()] != 0) {
            for (Command command : loop.getInnerCommands()) {
                command.accept(this);
            }
        }
    }
}
