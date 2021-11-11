package com.selectivegames.main.selectivegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selectivegames.main.selectivegames.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

	List<Category> findByStatus(int status);
}
