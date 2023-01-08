package emlakcepte.request;

import java.time.LocalDateTime;

public class ProductRequest {

    private LocalDateTime startDate;
    private Integer userId;


    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
