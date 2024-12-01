package com.angelldca.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


@NoRepositoryBean
public interface IRepository <T, ID> extends JpaRepository<T,ID> {
}
