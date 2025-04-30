package com.example.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="bookingform")

public class BookingForm 

{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	
    @Column(length=30)
    @NotEmpty(message="name can't be empty")
    @NotBlank(message="name cant be blank")
    @Size(min=2,max=30,message="invalid length")
    @Pattern(regexp="^[A-Za-z]+$", message ="name must contain only alphabet")
    private String name;
    
    @NotEmpty(message="message can't be empty")
    @NotBlank(message="name cant be blank")
    @Size(min=2,max=30,message="invalid length")
    @Column(length=50)
    private String email;
    
    @NotEmpty(message="From can't be empty")
    @NotBlank(message="name cant be blank")
    @Size(min=2,max=30,message="invalid length")
    @Column(length=100)
    private String source;
    
    @NotEmpty(message="To can't be empty")
    @NotBlank(message="name cant be blank")
    @Size(min=2,max=30,message="invalid length")
    @Column(length=100)
    private String destination;
    
    @NotNull(message="time cant be null")
    private LocalTime time;
    
    @NotNull(message="date cant be null")
    private LocalDate date;
    
    @Column(length=20)
    @NotEmpty(message="comfort can't be empty")
    private String comfort;
    
    @Min(value=1,message="atleast 1 adult")
    @Max(value=4,message="atmost 4")
    private int adult;
    
    @Max(value=3,message="children atmost 3 allowed")
    private int children;
    
    @NotEmpty(message="message can't be empty")
    @NotBlank(message="name cant be blank")
    @Size(min=2,max=300,message="invalid length")
    @Column(length=300)
    private String message;

    // No-args constructor
    public BookingForm() {
    }

    // All-args constructor
    public BookingForm(int id, String name, String email, String source, String destination, LocalTime time,
                       LocalDate date, String comfort, int adult, int children, String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.source = source;
        this.destination = destination;
        this.time = time;
        this.date = date;
        this.comfort = comfort;
        this.adult = adult;
        this.children = children;
        this.message = message;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFrom() { return source; }
    public void setFrom(String source) { this.source = source; }

    public String getTo() { return destination; }
    public void setTo(String destination) { this.destination = destination; }

    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getComfort() { return comfort; }
    public void setComfort(String comfort) { this.comfort = comfort; }

    public int getAdult() { return adult; }
    public void setAdult(int adult) { this.adult = adult; }

    public int getChildren() { return children; }
    public void setChildren(int children) { this.children = children; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    // toString method
    @Override
    public String toString() {
        return "BookingForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", time=" + time +
                ", date=" + date +
                ", comfort='" + comfort + '\'' +
                ", adult=" + adult +
                ", children=" + children +
                ", message='" + message + '\'' +
                '}';
    }
}




/*
 * package com.example.model;
 * 
 * import java.time.LocalDate; import java.time.LocalTime;
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 * 
 * @Setter
 * 
 * @Getter
 * 
 * @ToString public class BookingForm { private int id; private String name;
 * private String email; private String from; private String to; private
 * LocalTime time; private LocalDate date; private String comfort; private int
 * adult; private int children; private int message;
 * 
 * 
 * 
 * }
 */