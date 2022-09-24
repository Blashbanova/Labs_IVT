package ru.ssau.tk.blashbanovaa.Labs_IVT;

import java.util.Arrays;

public class Car {
    //поле типа String, хранящее марку автомобиля
    private String brand;
    private int count;
    //класс Автомобиль хранит массив Моделей
    Model[] carArray = new Model[count];

    //Конструктор класса должен принимать в качестве параметров значение Марки автомобиля и размер массива Моделей
    public Car(String brand, int count) {
        this.brand = brand;
        this.count = count;
    }

    //внутренний класс Модель, имеющий поля название модели и её цену, а также конструктор
    private class Model {
        private String modelModel = null;
        private double modelPrice;

        public Model(String model, int price) {
            this.modelModel = model;
            this.modelPrice = price;
        }

        //метод для модификации значения названия модели
        public void setModelModel(String model) {
            this.modelModel = model;
        }

        public String getModelModel() {
            return modelModel;
        }

        public double getModelPrice() {
            return modelPrice;
        }

        public void setModelPrice(double price) {
            this.modelPrice = price;
        }
    }

    //метод для получения марки автомобиля
    public String getBrand() {
        return this.brand;
    }

    //метод для модификации марки автомобиля
    public void renameBrand(String brand) {
        this.brand = brand;
    }

    //метод, возвращающий массив названий всех моделей
    public String[] getArrayModel() {
        String[] nameModel = new String[carArray.length];
        for (int i = 0; i < carArray.length; i++) {
            nameModel[i] = carArray[i].getModelModel();
        }
        return nameModel;
    }

    //метод для получения значения цены модели по её названию
    public double getPrice(String model) {
        for (int i = 0; i < carArray.length; i++) {
            if (carArray[i].getModelModel() == model) {
                return carArray[i].getModelPrice();
            }
        }
        return 0;
    }

    //метод для модификации значения цены модели по её названию,
    public void renamePrice(String model, double newPrice) {
        for (int i = 0; i < carArray.length; i++) {
            if (carArray[i].getModelModel() == model) {
                carArray[i].setModelPrice(newPrice);
            }
        }
    }

    //метод, возвращающий массив значений цен моделей
    public double[] getArrayPrice() {
        double[] priceArray = new double[carArray.length];
        for (int i = 0; i < carArray.length; i++) {
            priceArray[i] = carArray[i].getModelPrice();
        }
        return priceArray;
    }

    //метод добавления названия модели и её цены (путем создания нового массива Моделей)
    public void addModelPrice(String model, double price) {
        Model[] newArray = Arrays.copyOf(carArray, (carArray.length + 1));
        newArray[(carArray.length + 1)].setModelPrice(price);
        newArray[(carArray.length + 1)].setModelModel(model);
    }

    //метод удаления модели с заданным именем и её цены
    public void deleteModel(String model, double price) {
        for (int i = 0; i < carArray.length; i++) {
            if ((carArray[i].getModelModel() == model) && (carArray[i].getModelPrice() == price)) {
                Model[] newArray = new Model[carArray.length];
                newArray = Arrays.copyOf(carArray, i);
                System.arraycopy(carArray, i + 1, newArray, i, carArray.length - i - 1);
            }
        }
    }

    //метод для получения размера массива Моделей
    public int getSize() {
        return carArray.length;
    }
}
