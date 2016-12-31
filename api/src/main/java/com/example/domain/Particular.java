package com.example.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by BiSAl MhRzn on 12/29/2016.
 */
@Entity
public class Particular {
    private Integer id;
    private String particularName;
    private double particularRate;
    private Collection<ParticularBilling> particularBillingsByParticularId;

    @Id
    @Column(name = "particular_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "particular_name", nullable = false, length = 255)
    public String getParticularName() {
        return particularName;
    }

    public void setParticularName(String particularName) {
        this.particularName = particularName;
    }

    @Basic
    @Column(name = "particular_rate", nullable = false, precision = 0)
    public double getParticularRate() {
        return particularRate;
    }

    public void setParticularRate(double particularRate) {
        this.particularRate = particularRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Particular that = (Particular) o;

        if (id != that.id) return false;
        if (Double.compare(that.particularRate, particularRate) != 0) return false;
        if (particularName != null ? !particularName.equals(that.particularName) : that.particularName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (particularName != null ? particularName.hashCode() : 0);
        temp = Double.doubleToLongBits(particularRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "particularByParticularparticularId")
    public Collection<ParticularBilling> getParticularBillingsByParticularId() {
        return particularBillingsByParticularId;
    }

    public void setParticularBillingsByParticularId(Collection<ParticularBilling> particularBillingsByParticularId) {
        this.particularBillingsByParticularId = particularBillingsByParticularId;
    }
}
