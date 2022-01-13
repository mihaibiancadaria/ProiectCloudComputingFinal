package com.example.cloudprojectseminar;

import java.util.List;

public interface ServiceI<O> {
    Object saveObject(O object);
    O getObject(Long id);
    List<O> getObject_name(String name);
    List<O> getAllObjects();
    boolean deleteObject(Long id);
}
