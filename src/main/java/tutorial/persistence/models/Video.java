package tutorial.persistence.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Video {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    @NotNull
    private String title;

    @Column(nullable=false)
    @NotNull
    private String description;

    @Column(nullable=false)
    @NotNull
    private String youtubeId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productId", nullable=false)
    @JsonBackReference
    private Product product;

    public Video() {}

    public Video(String title, String description, String youtubeId, Product product) {
        this.title = title;
        this.description = description;
        this.youtubeId = youtubeId;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public Product getProduct() {
        return product;
    }

}
