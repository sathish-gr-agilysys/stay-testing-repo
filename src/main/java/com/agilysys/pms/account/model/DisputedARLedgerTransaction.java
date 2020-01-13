package com.agilysys.pms.account.model;

import com.agilysys.pms.comment.model.Comment;

public class DisputedARLedgerTransaction {

    private String itemId;
    private boolean dispute;
    private Comment comment;
    private String id;

    public DisputedARLedgerTransaction() { }

    public DisputedARLedgerTransaction(String itemId, boolean dispute, Comment comment) {
        this.itemId = itemId;
        this.dispute = dispute;
        this.comment = comment;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public boolean isDispute() {
        return dispute;
    }

    public void setDispute(boolean dispute) {
        this.dispute = dispute;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
