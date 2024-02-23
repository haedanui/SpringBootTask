package com.nhnacademy.edu.taskapi.domain;

import lombok.Data;

@Data
public class ResultResponse {
    private String result;

    public ResultResponse(String result) {
        this.result = result;
    }
}
