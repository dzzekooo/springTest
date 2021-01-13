package com.appsdeveloperblog.app.ui.controller;

import com.appsdeveloperblog.app.ui.model.response.Node;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("job") //http:localhost:8080/users
public class JobController {

    Map<Integer, Node> jobMap = new HashMap<Integer,Node>();
    Map<Integer, Node> valMap = new HashMap<Integer,Node>();
    Node head;

    @GetMapping(path="/add")
    public ResponseEntity<String> addJob(@RequestParam(value="value") int value, @RequestParam(value="jobid") int jobid) {
        Node newNode = new Node(jobid, value, null, null);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            Node prev = head;
            while(temp!= null) {
                if (temp.value >= value) {
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
            if(temp!=null) {
                prev.next = newNode;
                newNode.next = temp;
                temp.prev = newNode;
            } else {
                prev.next = newNode;
                newNode.prev = prev;
            }
        }
        valMap.put(value, newNode);
        jobMap.put(jobid, newNode);
        return ResponseEntity.status(HttpStatus.OK)
                .body("ok ");
    }

    @GetMapping(path="/all")
    public ResponseEntity getAll(@RequestParam(value="startValue") int startValue) {
        Node temp = valMap.get(startValue);
        List list = new ArrayList<>();
        while(temp!=null) {
            list.add(temp.jobId);
            temp = temp.next;
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(path="/remove")
    public ResponseEntity removeJob(@RequestParam(value="jobId") int jobid) {
        Node temp = jobMap.get(jobid);
        if(temp.prev !=null) {
            temp.prev.next = temp.next;
        }
        if(temp.next != null) {
            temp.next.prev = temp.prev;
        }
        temp = null;
        return ResponseEntity.status(HttpStatus.OK)
                .body("ok ");
    }

}
