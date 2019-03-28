package com.brainfuck.creator;

import com.brainfuck.command.*;
import com.brainfuck.interfaces.Command;
import com.brainfuck.interfaces.Creator;

import java.util.*;

public class CommandCreator implements Creator<Command> {

    private Map<Character, Command> map;

    public CommandCreator() {
        initMap();
    }

    public List<Command> create(String program) {

        Deque<List<Command>> stack = new ArrayDeque<>();
        stack.push(new ArrayList<>());


        for (char character : program.toCharArray()) {

            Command command = map.get(character);

            if (command == null) {
                processLoopAndIllegalCommands(stack, character);
            }

            if (command != null) {
                stack.peek().add(command);
            }

        }

        return stack.pop();
    }

    private void processLoopAndIllegalCommands(Deque<List<Command>> stack, char character) {

        if (character == '[') {
            stack.push(new ArrayList<>());
            return;
        }

        if (character == ']') {
            Loop loop = new Loop(stack.pop());
            stack.peek().add(loop);
            return;
        }

        throw new IllegalArgumentException("Wrong input parameter " + character);
    }

    private void initMap() {
        map = new HashMap<>();
        map.put('+', new Increment());
        map.put('-', new Decrement());
        map.put('.', new Print());
        map.put('>', new NextCell());
        map.put('<', new PreviousCell());
    }
}
