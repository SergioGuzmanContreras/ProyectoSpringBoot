package mx.com.ersoft.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.ersoft.entity.LogEntity;

@Repository
public interface LogDao extends JpaRepository<LogEntity, Serializable>{

}
