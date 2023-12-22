package org.example;

import org.example.type.Type;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());

        Tunnel tunnel = new Tunnel();

        ShipGenerator shipGenerator = new ShipGenerator(tunnel, 10);

        PierLoad pierLoader1 = new PierLoad(tunnel, Type.DRESS);
        PierLoad pierLoader2 = new PierLoad(tunnel, Type.BANANA);
        PierLoad pierLoader3 = new PierLoad(tunnel, Type.BREAD);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(shipGenerator);
        service.execute(pierLoader1);
        service.execute(pierLoader2);
        service.execute(pierLoader3);

        service.shutdown();
    }
}