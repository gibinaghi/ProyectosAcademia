package com.ayi.curso.rest.serv.ayispringrestful.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;

		@Column(name = "title", unique = true)
		private String title;

		@Column(name = "author")
		private String author;
		
		@Column(name = "category")
		private String category;
		
		@Column(name = "edition")
		private String edition;
		
		@Column(name = "idiom")
		private String idiom;
		
		@Column(name = "stock")
		private Integer stock;

		@Column(name = "available")
		private Integer available;

		//Relations
		@OneToMany(mappedBy = "books", cascade = CascadeType.ALL, orphanRemoval = true)
		@JsonIgnoreProperties(value = "users")
	    private List<Lendings> lendings = new ArrayList<>();
		
		
}
