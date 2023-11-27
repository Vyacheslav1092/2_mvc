package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {

    private static final List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("Vazik-5", "белый", 2010, 650_000.00));
        carList.add(new Car("Vazik-8", "красный", 2011, 750_000.00));
        carList.add(new Car("Vazik-10", "зеленый", 2013, 950_000.00));
        carList.add(new Car("Vazik-12", "синий", 2015, 1_150_000.00));
        carList.add(new Car("Vazik-15", "золотой", 2017, 1_350_000.00));
    }
    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return carList;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
