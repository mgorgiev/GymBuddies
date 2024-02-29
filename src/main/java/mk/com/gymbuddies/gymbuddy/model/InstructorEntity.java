package mk.com.gymbuddies.gymbuddy.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "instructor", schema = "project", catalog = "db_202324z_va_prj_gymbuddies")
public class InstructorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "hiredate", nullable = false)
    private LocalDate hiredate;
    @Basic
    @Column(name = "userfk", nullable = false)
    private int userfk;
    @Basic
    @Column(name = "priceperworkout", nullable = false)
    private int priceperworkout;

    public InstructorEntity() {
    }

    public InstructorEntity(LocalDate hiredate, int userfk, int priceperworkout) {
        this.hiredate = hiredate;
        this.userfk = userfk;
        this.priceperworkout = priceperworkout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
    }

    public int getUserfk() {
        return userfk;
    }

    public void setUserfk(int userfk) {
        this.userfk = userfk;
    }

    public int getPriceperworkout() {
        return priceperworkout;
    }

    public void setPriceperworkout(int priceperworkout) {
        this.priceperworkout = priceperworkout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorEntity that = (InstructorEntity) o;
        return id == that.id && userfk == that.userfk && priceperworkout == that.priceperworkout && Objects.equals(hiredate, that.hiredate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hiredate, userfk, priceperworkout);
    }
}
