package test.app.math;

public class AddDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public int addDigits(int num) {
        
        if( num < 10)
            return num;
        
        int sum =  0;
        while( num > 0) {
            sum += (num%10);
            num /= 10;
        }
            
        return addDigits(sum);
    }

}
