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
            case KELVIN -> new KelvinTemperature(value);
            default -> throw new UnsupportedOperationException(String.format("Converting from %s to %s is not supported", type, to));
        };
    }

    private FahrenheitTemperature convertToFahrenheit() {
        return new FahrenheitTemperature((value - 273.15) * 9 / 5 + 32);
    }

    private Temperature convertToCelsius() {
        return new CelsiusTemperature(value - 273.15);
    }
}
