package com.soal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseGambar {
    @SerializedName("message")
    @Expose
    private ArrayList message;
    @SerializedName("status")
    @Expose
    private String status;

    public ResponseGambar(ArrayList message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage(int i) {
        return message.get(i).toString();
    }

    public int getLength() {
        return message.size();
    }
}
