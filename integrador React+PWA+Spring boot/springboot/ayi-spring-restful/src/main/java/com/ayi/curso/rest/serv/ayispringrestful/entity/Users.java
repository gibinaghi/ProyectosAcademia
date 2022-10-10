package com.ayi.curso.rest.serv.ayispringrestful.entity;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name_p")
	private String last_name_p;
	
	@Column(name = "last_name_m")
	private String last_name_m;
	
	@Column(name = "domicilio", nullable = true)
	private String domicilio;
	
	@Column(name = "tel", nullable = true)
	private String tel;
	
	@Column(name = "sanctions", nullable = true)
	private Integer sanctions;
	
	@Column(name = "sanc_money")
	private Integer sanc_money;
	
	//Relations
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//@MapsId("id")
	@JoinColumn(name = "lend_id")
    private List<Lendings> lendings;
	
}
