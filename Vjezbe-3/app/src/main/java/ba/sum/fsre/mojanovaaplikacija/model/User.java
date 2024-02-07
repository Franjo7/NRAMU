package ba.sum.fsre.mojanovaaplikacija.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties // ako ne želimo da se neki atribut mapira u bazu
public class User {
    public String firstname;
    public String lastname;
    public String phone;
    public String address;
    public String place;
    public String country;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String firstname, String lastname, String phone, String address, String place, String country) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.place = place;
        this.country = country;
    }

}
