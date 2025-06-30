package com.example.basic.demo.model;

import java.util.List;
//This happens automatically — you never need to write it
import java.lang.String;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	@ManyToMany
	@JoinTable(
			name="board_members",
			joinColumns=@JoinColumn(name="board_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
		)
	private List<User> members;
	
	 public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }
	    
	    public List<User> getMembers() {
	        return members;
	    }

	    public void setMembers(List<User> members) {
	        this.members = members;
	    }
	    
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }


}
	
