package com.brainfuck.interfaces;

import com.brainfuck.command.*;

public interface Visitor {
    void visit(Decrement decrement);

    void visit(Increment increment);

    void visit(Loop loop);

    void visit(Print print);

    void visit(PreviousCell previousCell);

    void visit(NextCell nextCell);
}
