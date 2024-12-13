package com.marouaneLasmak.implementation;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<String, Agent> agents = new HashMap<>();

    public void addAgent(Agent agent) {
        agents.put(agent.getName(), agent);
    }

    public void removeAgent(String agentName) {
        agents.remove(agentName);
    }

    public void showAgents() {
        agents.forEach((key, value) -> System.out.println(key + " : " + value));
    }

}
