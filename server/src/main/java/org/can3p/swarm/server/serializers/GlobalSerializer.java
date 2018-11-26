package org.can3p.swarm.server.serializers;

import org.can3p.swarm.server.DroneWorld;
import org.dyn4j.collision.Fixture;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Rectangle;
import org.dyn4j.geometry.Shape;
import org.dyn4j.geometry.Vector2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GlobalSerializer {

    public static String serialize(DroneWorld world) {
        long time = System.nanoTime();
        StringBuilder report = new StringBuilder();

        double elapsed = (time - world.getStartTime()) * 1e-9;
        report.append(String.format("Elapsed time: %f seconds\n", elapsed));

        for (Body body: world.getWorld().getBodies()) {
            report.append(GlobalSerializer.serialize(body));
        }

        return report.toString();
    }

    public static String serialize(Body body) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Body id %s: ", body.getId()));

        for (Fixture fixture: body.getFixtures()) {
            Shape shape = fixture.getShape();
            if( shape instanceof Rectangle) {
                Rectangle rect = (Rectangle) shape;
                String coords = Arrays.stream(rect.getVertices())
                        .map(vec -> String.format("[%.2f,%.2f]", vec.x, vec.y))
                        .collect(Collectors.joining(" -> "));

                builder.append(String.format("Rectangle at %s\n", coords));
                //do stuff
            } else {
                throw new RuntimeException(String.format("Don't know how to serialize %s shape", shape.getClass()));
            }
        }

        return builder.toString();
    }
}
