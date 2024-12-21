package dev.irondesign.zpoolmonitor.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandServiceImplTest {

    private final CommandService commandService = new CommandServiceImpl();

    @Test
    void testExecuteCommand() {
        String result = commandService.executeCommand("zpool status -x");
        System.out.println(result);

        assert result.contains("all pools are healthy");

        String invalidCommand = "invalidCommand";

        String errorResult = commandService.executeCommand(invalidCommand);
        System.out.println(errorResult);

        assertTrue(errorResult.contains("Error executing command:"), "The output should contain an error message");

    }
}
