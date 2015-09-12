import java.util.Scanner;

class SnakeMatrix {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int i, j,
    		inputNumber,
    	    step,
    	    startValue,
    	    startIndex,
    	    lastIndex,
    	    circleCount;
    	
    	System.out.print("Enter an integer: ");
    	
    	if(sc.hasNextInt()) {
    		inputNumber = sc.nextInt();
            int[][] resultMatrix = new int[inputNumber][inputNumber];

            circleCount = (int)Math.ceil((double)inputNumber / 2);
            
            step = 1;
            startValue = 0;
            startIndex = 0;
            while (step <= circleCount) {
            	lastIndex = inputNumber - startIndex;
            	
            	// Fill the top line of the array
            	for (i = startIndex; i < lastIndex; i++) {
            		if (resultMatrix[startIndex][i] == 0) {
	            		resultMatrix[startIndex][i] = startValue + 1;
	            	}
            		startValue++;
            	}
            	
            	// Fill the right line of the array
            	for (i = startIndex + 1; i < lastIndex; i++) {
            		if (resultMatrix[i][lastIndex-1] == 0) {
	            		resultMatrix[i][lastIndex-1] = resultMatrix[i-1][lastIndex-1] + 1;
	            	}
            	}
            	
            	// Fill the bottom line of the array
            	for (i = lastIndex - 2; i >= startIndex; i--) {
            		if (resultMatrix[lastIndex-1][i] == 0) {
	            		resultMatrix[lastIndex-1][i] = resultMatrix[lastIndex-1][i+1] + 1;
	            	}
            	}
            	
            	// Fill the left line of the array
            	for (i = lastIndex - 1; i > startIndex; i--) {
            		if (resultMatrix[i][startIndex] == 0) {
	            		resultMatrix[i][startIndex] = resultMatrix[i+1][startIndex] + 1;
	            	}
            	}
            	
            	if (circleCount > 1) {
	            	startValue = resultMatrix[startIndex+1][startIndex];
            	}
		        startIndex++;
		        step++;
            }
            
            // Print the array
            for( i = 0; i < inputNumber; i++ ) {
            	for( j = 0; j < inputNumber; j++ ) {
            		System.out.print(resultMatrix[i][j] + " ");
            		if (resultMatrix[i][j] < 10) {
            			System.out.print(" ");            			
            		}
            	}
            	System.out.println("");
            }
        } else {
            System.out.println("Number you entered is not an integer.");
        }
    	sc.close();
    }
}