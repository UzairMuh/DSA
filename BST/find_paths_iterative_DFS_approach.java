  " This is an 'iterative approach to find the paths in BST(as well as in Binary tree), through 'DFS(depth first search) approach', this first covers the left subtree an than the right subtree."
public static void findPathsIterative(Node root)								
	{
	    if(root == null)									        // This will be executed if BST(binary search tree) doesn't exist at all.
	    {
		return;
	    }
	    ArrayList<Node> nodeStack = new ArrayList<>();                 		         // This will create an ArrayList with elements as node's type. It is  use to track the node in which we are. This will give priority to left mode side of the node, if this ' if (node.right != null)' is executed before the 'if(node.left != null)', even though right side's conditional statement comes first, but still the priority will be given to left most nodes(or in other words, priority will be given to left subtree).
	    ArrayList<ArrayList<Integer>> pathStack = new ArrayList<>();             			 // This is used to create a nested ArrayList with Integer as its dataType. It is use to Track the path.
	
	    nodeStack.add(root);								         // Use to add the root node. the rest of the nodes will be added to nodeStack in the while loop, depends on the conditional statements' if (node.right != null) ,   if(node.left != null) '
	    ArrayList<Integer> initialPath = new ArrayList<>();                      			 // The 'initialPath' works as 'newPath' in the conditional statements but this ArrayList only work for the 'root' Node.
	    initialPath.add(root.data);									 // It is use to track the path of the 'root' node, suppose there exist only root in the BST, so this will track the path as well which is actually one.
	    pathStack.add(initialPath);
	
	    while(!nodeStack.isEmpty())									 // This will execute number of nodes' time, suppose if BST consists of 10 nodes, it will executed 10 times.
	    {
		   Node node = nodeStack.remove(nodeStack.size()-1);      				 // These two lines of statements will create the new 'node' and the new 'path' in each iteration, the ones which are created in the previous iteration will collected by JVM garbage collector.(continue from the next line) 
		   ArrayList<Integer> path = pathStack.remove(pathStack.size()-1);   		   	 // This consumes more memory, so we should rather declare them outside of the loop, this way  in each iteration the same ' node ' an the same ' path ' will get updated.when we declare them outside, we must have to initialize them as well, the same way which we do here.
		
		   if (node.left == null && node.right == null)						 // If this conditional statements will be executed, than the below two conditional statements will not be executed.
		   {
			   System.out.println(path);
		   }
		   if (node.right != null)								// As this conditional statement is written above the this ' if(node.left != null) ' conditional statement, it means the priority will be given to left most side(left subtree) fast, even though this statement shows that the priority will be given to 'right' side,as this conditional statements states that.
		   {
			   ArrayList<Integer> newPath = new ArrayList<>(path);			        // it creates 'newPath' ArrayList in each iteration, Here we copyies the elements of 'path' to 'newPath, so the 'newPath' is referencing to the current path in which we are.The ones which were created in the previous iteration, will be collected by 'JVM garbage collector'.
			   newPath.add(node.right.data);						// Here we updates the 'newPath', and then will pass it to the 'pathStack' in below line(this line +1 ), so that we store current path.
			   nodeStack.add(node.right);							// It will add the current node to nodeStack, so that the 'while' loop executes for each node.
          pathStack.add(newPath);								        // This will add the 'newPath' to pathStack, as we discussed in above line(this line - 1).
		   }
		   if(node.left != null)
		   {
			   ArrayList<Integer> newPath = new ArrayList<>(path);
			   newPath.add(node.left.data);
			   nodeStack.add(node.left);
			   pathStack.add(newPath);
		   }
	     }
	}
