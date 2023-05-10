package org.ieselcaminas.jpa;

import jakarta.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String text;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private Customer customer;

    protected Note() {}
    public Note(Customer customer, String text) {
        this.customer = customer;
        this.text = text;
    }
    public Long getId() {
        return id;
    }
    public String getText() {
        return text;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return text;
    }

}