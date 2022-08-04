package com.company;

public class PaperSlip {
    private int rank;
    private int number;

    public PaperSlip(int rank, int number) {
        this.rank = rank;
        this.number = number;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
