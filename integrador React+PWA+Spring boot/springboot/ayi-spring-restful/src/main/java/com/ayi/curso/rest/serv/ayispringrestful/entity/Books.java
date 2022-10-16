package com.ayi.curso.rest.serv.ayispringrestful.entity;
import java.io.Serializable;
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
@Table(name = "books")
public class Books implements Serializable {
	private static final Long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

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

		//Relations
		@OneToMany(mappedBy = "books", cascade = CascadeType.ALL, orphanRemoval = true)
		@JsonIgnoreProperties(value = "books")
	    private List<Lendings> lendings;
		
		
}
