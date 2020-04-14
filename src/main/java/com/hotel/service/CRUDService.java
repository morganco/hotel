package com.hotel.service;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public abstract class CRUDService<Entity, Id, Repository extends JpaRepository<Entity, Id>> {

    abstract Repository getApartmentTypeRepository();

    public Entity getById(Id id) {
        Optional<Entity> entity = getApartmentTypeRepository().findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException();
        }
    }

    public Entity save(Entity entity) {
        return getApartmentTypeRepository().save(entity);
    }

    public void deleteById(Id id) {
        getApartmentTypeRepository().deleteById(id);
    }

    public List<Entity> getAll() {
        return getApartmentTypeRepository().findAll();
    }

    public void deleteAll(List<Entity> entities) {
        getApartmentTypeRepository().deleteAll(entities);
    }

    public boolean isExists(Id id) {
        return getApartmentTypeRepository().existsById(id);
    }
}
