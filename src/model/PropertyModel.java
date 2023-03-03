package model;

import java.rmi.dgc.Lease;

public class PropertyModel {
    int id;
    String streetName;
    String city;
    String postalCode;
    int numOfBedrooms;
    int numOfBathrooms;
    float squareFoot;
    LeaseModel lease;

    PropertyModel(int id, String streetName, String city, String postalCode, int numOfBathrooms, int numOfBedrooms, float squareFoot, LeaseModel lease) {
        this.id = id;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.numOfBathrooms = numOfBathrooms;
        this.numOfBedrooms = numOfBedrooms;
        this.squareFoot = squareFoot;
        this.lease = lease;
    }

    Appartment getApartmentObject( ) {
        Appartment aptObj = new Appartment();
        aptObj.
    }
}

class AppartmentBuilding extends PropertyModel {
    //String CivicAddress;
    int buildingNumber;
    Appartment[] apartments;
    Condos[] condos;
}

class Appartment extends AppartmentBuilding {
    int unitNumber;
}

class Condos extends Appartment {
    int streetNum;
}

class House extends PropertyModel {
    int streetNum;
}
