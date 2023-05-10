package org.ieselcaminas.jpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;

  @OneToMany(mappedBy = "customer",  fetch=FetchType.EAGER)
  private List<Note> notes;

  protected Customer() {}
  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.notes = new ArrayList<>();
  }
  public Long getId() {
    return id;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<Note> getNotes(){
    return this.notes;
  }

  public void addNote(Note note){
    this.notes.add(note);
  }
  @Override
  public String toString() {
    return String.format(
            "Customer[id=%d, firstName='%s', lastName='%s']",
            id, firstName, lastName);
  }

}