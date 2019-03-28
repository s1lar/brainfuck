package com.brainfuck.interfaces;

public interface Command {

    void accept(Visitor visitor);

    void setRepetition(int repetition);

}
