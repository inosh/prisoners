package com.company;

import java.util.*;

public class Program {
    private Map<Integer, Prisoner> prisonersMap = new HashMap<Integer, Prisoner> ();
    private Map<Integer, PaperSlip> paperSlipsMap = new HashMap<Integer, PaperSlip> ();

    public void generatePrisonersMap () {
        Prisoner prisoner = null;
        for (int i = 1; i < 101; i++) {
            prisoner = new Prisoner(i);
            prisonersMap.put(i, prisoner);
        }
    }

    public void generatePaperSlipsMap () {
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);
        PaperSlip paperSlip = null;
        for (int i = 1; i < 101; i++) {
            paperSlip = new PaperSlip(i, numList.get(i-1));
            paperSlipsMap.put(i, paperSlip);
        }
    }

    public boolean startProcess () {
        boolean isFailed = false;
        for (int i = 1; i < 101; i++) {
//            System.out.println("#################Prisoner " + i);
            boolean isFound = navigationProcess(i);
            if (!isFound) {
//                System.out.println("****** Failed at Prisoner " + i);
                isFailed = true;
                break;
            }
        }
        return !isFailed;
    }

    public boolean navigationProcess (int i) {
        int navigationCount = 0;
        boolean isFound = false;
        int navigateNumber = i;
        do {
            navigationCount++;
            int number = paperSlipsMap.get(navigateNumber).getNumber();
            if (number == i) {
                isFound = true;
            }
            navigateNumber = number;
        } while (navigationCount < 50 && !isFound);
        if (isFound) {
//            System.out.println("$$$$$Prisoner " + i + " Found. Count " + navigationCount);
        } else {
//            System.out.println("^^^^^Prisoner " + i + " Not Found. Count " + navigationCount);
        }
        return isFound;
    }
}
