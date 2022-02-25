package africa.semicolon.phoenixbookstore.data.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int pageCount;
    @Column(nullable = false)
    private String author;
    private String imageUrl;
    private String publishDate;
    private Status status;
}
