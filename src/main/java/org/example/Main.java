package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;
public class Main {
    static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("First task and second");
        Class<Car> carClass = Car.class;
        Field[] fields = carClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MyOwnAnnotations.class)) {
                LOGGER.info(field);
                //task 2
                LOGGER.info(field.getAnnotation(MyOwnAnnotations.class).value());
            }
        }

        LOGGER.info("Task 3");
        Car car = new Car();
        car.setYear(2002);
        try {
            Method method = carClass.getDeclaredMethod("methodForInvoke", int.class);
            method.setAccessible(true);
            try {
                LOGGER.info(method.invoke(car,200));
            } catch(Exception e){
                LOGGER.error(e);
            }
        } catch (NoSuchMethodException e) {
            LOGGER.error(e);
        }

        LOGGER.info("Task 4");
        for (Field field : fields) {
            if(!field.isAccessible()){
                field.setAccessible(true);
            }
        }
        try {
            fields[0].set(car,"Nissan");
            fields[1].set(car,"Murano");
            fields[2].set(car,2012);
            fields[3].set(car,(String) "fuel 95");
        } catch (IllegalAccessException e) {
            LOGGER.error(e);
        }

        LOGGER.info(car);
    }
}