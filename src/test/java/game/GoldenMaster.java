package game;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class GoldenMaster {

    public static final Path FILE = Paths.get("goldenMaster.txt");

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream stream = new PrintStream(new FileOutputStream(FILE.toFile()));

        generateGameOutput(stream);
    }

    public static void generateGameOutput(PrintStream stream) {
        PrintStream oldOut = System.out;
        System.setOut(stream);

        Random random = new Random(42);

        LongStream.range(0, 10_000).forEach(i -> GameRunner.runGame(random));

        System.setOut(oldOut);
    }

    public static String toText(byte[] bytes) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));

        return reader.lines().collect(Collectors.joining("\n"));
    }
}
