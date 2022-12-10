package Comparators;

import Request.Request;

import java.util.Comparator;

public class CompareByDeadline implements Comparator<Request> {
    @Override
    public int compare(Request o1, Request o2) {
        return o1.getDeadline() - o2.getDeadline();
    }
}
