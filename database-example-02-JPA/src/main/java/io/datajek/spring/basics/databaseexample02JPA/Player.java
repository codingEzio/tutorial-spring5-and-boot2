package io.datajek.spring.basics.databaseexample02JPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Player")
@NamedQuery(name = "get_all_players", query = "SELECT p FROM Player AS p")
@NamedQuery(name = "get_player_by_titles", query = "SELECT p FROM Player AS p WHERE titles = :titles")
public class Player {
	@Id
	@GeneratedValue
	private int id;

	@Column (name="name")
	private String name;

	@Column(name = "nationality")
	private String nationality;

	private Date birthDate;
	private int titles;

	public Player() {

	}

	public Player(String name, String nationality, Date birthDate, int titles) {
		super();

		this.name = name;
		this.nationality = nationality;
		this.birthDate = birthDate;
		this.titles = titles;
	}

	public Player(int id, String name, String nationality, Date birthDate, int titles) {
		super();

		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.birthDate = birthDate;
		this.titles = titles;
	}

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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getTitles() {
		return titles;
	}

	public void setTitles(int titles) {
		this.titles = titles;
	}
}