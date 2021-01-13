package com.appsdeveloperblog.app.ui.model.response;


public class Node {
    public Node next;
    public int jobId;
    public int value;
    public Node prev;

    public Node(int jobId, int value, Node prev, Node next) {
        this.jobId = jobId;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
