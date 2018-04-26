package com.example.demo.bindingModel;


import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class CategoryBindingModel {

    @NotNull
    private String name;
    @NotNull
    private MultipartFile multipartFile;


    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
