package com.selectivegames.main.selectivegames.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.selectivegames.main.selectivegames.model.Subscription;

public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {

	@Query("select s from Subscription s where ani = :ani and date(next_billed_date) >= date(:datetime) and service_type= :service")
	Subscription getSubscriberCount(@Param("ani") Long ani, @Param("datetime") LocalDateTime datetime,
			@Param("service") String service);

	Subscription findByServiceAndAni(String service, Long ani);

}
