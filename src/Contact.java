public class Contact {
    private String name, email;
    private int phone;


    public Contact(String name, int phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean equals(Contact otherContact) {
        return this.name.equals(otherContact.getName());
    }

    public int compareTo(Contact otherContact) {
        return this.name.compareTo(otherContact.getName());
    }
}
