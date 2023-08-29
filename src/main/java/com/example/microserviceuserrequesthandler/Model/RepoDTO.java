package com.example.microserviceuserrequesthandler.Model;

public class RepoDTO {

    private String name;
    private String ownerLogin;
    private boolean fork;

    public RepoDTO() {
    }

    public RepoDTO(String name, String ownerLogin, boolean fork) {
        this.name = name;
        this.ownerLogin = ownerLogin;
        this.fork = fork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }
}
