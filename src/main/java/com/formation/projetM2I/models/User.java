package com.formation.projetM2I.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	private String username;

	private String address;

	@Column(name="create_time")
	private Timestamp createTime;


	private String email;

	private String firstname;

	private String lastname;

	private String password;

	private String picture;

	private String type;

	//bi-directional many-to-one association to Announcement
	@OneToMany(mappedBy="user")
	private List<Announcement> announcements;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user")
	private List<Message> messages;

	//bi-directional many-to-many association to User
	@ManyToMany
	@JoinTable(
		name="members"
		, joinColumns={
			@JoinColumn(name="user_id1")
			}
		, inverseJoinColumns={
			@JoinColumn(name="user_id")
			}
		)
	private List<User> membres;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="membres")
	private List<User> assossiations;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Announcement> getAnnouncements() {
		return this.announcements;
	}

	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
	}

	public Announcement addAnnouncement(Announcement announcement) {
		getAnnouncements().add(announcement);
		announcement.setUser(this);

		return announcement;
	}

	public Announcement removeAnnouncement(Announcement announcement) {
		getAnnouncements().remove(announcement);
		announcement.setUser(null);

		return announcement;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setUser(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setUser(null);

		return message;
	}

	public List<User> getMembres() {
		return this.membres;
	}

	public void setMembres(List<User> membres) {
		this.membres = membres;
	}

	public List<User> getAssossiations() {
		return this.assossiations;
	}

	public void setAssossiations(List<User> assossiations) {
		this.assossiations = assossiations;
	}

}