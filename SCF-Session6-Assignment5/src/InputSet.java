import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author LENOVO
 *
 */
public class InputSet{
	Scanner inputObj = new Scanner(System.in);
	public IntSet setIntSetArray(){
		IntSet inputIntSet = null;
		try{
			System.out.println("Please Enter Array Size for Set");
			int sizeArray = inputObj.nextInt();
			if(sizeArray < 1){
				System.out.println("Wrong input !! Size can be only Positive integer");
				setIntSetArray();
			}else{
				int inputArray[] = new int[sizeArray];
				for(int index=0; index<sizeArray; ){
					try{
						System.out.println("Enter integer[" + (index+1) + "] :");
						int enterNumber = inputObj.nextInt();
						if(0<= enterNumber && enterNumber <=1000){
							if(!enterNumberInArray(inputArray,index+1,enterNumber)){
								inputArray[index] = enterNumber;
								index++;
							}else{
								System.out.println("--------------------------------------------------------");
								System.out.println("Warning : Oops !! You are not allowed to enter value again which in the Set");
								System.out.println("--------------------------------------------------------");
							}
						}else{
							System.out.println("--------------------------------------------------------");
							System.out.println("Warning : Please enter number in range 0 - 1000 !! Try Again");
							System.out.println("--------------------------------------------------------");
						}
					}catch(InputMismatchException e){
						System.out.println("--------------------------------------------------------");
						System.out.println("Warning : Please enter only integer value !! Try Again");
						System.out.println("--------------------------------------------------------");
						inputObj.nextLine();
					}
				}
				inputIntSet = new IntSet(inputArray, sizeArray);
			}
		}catch(InputMismatchException e){
			System.out.println("--------------------------------------------------------");
			System.out.println("Warning : Please enter only integer value !! Try Again");
			System.out.println("--------------------------------------------------------");
			inputObj.nextLine();
			setIntSetArray();
		}
		return inputIntSet;
	}
	
	public boolean enterNumberInArray(int[] inputArray, int size, int enterNumber){
		if(size==1){
			return false;
		}
		for(int index=0; index<size; index++){
			if(inputArray[index]== enterNumber){
				return true;
			}else{
				continue;
			}
		}
		return false;
	}

}
