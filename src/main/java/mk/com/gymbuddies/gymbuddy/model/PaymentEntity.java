package mk.com.gymbuddies.gymbuddy.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "payment", schema = "project", catalog = "db_202324z_va_prj_gymbuddies")
public class PaymentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;
    @Basic
    @Column(name = "memberfk", nullable = false)
    private int memberfk;
    @Basic
    @Column(name = "instructorfk", nullable = true)
    private Integer instructorfk;
    @Basic
    @Column(name = "workoutfk", nullable = false)
    private int workoutfk;
    @Basic
    @Column(name = "gymfk", nullable = false)
    private int gymfk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMemberfk() {
        return memberfk;
    }

    public void setMemberfk(int memberfk) {
        this.memberfk = memberfk;
    }

    public Integer getInstructorfk() {
        return instructorfk;
    }

    public void setInstructorfk(Integer instructorfk) {
        this.instructorfk = instructorfk;
    }

    public int getWorkoutfk() {
        return workoutfk;
    }

    public void setWorkoutfk(int workoutfk) {
        this.workoutfk = workoutfk;
    }

    public int getGymfk() {
        return gymfk;
    }

    public void setGymfk(int gymfk) {
        this.gymfk = gymfk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return id == that.id && amount == that.amount && memberfk == that.memberfk && workoutfk == that.workoutfk && gymfk == that.gymfk && Objects.equals(date, that.date) && Objects.equals(instructorfk, that.instructorfk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, amount, memberfk, instructorfk, workoutfk, gymfk);
    }
}
