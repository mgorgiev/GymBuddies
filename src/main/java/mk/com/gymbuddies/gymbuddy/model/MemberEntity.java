package mk.com.gymbuddies.gymbuddy.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "member", schema = "project", catalog = "db_202324z_va_prj_gymbuddies")
public class MemberEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "registrationdate", nullable = false)
    private LocalDate registrationdate;
    @Basic
    @Column(name = "expirationdate", nullable = false)
    private LocalDate expirationdate;
    @Basic
    @Column(name = "instructorfk", nullable = true)
    private Integer instructorfk;
    @Basic
    @Column(name = "userfk", nullable = false)
    private int userfk;

    public MemberEntity() {
    }

    public MemberEntity(LocalDate registrationdate, LocalDate expirationdate, int userfk) {
        this.registrationdate = registrationdate;
        this.expirationdate = expirationdate;
        this.userfk = userfk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(LocalDate registrationdate) {
        this.registrationdate = registrationdate;
    }

    public LocalDate getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(LocalDate expirationdate) {
        this.expirationdate = expirationdate;
    }

    public Integer getInstructorfk() {
        return instructorfk;
    }

    public void setInstructorfk(Integer instructorfk) {
        this.instructorfk = instructorfk;
    }

    public int getUserfk() {
        return userfk;
    }

    public void setUserfk(int userfk) {
        this.userfk = userfk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberEntity that = (MemberEntity) o;
        return id == that.id && userfk == that.userfk && Objects.equals(registrationdate, that.registrationdate) && Objects.equals(expirationdate, that.expirationdate) && Objects.equals(instructorfk, that.instructorfk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationdate, expirationdate, instructorfk, userfk);
    }
}
