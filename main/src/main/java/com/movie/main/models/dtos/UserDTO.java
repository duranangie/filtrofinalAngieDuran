package com.movie.main.models.dtos;

public class UserDTO {
    private Integer id;
    private String username;
    private String encryptedPass;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEncryptedPass() {
        return encryptedPass;
    }
    public void setEncryptedPass(String encryptedPass) {
        this.encryptedPass = encryptedPass;
    }

    


}
