package com.example.binarytodecimal;

public class Operations {
    private String binary;
    private String decimal;
    private int result;

    public void Conversor_Decimal(){
        int i = Integer.parseInt(getDecimal());
        try {
            setBinary(Integer.toBinaryString(i));
        }catch (Exception e) {
            System.out.println("Error. Do not type letters.");
        }
    }

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }

    public String getDecimal() {
        return decimal;
    }

    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
