package com.selectivegames.main.selectivegames.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.selectivegames.main.selectivegames.common.LogType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Logging {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long ani;

	@Enumerated(EnumType.STRING)
	private LogType type;
	private String status;

	@Column(columnDefinition = "text")
	private String data;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime datetime;

	public Logging(Long ani, LogType type, String status, String data, LocalDateTime datetime) {
		super();
		this.ani = ani;
		this.type = type;
		this.status = status;
		this.data = data;
		this.datetime = datetime;
	}

}
