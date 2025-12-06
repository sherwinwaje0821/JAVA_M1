package ph.com.bpi.hello.M2_Act4;

public class MyApplication {


public static void main(String[] args) {
        Executable2 excel = new MSExcel();
        Executable word = new MSWord();

        runProgram2(excel);
        runProgram(word);

        stopProgram2(excel);
        stopProgram(word);
    }

    private static void runProgram(Executable executableProgram) {
        executableProgram.run();
    }

    private static void stopProgram(Executable executableProgram) {
        executableProgram.stop();
    }

    private static void runProgram2(Executable2 executableProgram) {
        executableProgram.run();
    }

    private static void stopProgram2(Executable2 executableProgram) {
        executableProgram.stop();
    }

}
