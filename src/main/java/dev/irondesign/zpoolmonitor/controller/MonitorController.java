package dev.irondesign.zpoolmonitor.controller;


import dev.irondesign.zpoolmonitor.service.CommandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MonitorController {

    private final CommandService commandService;

    public MonitorController(CommandService commandService) {
        this.commandService = commandService;
    }
    @GetMapping("/zpool-list")
    public String getZpoolList() {
        return commandService.executeCommand("zpool list -o name");
    }
    @GetMapping("/zpool-status")
    public String getZpoolStatus() {
        return commandService.executeCommand("zpool status");
    }


}
