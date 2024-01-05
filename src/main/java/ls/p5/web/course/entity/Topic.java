package ls.p5.web.course.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TOPIC")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TOPIC_ID")
    private Long topicId;

    @Column(name = "NAME", nullable = false, length = 500)
    private String name;

    @Column(name = "DESCRIPTION", nullable = true, length = 2000)
    private String description;

    @Column(name = "details", nullable = false, length = 2000)
    private String details;
}
