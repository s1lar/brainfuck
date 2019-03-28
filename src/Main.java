import com.brainfuck.command.CommandExecutor;
import com.brainfuck.creator.CommandCreator;
import com.brainfuck.interfaces.Command;
import com.brainfuck.interfaces.Creator;
import com.brainfuck.interfaces.Visitor;
import com.brainfuck.interfaces.impl.CommandVisitor;
import com.brainfuck.memory.Memory;

import java.util.List;

public class Main {
    private static final int DEFAULT_MEMORY_SIZE = 65536;

    public static void main(String[] args) {
        String program  = "+++++++++++>+>>>>++++++++++++++++++++++++++++++++++++++++++++>" +
                "++++++++++++++++++++++++++++++++<<<<<<[>" +
                "[>>>>>>+>+<<<<<<<-]>>>>>>>[<<<<<<<+>>>>>>>-]<[>++++++++++[-" +
                "<-[>>+>+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]>[<<[>>>+<<<" +
                "-]>>[-]]<<]>>>[>>+>+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]" +
                ">[<<+>>[-]]<<<<<<<]>>>>>[+++++++++++++++++++++++++" +
                "+++++++++++++++++++++++.[-]]++++++++++<[->-<]>++++" +
                "++++++++++++++++++++++++++++++++++++++++++++.[-]<<" +
                "<<<<<<<<<<[>>>+>+<<<<-]>>>>[<<<<+>>>>-]<-[>>.>.<<<" +
                "[-]]<<[>>+>+<<<-]>>>[<<<+>>>-]<<[<+>-]>[<+>-]<<<-]";

        Creator<Command> commandCreator = new CommandCreator();
        List<Command> commandList = commandCreator.create(program);
        Memory memory = new Memory(DEFAULT_MEMORY_SIZE);
        Visitor visitor = new CommandVisitor(memory);
        CommandExecutor elements = new CommandExecutor(commandList);
        elements.acceptExecutor(visitor);
    }
}
