package emlakcepte.model;


import emlakcepte.model.enums.PurchaseStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "count")
    private int count = 10;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "exp_date")
    private LocalDateTime expDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;

    public Product() {
    }

    public Product(LocalDateTime startDate, LocalDateTime expDate) {
        this.startDate = startDate;
        this.expDate = expDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDateTime expDate) {
        this.expDate = expDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
