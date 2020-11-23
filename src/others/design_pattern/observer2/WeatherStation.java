package others.design_pattern.observer2;

import others.design_pattern.observer2.CurrentConditionsDisplay;
import others.design_pattern.observer2.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        CurrentConditionsDisplay currentConditionsDisplay1 = new CurrentConditionsDisplay(weatherData);
//        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.deleteObserver(currentConditionsDisplay);
        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
