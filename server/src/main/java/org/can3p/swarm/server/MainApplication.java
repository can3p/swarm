package org.can3p.swarm.server;

public class MainApplication {

    public static void main(String[] args) {
        DroneWorld world = new DroneWorld();
        world.init();

        System.out.println("works");
    }
}
