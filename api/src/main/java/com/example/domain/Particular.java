package com.example.domain;



import javax.persistence.*;
import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/20/2016.
 */
@Entity
@Table(name="particular")
public class Particular {

    @Id
    @GeneratedValue
    @Column(name="particularId")
    private Long id;

    @Column(name="particularName", nullable = false)
    private String particularName;

    @Column(name="particularRate", nullable = false)
    private Double particularRate;

//    @OneToMany(mappedBy = "particular")
//    private Collection<ParticularBilling> particularBillings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParticularName() {
        return particularName;
    }

    public void setParticularName(String particularName) {
        this.particularName = particularName;
    }

    public Double getParticularRate() {
        return particularRate;
    }

    public void setParticularRate(Double particularRate) {
        this.particularRate = particularRate;
    }

//    public Collection<ParticularBilling> getParticularBillings() {
//        return particularBillings;
//    }
//
//    public void setParticularBillings(Collection<ParticularBilling> particularBillings) {
//        this.particularBillings = particularBillings;
//    }

    @Override
    public String toString() {
        return "Particular{" +
                "id=" + id +
                ", particularName='" + particularName + '\'' +
                ", particularRate=" + particularRate +
//                ", particularBillings=" + particularBillings +
                '}';
    }
}
