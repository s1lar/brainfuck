package com.brainfuck.memory;

public class Memory {
    private char[] data;
    private int index;

    public Memory(int memorySize) {
        data = new char[memorySize];
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public char[] getData() {
        return data;
    }

}
