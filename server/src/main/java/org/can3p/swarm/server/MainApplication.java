package org.can3p.swarm.server;

public class MainApplication {

    public static void main(String[] args) throws InterruptedException {
        DroneWorld world = new DroneWorld();
        world.init();
        world.start();

        Thread.sleep(500);

        System.out.println(world.getState());
    }
}
