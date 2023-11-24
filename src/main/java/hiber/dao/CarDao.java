package hiber.dao;

import hiber.model.Car;

import java.util.List;

public interface CarDao {
    void saveCar(Car car);
    List<Car> listCars();
}
