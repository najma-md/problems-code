package problem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotateArr {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int d = 10;
        List<Integer> result = rotateLeft(d, arr);
        System.out.println(result);
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
          int inputArrLength=arr.size();
    int[] returnArr=new int[inputArrLength];
    int newStrtIndex=inputArrLength-(d%inputArrLength);
    
    newStrtIndex=newStrtIndex==inputArrLength?0:newStrtIndex;
    
    for(int i=0;i<inputArrLength;i++)
    {        
        returnArr[newStrtIndex]=arr.get(i);
        newStrtIndex+=1;
        if(newStrtIndex==inputArrLength) newStrtIndex=0;
    }

    return Arrays.stream(returnArr).boxed().collect(Collectors.toList());
    }

}
