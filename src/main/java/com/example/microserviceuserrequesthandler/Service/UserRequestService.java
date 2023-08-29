package com.example.microserviceuserrequesthandler.Service;

import com.example.microserviceuserrequesthandler.Model.BranchInfoDTO;
import com.example.microserviceuserrequesthandler.Model.RepoDTO;
import com.example.microserviceuserrequesthandler.Model.RepoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserRequestService {

    private final RestTemplate restTemplate;

    @Autowired
    public UserRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${githubapi.service.url}")
    private String githubApiServiceUrl;

    public List<RepoInfo> getUserRepositories(String username) throws HttpClientErrorException {
        try {
            RepoDTO[] repoArray = restTemplate.getForObject(githubApiServiceUrl + "/api/github/repos/" + username, RepoDTO[].class);
            List<RepoDTO> repos = Arrays.asList(repoArray);

            List<RepoInfo> repoInfos = new ArrayList<>();

            for (RepoDTO repo : repos) {
                if (!repo.isFork()) {
                    BranchInfoDTO[] branchesArray = restTemplate.getForObject(
                            githubApiServiceUrl + "/api/github/repos/" + username + "/" + repo.getName() + "/branches", BranchInfoDTO[].class);
                    List<BranchInfoDTO> branches = Arrays.asList(branchesArray);
                    repoInfos.add(new RepoInfo(repo.getName(), repo.getOwnerLogin(), branches));
                }
            }
            return repoInfos;

        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getResponseBodyAsString());
        }
    }
}
