public class Account {
    String firstname;
    String lastname;

    public Account(String fn, String ln){
        this.firstname = fn;
        this.lastname = ln;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
