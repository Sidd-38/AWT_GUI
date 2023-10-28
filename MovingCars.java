import java.applet.Applet;
import java.awt.*;

public class MovingCars extends Applet implements Runnable {
    private Thread animationThread;
    private int carCount = 5;
    private Car[] cars;

    public void init() {
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            int x = 0;
            int y = 50 + i * 50; // Position the cars vertically
            cars[i] = new Car(x, y);
        }
    }

    public void start() {
        if (animationThread == null) {
            animationThread = new Thread(this);
            animationThread.start();
        }
    }

    public void stop() {
        if (animationThread != null) {
            animationThread.interrupt();
            animationThread = null;
        }
    }

    public void run() {
        while (true) {
            for (int i = 0; i < carCount; i++) {
                cars[i].move();
            }
            repaint();

            try {
                Thread.sleep(100); // Adjust the speed of the animation
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void paint(Graphics g) {
        for (int i = 0; i < carCount; i++) {
            cars[i].draw(g);
        }
    }

    class Car {
        int x, y;
        int speed;

        public Car(int x, int y) {
            this.x = x;
            this.y = y;
            this.speed = (int) (Math.random() * 5 + 1); // Random speed for each car
        }

        public void move() {
            x += speed;
            if (x > getWidth()) {
                x = -60; // Reset car's position if it moves off the applet window
            }
        }

        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(x, y, 60, 30); // Car body
            g.setColor(Color.BLACK);
            g.fillOval(x + 10, y + 30, 20, 20); // Left wheel
            g.fillOval(x + 30, y + 30, 20, 20); // Right wheel
        }
    }
}

/*
 <applet code="MovingCars" width =300 height=100>
 </applet>*/