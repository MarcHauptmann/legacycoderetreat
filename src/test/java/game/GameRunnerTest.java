package game;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameRunnerTest {

    @Test
    public void testGoldenMaster() throws Exception {
        // given
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);

        GoldenMaster.generateGameOutput(stream);

        stream.close();

        // when
        String output = GoldenMaster.toText(out.toByteArray());

        // then
        String goldenMaster = GoldenMaster.toText(Files.readAllBytes(GoldenMaster.FILE));

        assertThat(output, is(equalTo(goldenMaster)));
    }
}