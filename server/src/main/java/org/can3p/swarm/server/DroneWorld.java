package org.can3p.swarm.server;

import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;

import java.util.ArrayList;
import java.util.List;

public class DroneWorld {
    private World world;
    private long startTime;
    private long lastTime;

    public DroneWorld() {
        this.world = new World();
    }

    public void init() {
        this.world.setGravity(World.ZERO_GRAVITY);

        // the bounds so we can keep playing
        Body l = new Body();
        l.addFixture(Geometry.createRectangle(1, 15));
        l.translate(-5, 0);
        l.setMass(MassType.INFINITE);
        this.world.addBody(l);

        Body r = new Body();
        r.addFixture(Geometry.createRectangle(1, 15));
        r.translate(5, 0);
        r.setMass(MassType.INFINITE);
        this.world.addBody(r);

        Body t = new Body();
        t.addFixture(Geometry.createRectangle(15, 1));
        t.translate(0, 5);
        t.setMass(MassType.INFINITE);
        this.world.addBody(t);

        Body b = new Body();
        b.addFixture(Geometry.createRectangle(15, 1));
        b.translate(0, -5);
        b.setMass(MassType.INFINITE);
        this.world.addBody(b);
    }

    public void start() {
        this.lastTime = System.nanoTime();
        this.startTime = System.nanoTime();

        Thread thread = new Thread() {
            public void run() {
                long time =  System.nanoTime();
                double secondsDelta = (time - lastTime) * 1e9;
                updateWorld(secondsDelta);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {}
            }
        };

        thread.setDaemon(true);
        thread.start();
    }

    public void updateWorld(double timeDelta) {
        this.world.update(timeDelta);
    }

    public List<String> getState() {
        long time = System.nanoTime();
        ArrayList<String> report = new ArrayList<String>();

        double elapsed = (time - this.startTime) * 1e-9;
        report.add(String.format("Elapsed time: %f seconds", elapsed));

        return report;
    }
}
