package mk.com.gymbuddies.gymbuddy.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "workout", schema = "project", catalog = "db_202324z_va_prj_gymbuddies")
public class WorkoutEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "durationinminutes", nullable = true)
    private Integer durationinminutes;
    @Basic
    @Column(name = "type", nullable = false, length = -1)
    private String type;

    @Basic
    @Column(name = "price", nullable = false)
    private Integer price;
    @Basic
    @Column(name = "memberfk", nullable = false)
    private Integer memberfk;
    @Basic
    @Column(name = "gymfk", nullable = false)
    private Integer gymfk;

    public WorkoutEntity() {
    }

    public WorkoutEntity(Integer durationinminutes, String type, Integer price, Integer memberfk, Integer gymfk) {
        this.durationinminutes = durationinminutes;
        this.type = type;
        this.price = price;
        this.memberfk = memberfk;
        this.gymfk = gymfk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDurationinminutes() {
        return durationinminutes;
    }

    public void setDurationinminutes(Integer durationinminutes) {
        this.durationinminutes = durationinminutes;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = String.valueOf((WorkoutType) type);
    }

    public void setType(WorkoutType type) {
        this.type = String.valueOf(type);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMemberfk() {
        return memberfk;
    }

    public void setMemberfk(Integer memberfk) {
        this.memberfk = memberfk;
    }

    public Integer getGymfk() {
        return gymfk;
    }

    public void setGymfk(Integer gymfk) {
        this.gymfk = gymfk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutEntity that = (WorkoutEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(durationinminutes, that.durationinminutes) && Objects.equals(type, that.type) && Objects.equals(price, that.price) && Objects.equals(memberfk, that.memberfk) && Objects.equals(gymfk, that.gymfk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, durationinminutes, type, price, memberfk, gymfk);
    }
}
