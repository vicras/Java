package com.company.model;

import com.company.model.countable.Countable;
import com.company.model.countable.factory.CountableFactory;
import com.company.model.polynomial.Polynomial;
import com.company.model.polynomial.factory.PolynomGenerator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TaskPerformer implements Taskable {

    List<TaskObserver> observers;

    public TaskPerformer() {
        observers = new ArrayList<>();
    }

    void notifyObservers(){
        for(var i : observers){
            i.update();
        }
    }

    @Override
    public Polynomial[] createPolynomArray(int length, int maxRank,  String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        PolynomGenerator generator= (PolynomGenerator)Class.forName(type).getDeclaredConstructor().newInstance();
        return generator.getPolynoms(length, maxRank);
    }

    @Override
    public Polynomial sumOfArray(Polynomial[] array) {
        if(array.length <2) throw new RuntimeException("array size so small");

        Polynomial sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = sum.add(array[i]);
        }
        return sum;
    }

    @Override
    public Polynomial performSubtract(Polynomial[] polynomials) {
        if(polynomials.length !=2) throw new RuntimeException("incorrect array length. excepted array.length == 2");
        Polynomial ans = polynomials[0].subtract(polynomials[1]);
        return ans;
    }

    @Override
    public Countable createCountable(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        CountableFactory factory= (CountableFactory) Class.forName(type).getDeclaredConstructor().newInstance();
        return factory.getCountable();
    }

    @Override
    public Polynomial performMultiplication(Polynomial polynomial, Countable number) {
        return polynomial.multiply(number);
    }

    @Override
    public void addListeners(TaskObserver observer) {
        observers.add(observer);
    }


}
