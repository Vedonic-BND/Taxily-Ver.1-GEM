package com.example.taxilyver1;

import android.widget.TextView;

public class Data {
    public String qr;

    public Data(TextView qr){

    }

    public Data(String qr){
        this.qr = qr;
    }

    public String getQr(){
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }


}
