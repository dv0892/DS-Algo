package test.app.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
		String searchWord =  "usepzmuywcnicnglsohczkvmbmtfrkwsvbrmbwvehbzpqmiznwvyurtnpwdglycydwgelnsulelgeiweaamsvqmhnxsrjtsgeylvfujgdjhailtpkbqzmzdtplqzoafsojdjrhoranjuxjuuigztefsifutmdazwqoxwaxxyetgumfbppuowtogpqxcmrvqloeutkppmflczgmspzskfdlxcjbadmucoiqjnjhtjcoczjfwccvmqwqslrbeewcesebdortkcsgjdpyhxlswqlzjacxltcaoirsdtzcxgnuouyvmflmyocfvqxkhpluuprdeuppnuwgucmjbjdbnksnriatirwbdrdzemfkomvahskcnonxvpxwmkomzurplzigdhrziuvkyjcynffykgvfbaunfeppmhwqaipycqrldnxqzgxtompwkedbfmbamghsmvxlqwrndxnincfpldzmuvoywvdxgkurahlrbhjahmanfhjrmalpdzfycyyfwrvocxvakfwxpxliyjxnvcfohwoogckjvppnhxpuameuiinjerlqwmtyoevrwtfhkzkdrtwgtbhttiqzawakkpemlkwfcvnsndvqpqvllbonbijrrujtmzfontnokkjadmsrjgogfnjmtghndneqotrqjfzkndjxulyslllnjmwqbqqjtqegykbnoodvfxmbmwuvdmcqivjoaedxkhrbqthxwezlsjexfifqgcktgftzkusjousanslifuhqyutopzrhnlohvszpntofhyxlvdvtrisngpqiegbkptnebakphswxbdvftpaxkoabebceoeoqbbwlbhvthbuqlbwghpxjhwamanrzfuaqzfwsyenupkfpsvzafjsykksdzsczbdzqreyxgkbmmsqroubjwasqewazzppkjyromhorjslcjijizbhijyubivqryncoyahgftzcdjjysrsdikfwkxlvwclivpijgworgjoizn";
		System.out.println( new SearchSuggestionsSystem().suggestedProducts(products, searchWord));
	}
	
	public List<List<String>> suggestedProducts(String[] products, String searchWord ) {
        
		ProductTrie trie = new ProductTrie();
		for ( String product : products ) {
        	trie.addProduct(product);
        }
		
		
	    Arrays.sort(products);
	    
	    System.out.println( Arrays.toString(products) );
		
		List<List<String>> res = new ArrayList<>();
		for ( int i=1;i<= searchWord.length();i++){
            String str   = searchWord.substring(0,i);
		
            res.add( new ArrayList<>(trie.getSuggestions( str )) );
            
            binarySearch(products,str);
		}
		
		return res;
	}

	private int  binarySearch(String[] products, String str) {
		int s=0 , e = products.length-1;
		while( s < e ) {
			int mid = s + (e-s)/2;
			
			String p = products[mid];
			
			if ( p.startsWith(str) ) 
				e = mid  ;
			else if ( p.charAt(0) > str.charAt(0) )
				e = mid - 1;
			else
				s = mid + 1;
		}
		
		return s;
		
	}
}

class ProductTrie {
	
	TrieNode root;
    
    public ProductTrie() {
        root = new TrieNode();
    }
    
   public List<String> getSuggestions(String word) {
	   
		TrieNode prefix = prefix(word);
		
		List<String> suggestions = new ArrayList<>();
	    getSuggestions(prefix, word, 3, suggestions);
	    
	    return suggestions;
	}
   
   public int getSuggestions(TrieNode node , String word , int noOfsuggestions , List<String> suggestions) {
	   
	   if( node == null || noOfsuggestions == 0 )
		   return noOfsuggestions;
	   
	   if ( node.endOfWord ) {
		   suggestions.add(word);
		   noOfsuggestions--;
	   }
	   
	   for( char c='a' ; c<='z' ; c++   ){
		   noOfsuggestions = getSuggestions( node.getChildren(c) , word + c, noOfsuggestions, suggestions);
		   if ( noOfsuggestions == 0 ) 
			   break;
       }
	   
	   return noOfsuggestions;
		
	}
   
   public TrieNode prefix(String prefix) {
	   TrieNode curr = root;
	   
	   for ( int i=0;i<prefix.length();i++) {
       		TrieNode temp = curr.getChildren(prefix.charAt(i));
            if ( temp == null )
               return null;
            
            curr = temp;
       }
   
       return curr;
   }

   public void addProduct(String word) {
	   TrieNode curr = root;
        
        for ( int i=0;i<word.length();i++) {
        	TrieNode temp = curr.getChildren(word.charAt(i));
            if ( temp == null ){
                temp = new TrieNode();
                curr.setChildren(word.charAt(i),temp);
            } 
            curr = temp;
        }
        curr.endOfWord = true;
    }
}


