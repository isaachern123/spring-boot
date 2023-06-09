package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "users")
public class User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1024, nullable = false, unique = true)
    private String username;

    @Column(length = 1024, nullable = false)
    private String email;

    @Column(length = 1024, nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @ToString.Exclude
    private List<Post> posts;

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }
}
