package web.model;

public class Car {
    private String model;
    private int series;
    private String color;
    public Car(String model, int series, String color) {
        this.model = model;
        this.series = series;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public String getColor() {
        return color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }

        Car car = (Car) o;

        if (series != car.series) {
            return false;
        }
        if (color != car.color) {
            return false;
        }
        return model.equals(car.model);
    }

    @Override
    public int hashCode() {
        int result = model.hashCode();
        result = 13 * result + series;
        result = 13 * result + color.hashCode();
        return result;
    }



}
