package edu.lessons.multithreading_ships.tasks;

import edu.lessons.multithreading_ships.Tunnel;
import edu.lessons.multithreading_ships.ships.Ship;
import edu.lessons.multithreading_ships.ships.types.Type;

public class PierLoader implements Runnable {

    private Tunnel tunnel;
    private Type shipType;

    public PierLoader(Tunnel tunnel, Type shipType) {
        this.tunnel = tunnel;
        this.shipType = shipType;
    }

    @Override
    public void run() {

        while (true) {
            try {

                Thread.currentThread().setName("Loader " + shipType);
                Ship ship = tunnel.get(shipType);
                if (ship != null)
                    while (ship.countCheck()) {
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
