package com.riodevida.common;

import com.riodevida.exceptions.NotFoundException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Getter
public abstract class BaseService<Entity extends BaseEntity, Repository extends BaseRepository<Entity>> {

    @Autowired
    protected Repository repository;

    @Transactional
    public Entity create(Entity entity) {
        return repository.save(entity);
    }

    @Transactional
    public Entity update(Long id, Entity entity) {
        return repository.save(entity);
    }

    public List<Entity> getAll() {
        return repository.findAll();
    }

    public Entity getById(Long id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}

