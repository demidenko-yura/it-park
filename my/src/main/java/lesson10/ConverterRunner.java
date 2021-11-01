package lesson10;

public class ConverterRunner {

    public static void main(String[] args) {
        Temperature celsiusTemperature = new CelsiusTemperature(36.6);
        Temperature kelvinTemperature = celsiusTemperature.convertTo(TemperatureType.KELVIN);
        Temperature fahrenheitTemperature = celsiusTemperature.convertTo(TemperatureType.FAHRENHEIT);

        System.out.println(celsiusTemperature);
        System.out.println(kelvinTemperature);
        System.out.println(fahrenheitTemperature);

        System.out.println(celsiusTemperature.equals(fahrenheitTemperature.convertTo(TemperatureType.CELSIUS)));
        System.out.println(celsiusTemperature.equals(kelvinTemperature.convertTo(TemperatureType.CELSIUS)));
    }

}
