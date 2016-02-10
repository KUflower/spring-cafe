package scafe.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import scafe.domain.AppManager;

public interface AppManagerDao extends JpaRepository <AppManager, Integer> {

}
