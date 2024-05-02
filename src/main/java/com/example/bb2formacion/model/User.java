package com.example.bb2formacion.model;

        import javax.persistence.*;
        import lombok.Data;

        import java.util.Set;

@Data
@Entity
@Table(name="`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Item> items;
}
