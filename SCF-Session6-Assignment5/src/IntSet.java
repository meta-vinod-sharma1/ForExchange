
/**
 * @author LENOVO
 * @date 20/07/2019
 */
public final class IntSet {
	private final int[] intSetArray;
	private final int intSetArrayLength;
	
	

	/**
	 * 
	 */
	public IntSet(int[] inputArray, int countIndex){
		this.intSetArray = inputArray;
		this.intSetArrayLength = countIndex;
		
	}
	
	public boolean isMember(int checkNumber){
		boolean flag = false;
		for(int index = 0; index<intSetArrayLength; index++){
			if(intSetArray[index]== checkNumber){
				flag = true;
				break;
			}
		}
		return flag;		
	}
	public int size(){
		return intSetArray.length;
	}
	public boolean isSubSet(IntSet intSubSetObj){
		boolean flag = false;
		for(int subSetIndex=0; subSetIndex<intSubSetObj.intSetArray.length;subSetIndex++){
			flag = false;
			for(int intSetIndex=0; intSetIndex<intSetArrayLength; intSetIndex++){
				if(intSubSetObj.intSetArray[subSetIndex] == intSetArray[intSetIndex]){
					flag = true;
					break;
				}
			}
			if(flag==true){
				continue;
			}
			break;
		}
		
		return flag;
		
	}
	
	public int[] getComplement(){
		int[] complementSetArray = new int[1001 - intSetArrayLength];
		int tempIndex = 0;
		for(int index=0; index<=1000; index++){
			if(isMember(index)){
				continue;
			}else{
				complementSetArray[tempIndex++] = index;
			}
		}
		return complementSetArray;
	}
	
	public int[] union(IntSet s1, IntSet s2){
		int unionSetArray[] = new int[s1.intSetArray.length+s2.intSetArray.length];
		int newCountIndex = 0;
		for(int index=0; index<=1000; index++){
			if(s1.isMember(index) || s2.isMember(index)){
				unionSetArray[newCountIndex++] = index;
			}else{
				continue;
			}
		}
		return unionSetArray;
		
	}
	
}
