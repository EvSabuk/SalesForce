package dto;

public class Account {

    private String name;
    private String phone;
    private String fax;
    private String rating;

    public Account(String name, String phone, String fax, String rating) {
        this.name = name;
        this.phone = phone;
        this.fax = fax;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getRating() {
        return rating;
    }
}
