package com.example.microserviceuserrequesthandler.Model;

public class BranchInfoDTO {

    private String name;
    private String lastCommitSha;

    public BranchInfoDTO() {
    }

    public BranchInfoDTO(String name, String lastCommitSha) {
        this.name = name;
        this.lastCommitSha = lastCommitSha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastCommitSha() {
        return lastCommitSha;
    }

    public void setLastCommitSha(String lastCommitSha) {
        this.lastCommitSha = lastCommitSha;
    }
}
