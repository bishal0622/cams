package com.clinic.service;

import java.util.List;

/**
 * Created by japnica on 1/4/2017.
 */
public interface GenericService<DTO, Obj> {
    public Obj save(DTO dto);
    public List<Obj> getAll();
    public void update(DTO dto);
    public Obj findOne(int id);
    public void delete(int id);
}
