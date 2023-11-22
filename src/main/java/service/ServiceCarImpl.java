package service;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class ServiceCarImpl implements ServiceCar {

    @Override
    public List<Car> fineSome() {
        return findCar();
    }

    public List<Car> findCar() {
        List<Car> cars = new ArrayList<>();
        String[] models = {"VAZ-2106", "VAZ-2107", "VAZ-2108", "VAZ-2109", "VAZ-2110"};
        String[] colors = {"white", "red", "blue", "metal", "orange"};
        for (int i = 0; i < models.length; i++) {
            cars.add(new Car(i, colors[i], models[i]));
        }
        return cars;
    }
}
