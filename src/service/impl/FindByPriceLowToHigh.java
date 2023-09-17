package service.impl;

import entity.Property;
import service.IFind;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindByPriceLowToHigh implements IFind {
    @Override
    public void find() {
        List<Property> sortedProperty = propertyList.stream()
                .sorted(Comparator.comparing(Property::getPropertyPrice))
                .collect(Collectors.toList());
        for (Property Property : sortedProperty) {
            System.out.println(Property);
        }

    }
}
