                                                                " These both codes uses 'DFS'(recursive) approach to find the paths(from root to leaf). "
" First method "
                " This algorithm is used to find the paths from root to leafs node in BST.The number of paths depends upon number of leafs, if leaps nodes are three, than the paths will also be three. 
                " This method doesn't consume alot of memory(may be,Not Sure!), as in each recusive call we pass the same 'path', unlike in the 'second method(line no:30)' we pass a new 'ArrayList' in each recursive call, which tracks each paths seperatly.
                                                                   
public static void findPaths(Node root, ArrayList<Integer> path)			  
	{																			                                	
		if(root == null)               												                        // This will be executed if either the left or right child of previous recursive call's root is null. It does executes for 'root' node as well.
		{
			return;
		}
		path.add(root.data);                                                          // adds the current Node's data.
		if(root.left == null && root.right == null)									                  // Here we have used the concept of preOrder traversal.
    {  
			System.out.println(path);
		}
		else
		{
			findPaths(root.left,path);
			findPaths(root.right,path);
		}
		path.remove(path.size()-1);                                                 // It removes the last element from the path, when backTracking(backtracking happens when we find one of the path, means when we are in the leaf node, we have to backtrack to the leaf's parent node). This statement is executed, when have printed the path, means when this ' if(root.left == null && root.right == null)	' statement is already executed. 
	}
public static void main(String args[])
{
  findPaths(rootNode,new ArrrayList<>());                                         // Passing a root node and an empty ArrayList.
}
                                                              "  <------------->  "
	
" Second method "
                  " This code also uses the 'DFS' approach, the only difference in this version is that, it uses new 'ArrayList' in each 'recursive call', This way we don't have to remove the last element. "
                                                                
	public static void findPaths2( root, ArrayList<Integer> path)         
	{ 
		if(root == null )															                                // This statements only executes for the root case, means when there exists no tree. unlike it above method(findPaths), Which we have discussed there.
		{
			return;
		}
		path.add(root.data);
		if(root.left == null && root.right == null)  								                 // When this conditional statement executes, the below two conditional statements will not be executed.
		{	
			System.out.println(path	);
		}
		if(root.left != null)														                             // There is no need to explicitly define the conditions,this and the below one(line no:45), we could just simply put the in 'else' conditional statement, as we do in the previous approach'findPaths'.
		{
			findPaths2(root.left , new ArrayList<>(path));                             // Here we are passing a new 'ArrayList'(and it passes the new ArrayList in each recursive call,discussed on line no:31 and Line no:4), and we have passed the current 'path' as an argument to it, so the new 'ArrayList' is referencing to the current 'path'.
		}
		if(root.right != null)
		{
			findPaths2(root.right, new ArrayList<>(path));
		}
	}
  public static void main(String args[])
  {
    findPaths(rootNode,new ArrrayList<>());                                       // Passing a root node and an empty ArrayList.
  }
   
