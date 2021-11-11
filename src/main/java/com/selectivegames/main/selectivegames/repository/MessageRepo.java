package com.selectivegames.main.selectivegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selectivegames.main.selectivegames.model.Message;

public interface MessageRepo extends JpaRepository<Message, Integer> {

}
