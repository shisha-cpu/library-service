package com.example.demo.Order;

import java.util.Date;

public class Order {
    private Long id;
    private Long userId;
    private Long bookId;
    private Date createdDate;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
