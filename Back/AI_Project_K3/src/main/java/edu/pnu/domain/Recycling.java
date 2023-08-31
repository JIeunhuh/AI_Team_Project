package edu.pnu.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
// table이름과 class 이름이 달라서 테이블 이름 정해줘야 함
@Table(name = "total_recycle")
public class Recycling {
	@Id
	// Auto - Increment
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long detect_log_id;
	private Integer device_id;
	private String ai_result;
	private LocalDate date;
	@Column(columnDefinition = "time")
	private LocalTime time;
	private Boolean state;
	private Integer ce;
	private Integer rm;
	private String reason;
	private String img_url;

}
