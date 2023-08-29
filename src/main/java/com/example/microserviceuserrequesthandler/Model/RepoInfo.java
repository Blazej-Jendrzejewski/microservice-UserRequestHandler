package com.example.microserviceuserrequesthandler.Model;

import java.util.List;

public class RepoInfo {

    private String repositoryName;
    private String ownerLogin;
    private List<BranchInfoDTO> branches;

    public RepoInfo() {
    }

    public RepoInfo(String repositoryName, String ownerLogin, List<BranchInfoDTO> branches) {
        this.repositoryName = repositoryName;
        this.ownerLogin = ownerLogin;
        this.branches = branches;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public List<BranchInfoDTO> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchInfoDTO> branches) {
        this.branches = branches;
    }
}
