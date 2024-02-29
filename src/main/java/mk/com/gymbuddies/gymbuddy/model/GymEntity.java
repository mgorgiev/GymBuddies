package mk.com.gymbuddies.gymbuddy.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "gym", schema = "project", catalog = "db_202324z_va_prj_gymbuddies")
public class GymEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "address", nullable = false, length = 256)
    private String address;
    @Basic
    @Column(name = "name", nullable = false, length = 256)
    private String name;
    @Basic
    @Column(name = "city", nullable = false, length = 256)
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GymEntity gymEntity = (GymEntity) o;
        return id == gymEntity.id && Objects.equals(address, gymEntity.address) && Objects.equals(name, gymEntity.name) && Objects.equals(city, gymEntity.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, name, city);
    }
}
