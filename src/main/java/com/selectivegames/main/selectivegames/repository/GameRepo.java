package com.selectivegames.main.selectivegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selectivegames.main.selectivegames.model.Category;
import com.selectivegames.main.selectivegames.model.Game;

public interface GameRepo extends JpaRepository<Game, Long> {
	List<Game> findByCategoryAndStatus(Category category, int status);
}
