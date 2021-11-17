package com.selectivegames.main.selectivegames.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_subscription")
@Getter
@Setter
@NoArgsConstructor
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long ani;
	private LocalDateTime sub_date_time;
	private LocalDateTime unsub_date_time;
	private String m_act;
	private String m_deact;
	private String lang;
	@Column(name = "service_type")
	private String service;
	private String STATUS;
	private String charging_date;
	private LocalDateTime billing_date;
	private LocalDateTime next_billed_date;
	private String last_billed_date;
	private int default_amount;
	private String RECORDSTATUS;
	private String product_id;
	private String pack_type;
	private LocalDateTime LAST_CONTENT_DATE;
	private String provider;

}
