package lesson10;

public class KelvinTemperature extends Temperature {

    public KelvinTemperature(double value) {
        super(TemperatureType.KELVIN, value);
    }

    @Override
    public Temperature convertTo(TemperatureType to) {
        return switch (to) {
            case CELSIUS -> convertToCelsius();
            case FAHRENHEIT -> convertToFahrenheit();
            default -> new KelvinTemperature(value);
        };
    }

    private FahrenheitTemperature convertToFahrenheit() {
        return new FahrenheitTemperature((value - 273.15) * 9 / 5 + 32);
    }

    private Temperature convertToCelsius() {
        return new CelsiusTemperature(value - 273.15);
    }
}
