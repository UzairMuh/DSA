                 " This code is BFS Approacht to find the paths(from root to leaf nodes) in BST(as well as in binary tree).
			 
			 " -->  This code traverse the BST in level by level, it won't first print(or find) the left most path in the BST, as DFS approach did, but rather it 
			 "      will print that path which comes first in the level wise, whenever the leaf node come in the level, it will printed as the first path. 
			 " -->  This property lets this code to print the paths in an 'ascending order', at first there will be the shortest path printed, and at last there 
			 "      will be the longest path printed.
			 " -->  This version(BFS) of code, doesn't consume as much as the DFS-iterative one, there in each iteration if node has two children we had to create
			 "      two 'newPath' ArrayList<> in each iteration, but here we don't, we use the same 'pathQueue' throughout the code.I think this is because of the 
			 "	property of using Queue.
                                  
public static void findPathsBFS(Node root)
	{
		if (root == null)
		{
			System.out.println("Tree is empty:");
			return;
		}
		Queue<Node> queue = new LinkedList<>();						// Creating LinkedList-based-Queue, which stores Node data-type objects.
		Queue<ArrayList<Integer>> pathQueue = new LinkedList<>();			// Now creating a new LinkedList-based-Queue of ArrayList data-type, which trak the path.
		queue.add(root);								// Adding root to the Queue. it allows, the while() to be executed for the root node.
		pathQueue.add(new ArrayList<>());						// Adding Empty LinkedList<>, root doesn't have any path, because the path is calculated from the parend and root doesn't have that, in other words root itself is a path.
		
		while(!queue.isEmpty())								// Will be exeuted nodes' times. if the BST consists of 10 nodes, there will be 10 iteration as well.
		{
			Node node = queue.poll();						// gets the first element(head of the Queue) of the Queue.
			ArrayList<Integer> path = pathQueue.poll();				// GETS The first element, which is the current path in which we are, it doesn't include the node in which we are, it will be include the very next statement.
			path.add(node.data);							// Adds the current node to the current path.
			
			if(node.left == null && node.right == null)
			{
				System.out.println("Path " + path);	
			}
			
			if(node.left != null)							// Will give priority to the left side, means in each level, first the left side will be covered and than the right side,but this does'nt mean that it will print the left paths 
			{									// first in level wise, no it will print the path whenever the leaf node come in level wise, whether or not it existed in left side or right side. 
				queue.add(node.left);
				pathQueue.add(new ArrayList<>(path));	
			}
			
			if(node.right != null)
			{
				queue.add(node.right);
				pathQueue.add(new ArrayList<>(path));
			}
                 }		
	}
