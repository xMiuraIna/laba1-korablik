package org.example;

import org.example.type.Type;

public class PierLoad implements Runnable {
    private Tunnel tunnel;
    private Type shipType;

    public PierLoad(Tunnel tunnel, Type shipType) {
        this.tunnel = tunnel;
        this.shipType =shipType;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.currentThread().setName("Loader "+shipType);

                //Time to load the goods
                Thread.sleep(500);
                Ship ship = tunnel.get(shipType);
                if(ship!=null)
                    while (ship.countCheck()){
                        Thread.sleep(100);
                        ship.add(10);
                        System.out.println(ship.getCount() + " Loaded ship. " + Thread.currentThread().getName());
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}