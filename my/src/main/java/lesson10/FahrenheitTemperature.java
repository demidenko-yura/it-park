package lesson10;

public class FahrenheitTemperature extends Temperature {

    public FahrenheitTemperature(double value) {
        super(TemperatureType.FAHRENHEIT, value);
    }

    @Override
    public Temperature convertTo(TemperatureType to) {
        return switch (to) {
            case CELSIUS -> convertToCelsius();
            case KELVIN -> convertToKelvin();
            default -> new FahrenheitTemperature(value);
        };
    }

    private CelsiusTemperature convertToCelsius() {
        return new CelsiusTemperature((value - 32) * 5 / 9);
    }

    private KelvinTemperature convertToKelvin() {
        return new KelvinTemperature((value - 32) * 5 / 9 + 273.15);
    }
}
