package com.marouaneLasmak.implementation;

import com.marouaneLasmak.interfaces.HDMI;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private static Map<String, Agent> agents = new HashMap<>();
    private static Container instance;
    private HDMI display;

    private Container() {
    }

    public static synchronized Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public void setDisplay(HDMI display) {
        this.display = display;
    }

    public void addAgent(Agent agent) {
        agents.put(agent.getName(), agent);
    }

    public void removeAgent(String agentName) {
        agents.remove(agentName);
    }

    public void showAgents() {
        StringBuilder sb = new StringBuilder();
        agents.forEach((key, value) -> sb.append(key).append(" : ").append(value.toString()).append("\n"));
        if (display != null) {
            display.display(sb.toString());
        } else {
            System.out.println(sb);
        }
    }
}
