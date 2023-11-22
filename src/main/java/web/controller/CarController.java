package web.controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    List<Car> carList;

    @GetMapping(value = "/cars")
    public String printCar(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> subCarList = carList;
        if (count < carList.size()) {
            subCarList = carList.subList(0, count);
        }
        model.addAttribute("carList", subCarList);
        return "cars";
    }
}
