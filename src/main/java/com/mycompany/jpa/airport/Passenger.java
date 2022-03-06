package com.mycompany.jpa.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PASSENGERS") // table creation
public class Passenger {
	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "AIPORT_ID") //FOREIGN KEY
	private Airport airport;
	
	@OneToMany(mappedBy = "passenger")
	private List<Ticket> tickets = new ArrayList<>();

	// now we need our constructor below

	public Passenger() {

	}
	// now we need our parameterized constructors below(using fields)

	public Passenger(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// generating our getters setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public List<Ticket> getTickets() {
		return Collections.unmodifiableList(tickets);
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

}
