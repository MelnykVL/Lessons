package edu.lessons.pattern.structural;

public class AdapterExample {
    public static void main(String[] args) {
        PrintInterface print = new PrinterExtend();
        print.consolePrint();
        PrintInterface print2 = new PrinterComposition(new Printer());
        print2.consolePrint();
    }
}

interface PrintInterface {
    void consolePrint();
}

// !=== Class adapter ===!
class PrinterExtend extends Printer implements PrintInterface {
    @Override
    public void consolePrint() {
        this.print();
    }
}

// !=== Object adapter ===!
class PrinterComposition implements PrintInterface {
    private final Printer printer;

    public PrinterComposition(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void consolePrint() {
        printer.print();
    }
}
// Cannot be change
class Printer {
    void print() {
        System.out.println("Hello");
    }
}
