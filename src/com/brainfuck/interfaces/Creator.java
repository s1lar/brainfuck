package com.brainfuck.interfaces;

import java.util.List;

public interface Creator<T> {

    List<T> create(String program);
}
