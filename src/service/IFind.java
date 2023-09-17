package service;

import entity.Property;
import service.impl.PropertyService;

import java.util.List;

public interface IFind {
    List<Property> propertyList= PropertyService.getPropertyList();

    public void find();
}
