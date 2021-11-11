package com.selectivegames.main.selectivegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selectivegames.main.selectivegames.model.Logging;

public interface LoggingRepo extends JpaRepository<Logging, Long> {

}
