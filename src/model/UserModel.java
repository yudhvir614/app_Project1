package model;

public class UserModel {
    enum userType {
        admin,
        tenant
    }
    int id;
    String email;
    String firstName;
    String lastName;
    String password; //hide password
    userType type;
}
