//package com.example.model;
/*
 * import jakarta.validation.constraints.Max; import
 * jakarta.validation.constraints.Min; import
 * jakarta.validation.constraints.NotEmpty; import
 * jakarta.validation.constraints.NotNull; import
 * jakarta.validation.constraints.Size; import lombok.AllArgsConstructor;
 * 
 * import lombok.Getter; import lombok.NoArgsConstructor; import lombok.Setter;
 * import lombok.ToString;
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 * 
 * //@Getter //@Setter
 * 
 * @ToString public class ContactForm { private int id;
 * 
 * @NotEmpty(message="Name Cannot be Empty")
 * 
 * @Size(min=2,max=30,message="Invalid Name Size") private String name;
 * 
 * @NotEmpty(message="Email Cannot be Empty")
 * 
 * @Size(min=5,max=50,message="Invalid Name Size") private String email;
 * 
 * @Min(value=1000000000,message ="phone no.must be 10 digit")
 * 
 * @Max(value=9999999999L,message ="phone no.must be 10 digit")
 * 
 * @NotNull private long phone;
 * 
 * @NotEmpty(message="Message Cannot be Empty")
 * 
 * @Size(min=3,max=300,message="Invalid Message") private String message;
 * 
 * // Getter and Setter for id public int getId() { return id; }
 * 
 * public void setId(int id) { this.id = id; }
 * 
 * // Getter and Setter for name public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * // Getter and Setter for email public String getEmail() { return email; }
 * 
 * public void setEmail(String email) { this.email = email; }
 * 
 * // Getter and Setter for phone public long getPhone() { return phone; }
 * 
 * public void setPhone(long phone) { this.phone = phone; }
 * 
 * // Getter and Setter for message public String getMessage() { return message;
 * }
 * 
 * public void setMessage(String message) { this.message = message; }
 * 
 * 
 * }
 */
package com.example.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="contactform")
public class ContactForm {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name Cannot be Empty")
    @Size(min = 2, max = 30, message = "Invalid Name Size")
    @Column(length=30)
    private String name;

    @NotEmpty(message = "Email Cannot be Empty")
    @Size(min = 5, max = 50, message = "Invalid Name Size")
    @Column(length=50)
    private String email;

    @Min(value = 1000000000L, message = "phone no. must be 10 digits")
    @Max(value = 9999999999L, message = "phone no. must be 10 digits")
    @NotNull
    @Column(length=10)
    private long phone;

    @NotEmpty(message = "Message Cannot be Empty")
    @Size(min = 3, max = 300, message = "Invalid Message")
    @Column(length=300)
    private String message;

    // Default constructor
    public ContactForm() {}

    // Constructor with all fields
    public ContactForm(int id, String name, String email, long phone, String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.message = message;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for phone
    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    // Getter and Setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // toString method for printing object details
    @Override
    public String toString() {
        return "ContactForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", message='" + message + '\'' +
                '}';
    }

    // equals method to compare ContactForm objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactForm that = (ContactForm) o;
        return id == that.id &&
                phone == that.phone &&
                name.equals(that.name) &&
                email.equals(that.email) &&
                message.equals(that.message);
    }

    // hashCode method to generate hash for ContactForm objects
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, message);
    }
}
