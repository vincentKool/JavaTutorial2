package tutorial.persistence.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Tweet {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    @NotNull
    private String id_str;

    @Column(nullable=false)
    @NotNull
    private String text;

    @Column(nullable = false)
    @NotNull
    private Date created_at;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productId", nullable=false)
    @JsonBackReference
    private Product product;

    public Tweet() {}

    public Tweet(String id_str, String text, Date created_at, Product product) {
        this.id_str = id_str;
        this.text = text;
        this.created_at = created_at;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public String getId_str() {
        return id_str;
    }

    public String getText() {
        return text;
    }

    public Date getCreated_at() { return created_at; }

    public Product getProduct() {
        return product;
    }

}
