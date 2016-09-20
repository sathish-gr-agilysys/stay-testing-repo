package com.agilysys.pms.account.model;

import java.util.List;

public class ViewFolioResponse {

    private int totalElements;
    private int totalPages;
    private int start;
    private int end;
    private List<FolioViewLineItem> content;

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<FolioViewLineItem> getContent() {
        return content;
    }

    public void setContent(List<FolioViewLineItem> content) {
        this.content = content;
    }
}
