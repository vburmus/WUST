package Comparators;

import Request.Request;

import java.util.Comparator;

public class CompareByCylinder implements Comparator<Request> {
    @Override
    public int compare(Request o1, Request o2) {
        return o1.getCylinderNumber()-o2.getCylinderNumber();
    }
}
