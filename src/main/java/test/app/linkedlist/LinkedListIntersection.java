package test.app.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedListIntersection {

	
	  /**
	   * Iterate through each line of input.
	   */
	  public static void main(String[] args) throws IOException {
	    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line = "a,q,r";
	    int index = -1;
	    Map<String,Node> nodesMap = new HashMap<>();
	    
	    while ((line != null ) ) {
	      System.out.println(line);
	        index = line.indexOf("->");
	        if( index > 0 ){
	          addNode(line.substring(0,index) , line.substring(index+2) , nodesMap);
	        } else{
	          checkNodeIntersection(line, nodesMap);
	        }
	    }
	  }


	private static void checkNodeIntersection(String line, Map<String, Node> nodesMap) {
		  Set<String> uniqueNodes = new HashSet<>();
		  
		  String[] nodes = line.split(",");
		  for ( String nodeId : nodes ) {
		    Node node = nodesMap.get(nodeId); 
		      if ( java.util.Objects.nonNull(node) && doLinkedListsIntersect( node , uniqueNodes )  ){
		    	  System.out.println("True");
		          return; 
		      } 
		  }
		  
		  System.out.println("False");
	}
	  
	  
	  public static boolean  doLinkedListsIntersect( Node node ,Set<String> uniqueNodes ){
	    
	    while( java.util.Objects.nonNull(node) ){
	      if( uniqueNodes.contains(node.id) )
	        return true;
	      
	      uniqueNodes.add(node.id);
	      node = node.next;
	    }
	    
	    return false;
	  }
	  
	  public static void addNode ( String source , String target , Map<String,Node> nodes ){
	    
	    Node srcNode = nodes.get(source);
	    Node tarNode = nodes.get(target);
	    
	    if( java.util.Objects.isNull(tarNode) ){
	      tarNode = new Node( target , null);
	      nodes.put(target,tarNode);
	    }
	    
	    
	    if( java.util.Objects.isNull(srcNode) ){
	      srcNode = new Node( source , tarNode);
	      nodes.put(source,srcNode);
	    } else {
	      srcNode.setNext(tarNode);
	    }
	    
	    
	  }
	  
	  
	}

	class Node { 
	  String id;
	  Node next;
	  
	  Node( String id , Node next ){
	    this.id = id;
	    this.next = next;
	  }
	  
	  public void setNext( Node next ){
	    this.next = next;
	  }
	  
	  public boolean equals( Node n ){
	    return this.id ==  n.id;
	  }
	  
	  
	}
