package com.ayi.curso.rest.serv.ayispringrestful.entity;
import java.util.List;

import javax.persistence.*;

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

		@Column(name = "author")
		private String author;
		
		@Column(name = "available")
		private Integer available;
		
		@Column(name = "category")
		private String category;
		
		@Column(name = "date")
		private String date;
		
		@Column(name = "description")
		private String description;
		
		@Column(name = "edit")
		private String edit;
		
		@Column(name = "lang")
		private String lang;
		
		@Column(name = "stock")
		private Integer stock;
		
		@Column(name = "title")
		private String title;

		
		//Relations
		@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		//@MapsId("id")
		@JoinColumn(name = "lend_id")
	    private List<Lendings> lendings;
		
		
}
