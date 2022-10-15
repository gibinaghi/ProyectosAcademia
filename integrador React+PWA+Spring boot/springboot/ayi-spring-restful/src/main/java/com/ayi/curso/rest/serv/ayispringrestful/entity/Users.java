package com.ayi.curso.rest.serv.ayispringrestful.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name_p")
	private String last_name;
	
	@Column(name = "dni", unique = true)
	private String dni;
	
	@Column(name = "address", nullable = true)
	private String address;
	
	@Column(name = "phone", nullable = true)
	private String phone;
	
	//Relations
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = "users")
    private List<Lendings> lendings;
	
}
