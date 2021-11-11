package com.selectivegames.main.selectivegames.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DLR {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long ani;
	private String mt;
	private String client;
	private Long requestId;
	private String refId;
	private String operator;
	private Long telNo;
	private int amount;
	private int statusId;
	private long wpAuthReqRef;
	private String statusTime;
	private String statusMessage;

	@Column(columnDefinition = "integer default 0")
	private int processStatus;
	private LocalDateTime datetime;

}
