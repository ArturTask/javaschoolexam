package com.tsystems.javaschool.tasks.subsequence;

import java.util.List;

public class Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {
        checkInput(x,y);
        //I decided to delete elem from x and y when we find the one we need(current elem from y matches the one from x) and to delete elem from y when not(when elem from x doesnt match the one from y)
        while(!y.isEmpty()){
            if(x.isEmpty())return true; //if all elems were before y ends
            if(y.get(0).equals(x.get(0))){
                x.remove(0);
                y.remove(0);
            }
            else {
                y.remove(0);
            }
        }

        if(x.isEmpty())return true; //if we reach the last elem from y and x matches y

        return false; //else
    }
    private void checkInput(List x, List y){ //just check if one of args is null
        if(y==null || x==null)throw new IllegalArgumentException("One of args is null");
    }
}
