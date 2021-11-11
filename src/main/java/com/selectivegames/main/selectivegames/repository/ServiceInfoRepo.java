package com.selectivegames.main.selectivegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selectivegames.main.selectivegames.model.ServiceInfo;

public interface ServiceInfoRepo extends JpaRepository<ServiceInfo, Integer> {

	ServiceInfo findByClientName(String clinetName);

}
