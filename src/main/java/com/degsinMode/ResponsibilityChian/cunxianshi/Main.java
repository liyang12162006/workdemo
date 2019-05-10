package com.degsinMode.ResponsibilityChian.cunxianshi;

/**
 * @author yangyangl
 * @date 2019-01-31 14:19
 */
public class Main {

    public static void main(String[] args) {
        Handler villageHandler = new VillageHandler();
        Handler townHandler = new TownHandler();
        Handler countyHandler = new CountyHandler();
        Handler centerHandler = new centerHandler();

        villageHandler.setNext(townHandler);
        townHandler.setNext(countyHandler);
        countyHandler.setNext(centerHandler);

        System.out.println("test county request:");
        villageHandler.handleRequest("county");

        System.out.println("\ntest city request:");
        villageHandler.handleRequest("city");
    }
}