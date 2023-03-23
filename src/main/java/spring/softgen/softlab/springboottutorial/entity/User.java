package spring.softgen.softlab.springboottutorial.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@SequenceGenerator(name = "usersIdGenerator", sequenceName = "users_id_seq", allocationSize = 1)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersIdGenerator")
    private Integer id;
    private String username;
    private String password;
    private String email;
    @Column(name = "create_date", insertable = false, updatable = false)
    private LocalDateTime createDate;
    private boolean active;
    @PrePersist
    private void prePersist() {
        active = true;
        createDate = LocalDateTime.now();
    }
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
