package dwmh.models;

public class Host {
    private String id;
    String lastName;
    String email;
    String phone;
    Location location;

    public Host(String lastName, String email, String phone, Location location) {
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.location = location;
    }

    public Host() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
