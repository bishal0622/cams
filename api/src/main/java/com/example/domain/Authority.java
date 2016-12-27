package com.example.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by japnica on 12/20/2016.
 */
@Entity
@Table(name="authority")
public class Authority {
    @Id
    @GeneratedValue
    @Column(name="authorityId")
    private Long id;

    @Column(name="authorityName", nullable = false)
    private String authorityName;

  //  @OneToMany(mappedBy = "authority")
   // private Collection<AuthorityStaff> authorityStaffs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authorityName='" + authorityName + '\'' +
                '}';
    }
}
