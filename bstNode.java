
public class bstNode{	
   public String item;
   public bstNode left;
	public bstNode right;
   
   public bstNode(String str){
     item = str;
     left = null;
     right = null;
   }
	
   public bstNode(String str, bstNode l, bstNode r){
     item = str;
     left = l;
     right = r;
   }
}