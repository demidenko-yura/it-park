package lesson11;

public class CheckPoint {

    private final int speedLimit;
    private final int policeWarningSpeedLimit;
    private final double weightLimit;
    private final double heightLimit;
    private final double widthLimit;

    public CheckPoint(int speedLimit, int policeWarningSpeedLimit, double weightLimit, double heightLimit, double widthLimit) {
        this.speedLimit = speedLimit;
        this.policeWarningSpeedLimit = policeWarningSpeedLimit;
        this.weightLimit = weightLimit;
        this.heightLimit = heightLimit;
        this.widthLimit = widthLimit;
    }

    public void check(Auto auto) {
        if (auto.getSpeed() > speedLimit) {
            if (auto.getSpeed() > policeWarningSpeedLimit) {
                throw new IllegalStateException("Опасное превышение скорости автомобиля " + auto.getRegNumber() + " (более " + policeWarningSpeedLimit + "км/ч). Вызвана полиция.");
            } else {
                throw new IllegalStateException("Превышение скорости автомобиля " + auto.getRegNumber() + " на " + (auto.getSpeed() - speedLimit) + "км/ч");
            }
        }
        if (auto.getDimension().getHeight() > heightLimit) {
            throw new IllegalStateException("Превышение допустимой высоты для автомобиля " + auto.getRegNumber() + " (" + auto.getDimension().getHeight() + " из " + heightLimit + ") ");
        }
        if (auto.getDimension().getWidth() > widthLimit) {
            throw new IllegalStateException("Превышение допустимой ширины для автомобиля " + auto.getRegNumber() + " (" + auto.getDimension().getWidth() + " из " + widthLimit + ") ");
        }
        if (auto instanceof Truck truck) {
            checkTruck(truck);
        }
    }

    private void checkTruck(Truck truck) {
        if (truck.getWeight() > weightLimit) {
            throw new IllegalStateException("Превышение допустимого веса у автомобиля " + truck.getRegNumber() + " (" + truck.getWeight() + " из " + weightLimit + ") ");
        }
    }
}
