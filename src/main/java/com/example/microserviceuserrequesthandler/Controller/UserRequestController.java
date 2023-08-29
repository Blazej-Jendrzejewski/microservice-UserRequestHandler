package com.example.microserviceuserrequesthandler.Controller;

import com.example.microserviceuserrequesthandler.Model.ErrorResponse;
import com.example.microserviceuserrequesthandler.Model.RepoInfo;
import com.example.microserviceuserrequesthandler.Service.UserRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserRequestController {

    @Autowired
    private UserRequestService userRequestService;

    @GetMapping("/api/user/repos/{username}")
    public ResponseEntity<Object> getRepos(@PathVariable String username){
        try {
            List<RepoInfo> repos = userRequestService.getUserRepositories(username);
            return ResponseEntity.ok(repos);
        } catch (ResponseStatusException e) {
            ErrorResponse error = new ErrorResponse(e.getStatusCode().value(), e.getBody().getTitle());
            return ResponseEntity.status(error.getStatus()).body(error);
        }
    }
}
