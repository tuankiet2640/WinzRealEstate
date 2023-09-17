package service.impl;

import constants.Constants;
import service.IFind;

public class IFindFactory {
    public static IFind createIFind(int flag){
        switch (flag){
            case Constants.FIND_BY_PRICE_HIGH_TO_LOW:
                return new FindByPriceHighToLow();
            case Constants.FIND_BY_PRICE_LOW_TO_HIGH:
                 return new FindByPriceLowToHigh();
            case Constants.FIND_BY_NAME:
                return  new FindByTitle();
        }
        return null;
    }
}
