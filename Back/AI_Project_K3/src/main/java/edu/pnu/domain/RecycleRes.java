package edu.pnu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "result_list")
public class RecycleRes {
	@Id
	// Auto - Increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long detect_log_id;
	private String category;
	private Integer count;
	
}
