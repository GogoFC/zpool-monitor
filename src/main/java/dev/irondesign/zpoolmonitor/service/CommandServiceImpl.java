package dev.irondesign.zpoolmonitor.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandServiceImpl implements CommandService {
    @Override
    public String executeCommand(String command) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }

        } catch (Exception e) {
            output.append("Error executing command: ").append(e.getMessage());
        }
        return output.toString();
    }
}
