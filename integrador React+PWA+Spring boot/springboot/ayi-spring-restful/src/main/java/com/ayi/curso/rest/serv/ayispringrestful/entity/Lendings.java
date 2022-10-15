package com.ayi.curso.rest.serv.ayispringrestful.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lendings")
public class Lendings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "date_out")
	private String date_out;
	
	@Column(name = "date_return", nullable = true)
	private String date_return;
	
	//Relations
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
	@JsonIgnoreProperties(value = "lendings")
    private Users users;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id")
	@JsonIgnoreProperties(value = "lendings")
    private Books books;
}
