package lesson10;

public class CelsiusTemperature extends Temperature {

    public CelsiusTemperature(double value) {
        super(TemperatureType.CELSIUS, value);
    }

    @Override
    public Temperature convertTo(TemperatureType to) {
        return switch (to) {
            case KELVIN -> convertToKelvin();
            case FAHRENHEIT -> convertToFahrenheit();
            case CELSIUS -> new CelsiusTemperature(value);
            default -> throw new UnsupportedOperationException(String.format("Converting from %s to %s is not supported", type, to));
        };
    }

    private FahrenheitTemperature convertToFahrenheit() {
        return new FahrenheitTemperature((value * 9 / 5) + 32);
    }

    private KelvinTemperature convertToKelvin() {
        return new KelvinTemperature(value + 273.15);
    }
}
