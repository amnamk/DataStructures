package homework3;
public class Entry {
    String surname, name, streetAddress, city, postcode, country, phoneNumber;

    public Entry(String surname, String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }


    public int compareTo(Entry other) {
        int cmp = this.surname.compareTo(other.surname);
        if (cmp == 0) {
            cmp = this.name.compareTo(other.name);
        }
        return cmp;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}



