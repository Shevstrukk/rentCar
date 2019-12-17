package com.github.Shevstrukk.dao.repository;

import com.github.Shevstrukk.dao.entity.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEntityRepository extends JpaRepository<PersonEntity, Integer> {
    Page<PersonEntity> findAll(Pageable pageable);
}
