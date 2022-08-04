package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Program program = null;
        int successCount = 0;
        int loopCount = 1000000;
        for (int i = 1; i < loopCount + 1; i++) {
            program = new Program();
            program.generatePrisonersMap();
            program.generatePaperSlipsMap();
            boolean success = program.startProcess();
            if (success) {
                successCount++;
            }
        }
        double successPct = (double) successCount * 100/loopCount ;
        System.out.println("Success Count = " + successCount + ", Success PCT = " + successPct + "%");
    }
}
