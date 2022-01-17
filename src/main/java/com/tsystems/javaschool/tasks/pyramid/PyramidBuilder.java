package com.tsystems.javaschool.tasks.pyramid;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        //check if input is valid
        int numberOfZeros = 0;
        for (Object o:inputNumbers) {
            if (o==null){
                throw new CannotBuildPyramidException();
            }
            if(o.equals(Integer.valueOf(0)))numberOfZeros++;
        }
        if(numberOfZeros==inputNumbers.size())throw new CannotBuildPyramidException(); //if every num is zero

        int counter = 1;
        int i=2; //amount of stages to find just i in our output int[i][] AND amount of stages = amount of numbers on the last stage
        //in this loop we check if the amount of numbers given is correct and we CAN BUILD A PYRAMID we also get the information about how many stages are there in our output
        for (i=2;i<10000;i++){
            if(inputNumbers.size()==counter) {
                break;
            }
            if(inputNumbers.size()<counter){ //here we check if it is possible to build the pyramid with such amount of numbers given
                throw new CannotBuildPyramidException();
            }
            counter+=i;
        }

        int amountOfStages=i-1; //i-1 is current amount of stages and to count i in output we have to get sum of currAmount+currAmount-1 as we put our values (currAmount and zeros between them )
        int size = amountOfStages+amountOfStages-1; //size of our output array j int[][j]

        int pointer = 0; // pointer to pop our values from input
        Collections.sort(inputNumbers);
        int [][] ans = new int[amountOfStages][size];

        for (i=0;i<amountOfStages;i++){ //outer loop for stages
            //inner "loop" for each stage devided into 3 parts
            int j=0;
                int numberOfZeroesInTheEndAndBeginning = (size - (i+1) - i)/2; //we count number of zeroes here {***50304***} variable=3
                //first part with zeros
                for(int k=0;k<numberOfZeroesInTheEndAndBeginning;k++){
                    ans[i][j]=0;
                    j++;
                }
                //second part with actual numbers from input
                for(int k=0;k<i+1+i;k++){
                    if(k%2==0){

                        ans[i][j]=inputNumbers.get(pointer);
                        pointer++;
                    }
                    else ans[i][j]=0;
                    j++;
                }
                //third part with zeros
                for(int k=0;k<numberOfZeroesInTheEndAndBeginning;k++){
                    ans[i][j]=0;
                    j++;
                }
        }

        return ans;
    }


}
