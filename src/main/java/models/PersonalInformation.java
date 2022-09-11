package models;

import com.github.javafaker.Faker;

public class PersonalInformation {
    private final String firstName;
    private final String lastName;
    private final String zipCode;

    public PersonalInformation() {
        var faker = new Faker();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.zipCode = faker.address().zipCode();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }
}
