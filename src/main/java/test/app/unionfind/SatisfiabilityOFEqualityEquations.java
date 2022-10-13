package test.app.unionfind;

import test.app.utils.DisJointSet;

public class SatisfiabilityOFEqualityEquations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean equationsPossible(String[] equations) {
        
		DisJointSet ds = new DisJointSet(26);
        
        for( String eq : equations ){
            
            char x = eq.charAt(0) , y = eq.charAt(3);
            String op = new String ( new char[]{eq.charAt(1),eq.charAt(2)} );
            
           if( op.equals("==") ) {
        	   ds.union(x-97, y-97);
           }
                
        }
        
        for( String eq : equations ){
            
            char x = eq.charAt(0) , y = eq.charAt(3);
            String op = new String ( new char[]{eq.charAt(1),eq.charAt(2)} );
            
           if( op.equals("!=") ) {
        	   if( ds.find(x) == ds.find(y) )
        		   return false;
           }
                
        }
        
        return true;
    }
    
    

}
