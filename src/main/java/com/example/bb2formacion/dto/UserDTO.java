package com.example.bb2formacion.dto;

public class UserDTO {

    private Long id;
    private Integer userCode;
    private String name;
    private String email;
    private String password;

    public UserDTO(Long id, Integer userCode,String name, String email, String password) {
        this.id = id;
        this.userCode = userCode;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDTO(){

    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
