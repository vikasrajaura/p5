package ls.p5.web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CHAPTER")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CHAPTER_ID")
    private Long chapterId;

    @Column(name = "NAME", nullable = false, length = 500)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false, length = 2000)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CHAPTER_TOPIC_MAP", joinColumns = @JoinColumn(name = "CHAPTER_ID"), inverseJoinColumns = @JoinColumn(name = "TOPIC_ID"))
    @Fetch(FetchMode.SUBSELECT)
    private Set<Topic> topics = new HashSet<>();

}
