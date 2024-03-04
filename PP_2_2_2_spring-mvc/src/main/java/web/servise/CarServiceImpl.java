package web.servise;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Override
    public List<Car> listCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ваз", 000,"black"));
        cars.add(new Car("Submarine", 001,"yellow"));
        cars.add(new Car("тачка_деда",002,"niche_takoi"));
        cars.add(new Car("Гранта",003,"Белый"));
        cars.add(new Car("perdyashiy_jigul",004,"green"));
        return cars;
    }
     public static List<Car> getCarsByCount(List<Car> allCars, int count) {
        if (count > 0 && count < 5) {
            int min = Math.min(count, allCars.size());
            return allCars.subList(0, min);
        } else {
            return allCars;
        }
    }
}
