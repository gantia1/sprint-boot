package spring.softgen.softlab.springboottutorial.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Posts")
@SequenceGenerator(name = "postsIdGenerator", sequenceName = "posts_id_seq", allocationSize = 1)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postsIdGenerator")
    private Integer id;
    private String title;
    private String body;
    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userId;
    @Column(name = "create_date", insertable = false, updatable = false)
    private LocalDateTime createDate;

    @PrePersist
    private void prePersist() {
        createDate = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
