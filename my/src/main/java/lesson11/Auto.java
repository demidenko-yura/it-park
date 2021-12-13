package lesson11;

public abstract class Auto {
    protected String regNumber;
    protected int speed = 0;
    protected double weight;
    protected final Dimension dimension;

    public Auto(String regNumber, double weight, double height, double width, double length) {
        this.regNumber = regNumber;
        this.weight = weight;
        this.dimension = new Dimension(height, width, length);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public double getWeight() {
        return weight;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public static class Dimension {
        private final double height;
        private final double width;
        private final double length;

        public Dimension(double height, double width, double length) {
            this.height = height;
            this.width = width;
            this.length = length;
        }

        public double getHeight() {
            return height;
        }

        public double getWidth() {
            return width;
        }

        public double getLength() {
            return length;
        }
    }
}
