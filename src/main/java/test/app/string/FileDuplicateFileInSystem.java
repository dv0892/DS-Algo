package test.app.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDuplicateFileInSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<String>> findDuplicate(String[] paths) {
        
        Map<String,List<String>> map = new HashMap<>();
        
        for ( String path : paths ) {
            String[] dirInfo = path.split(" ");
            String dir = dirInfo[0]+"/";
            
            for( int i=1 ;i<dirInfo.length;i++){
                int indexOf = dirInfo[i].indexOf("(");
                String fileName = dirInfo[i].substring(0,indexOf);
                String fileContent = dirInfo[i].substring(indexOf+1,dirInfo[i].length()-1);
                
                map.putIfAbsent(fileContent, new ArrayList<>());
                map.get(fileContent).add(dir+fileName);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for( String key : map.keySet()){
            if( map.get(key).size() > 1 ){
                ans.add( map.get(key) );
            }
        }
        
        return ans;
    }

}
