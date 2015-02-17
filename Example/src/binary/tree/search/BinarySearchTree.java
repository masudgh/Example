package binary.tree.search;


public class BinarySearchTree {
    /** The tree root. */
    private BinaryNode root;

	public BinarySearchTree() {
		super();
		this.root=null;
	}
	 
	public BinarySearchTree(BinaryNode root) {
		super();
		this.root=root;
	}
	/**
	 * 
	 * @param x
	 */
	 public void insert( Comparable x )
	 {
	        root = insert( x, root );
     }
	 
	 /**
	  * 
	  * @param x
	  * @param t
	  * @return
	  */
	 private BinaryNode insert( Comparable x, BinaryNode t )
	    {
	      if( t == null )
	    	  t = new BinaryNode( x, null, null );
	      else if( x.compareTo( t.element ) < 0 )
	    	  t.left = insert( x, t.left );
	      else if( x.compareTo( t.element ) > 0 )
	    	  t.right = insert( x, t.right );
	      else
					;  // Duplicate; do nothing
	      return t;
	 }
	 
	 /**
	  * 
	  * @param x
	  */
	 public void remove( Comparable x )
	 {
	        root = remove( x, root );
	 }
	 
	 
	 /**
	  * 
	  * @param x
	  * @param t
	  * @return
	  */
	 private BinaryNode remove( Comparable x, BinaryNode t )
	 {
	        if( t == null )
	            return t;   // Item not found; do nothing
	        if( x.compareTo( t.element ) < 0 )
	            t.left = remove( x, t.left );
	        else if( x.compareTo( t.element ) > 0 )
	            t.right = remove( x, t.right );
	        else if( t.left != null && t.right != null ) // Two children
	        {
	            t.element = findMin( t.right ).element;
	            t.right = remove( t.element, t.right );
	        }
	        else
	            t = ( t.left != null ) ? t.left : t.right;
	        return t;
	 }
	 
	public Comparable findMin( )
    {
        return elementAt( findMin( root ) );
    }
	
	 private Comparable elementAt( BinaryNode t )
	 {
	        return t == null ? null : t.element;
	 }

	private BinaryNode findMin( BinaryNode t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }
	
	
	
	 public Comparable find( Comparable x )
	 {
	        return elementAt( find( x, root ) );
	 }
	 
	 private BinaryNode find( Comparable x, BinaryNode t )
	 {
	        if( t == null )
	            return null;
	        if( x.compareTo( t.element ) < 0 )
	            return find( x, t.left );
	        else if( x.compareTo( t.element ) > 0 )
	            return find( x, t.right );
	        else
	            return t;    // Match
	 }
	 
	/************
	 * PRINT tree
	 * @return
	 */
	public boolean isEmpty( )
    {
        return root == null;
    }
	public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }
	private void printTree( BinaryNode t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }
	
	public String toString( )
    {
        if( isEmpty( ) )
           return "Empty tree";
        else
        {
        	return toString( root );
        }
    }
	private String toString( BinaryNode t )
    {
		String str = "";
        if( t != null )
        {
        	
        	String leftStr= toString( t.left );
        	String rightStr= toString( t.right );
        	if(leftStr != ""  )
        		str=leftStr+",";
        	str+= t.element.toString();
        	if(rightStr!=""  )	
        		str+=","+rightStr;
        	
        }
        return str;
		
    }
	
	public int [] toArray(){
		 if( isEmpty( ) )
	         return null;
	     else
	         return toArray(root );
	}
	
	private int [] toArray(BinaryNode t){
		
		if(t!=null){
			int [] elements;
			String str=toString(t);
			String[] splitStr=str.split(",");
			elements= new int[splitStr.length];
			for(int i=0; i<splitStr.length;i++){
				elements[i]= Integer.valueOf(splitStr[i]);
			}
			return elements;
			
		}else
			return null;
		
	}
	
/*	private Comparable [] toArray(BinaryNode t){
		
		Comparable [] str= {};
        if( t != null )
        {
        	
        	Comparable[] leftStr= toArray( t.left );
        	Comparable [] rightStr= toArray( t.right );
        	if(leftStr){
        		str = new Comparable[leftStr.length+1];
        		strtoArray( t.left )+",";
        	}
        	str+= t.element.toArray();
        	if(rightStr!=""  )	
        		str+=","+toArray( t.right );
        	
        }
        return str;
		
	}*/
}
