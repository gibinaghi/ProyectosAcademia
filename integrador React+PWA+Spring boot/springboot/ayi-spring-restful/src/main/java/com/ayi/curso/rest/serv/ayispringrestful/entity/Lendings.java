package com.ayi.curso.rest.serv.ayispringrestful.entity;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lendings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lendings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "date_out")
	private String date_out;
	
	@Column(name = "date_return", nullable = true)
	private String date_return;
	
	//Deberian eliminarse
	@Column(name = "books_id", nullable = true)
	private String books_id;
	
	@Column(name = "users_id", nullable = true)
	private String users_id;
	
	
	//Relations
	@ManyToOne()
	//@MapsId("id")
    @JoinColumn(name = "user_id")
    private Users users;

	@ManyToOne()
	//@MapsId("id")
    @JoinColumn(name = "book_id")
    private Books books;
}
