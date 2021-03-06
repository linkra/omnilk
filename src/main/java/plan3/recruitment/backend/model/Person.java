package plan3.recruitment.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person implements Comparable {

    @JsonProperty
    private final String email;
    @JsonProperty
    private final String firstname;
    @JsonProperty
    private final String lastname;

    public Person(@JsonProperty("firstname") final String firstname,
                  @JsonProperty("lastname") final String lastname,
                  @JsonProperty("email") final String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    @Override
    public String toString() {
        return this.firstname + ' ' + this.lastname + " [" + this.email + "] ";
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return this.email;

    }

    // DO NOT REMOVE THIS METHOD. But feel free to adjust to suit your needs.
    public static Person valueOf(final String firstname, final String lastname, final String email) {
        return new Person(firstname, lastname, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (this.email != null ? !this.email.equals(person.email) : person.email != null) {
            return false;
        }

        if (!this.firstname.equals(person.firstname)) {
            return false;
        }

        if (!this.lastname.equals(person.lastname)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = this.email != null ? this.email.hashCode() : 0;
        result = 31 * result + this.firstname.hashCode();
        result = 41 * result + this.lastname.hashCode();
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
          Person personToCompare = (Person) o;
          return this.getLastname().compareTo(personToCompare.getLastname());
        }
        return -1;
    }
}