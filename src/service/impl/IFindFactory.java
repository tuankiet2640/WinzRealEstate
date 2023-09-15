package service.impl;

import service.IFind;

public class IFindFactory {
    public static IFind createIFind(int flag){
        IFind ifind = null;
        flag=0;
        switch (flag){
            case 0:
                ifind= new FindByPrice();
                return ifind;
            case 1:
                ifind= new FindByAddress();
                return ifind;
        }
        return null;
    }
}
