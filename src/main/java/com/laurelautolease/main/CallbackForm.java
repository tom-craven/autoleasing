package com.laurelautolease.main;

public class CallbackForm {
    String firstname; String surname; String emailtelephone; String message;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailtelephone() {
        return emailtelephone;
    }

    public void setEmailtelephone(String emailtelephone) {
        this.emailtelephone = emailtelephone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CallbackForm{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", emailtelephone='" + emailtelephone + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
