package mk.com.gymbuddies.gymbuddy.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user", schema = "project", catalog = "db_202324z_va_prj_gymbuddies")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "username", nullable = false, length = 256)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 256)
    private String password;
    @Basic
    @Column(name = "firstname", nullable = false, length = 256)
    private String firstname;
    @Basic
    @Column(name = "lastname", nullable = false, length = 256)
    private String lastname;
    @Basic
    @Column(name = "email", nullable = false, length = 256)
    private String email;
    @Basic
    @Column(name = "phonenumber", nullable = true, length = 256)
    private String phonenumber;
    @Basic
    @Column(name = "gender", nullable = true, length = 256)
    private String gender;
    public UserEntity(){}
    public UserEntity(String username, String password, String firstname, String lastname, String email, String phonenumber, String gender) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(email, that.email) && Objects.equals(phonenumber, that.phonenumber) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstname, lastname, email, phonenumber, gender);
    }
}
