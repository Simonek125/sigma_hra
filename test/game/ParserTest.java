package game;

import Commands.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser();
    }

    @Test
    void testParseValidCommand() {
        Command cmd = parser.parse("jdi sever");
        assertNotNull(cmd);
        assertEquals("jdi", cmd.getName());
    }

    @Test
    void testParseInvalidCommand() {
        Command cmd = parser.parse("nesmysl sever");
        assertNull(cmd);
    }

    @Test
    void testParseArgs() {
        String[] args = parser.parseArgs("vezmi klíč z truhly");
        assertEquals(3, args.length);
        assertEquals("klíč", args[0]);
        assertEquals("z", args[1]);
        assertEquals("truhly", args[2]);
    }

    @Test
    void testEmptyInput() {
        assertNull(parser.parse("   "));
        assertEquals(0, parser.parseArgs("   ").length);
    }
}
