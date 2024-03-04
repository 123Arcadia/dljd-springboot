package springboottestmybatisdemo.pojo;

public class User {
    private String name;
    private String address;
    private String pgone;
    private String password;
    private Long id;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pgone='" + pgone + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPgone() {
        return pgone;
    }

    public void setPgone(String pgone) {
        this.pgone = pgone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
