                                " This code is BFS Approacht to find the paths(from root to leaf nodes) in BST(as well as in binary tree). This code traverse the BST in level by
                                " level, it won't first print(or find) the left most path in the BST, as DFS approach did, but rather it will print that path which comes first in 
				" the level wise, whenever the leaf node come in the level, it will printed as the first path. This property lets this code to print the paths in an 
			        " 'ascending order', at first there will be the shortest path printed, and at last there will be the longest path printed.
                                  
public static void findPathsBFS(Node root)
	{
		if (root == null)
		{
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		Queue<ArrayList<Integer>> pathQueue = new LinkedList<>();
		queue.add(root);
		pathQueue.add(new ArrayList<>());
		
		while(!queue.isEmpty())
		{
			Node node = queue.poll();
			ArrayList<Integer> path = pathQueue.poll();
			path.add(node.data);
			
			if(node.left == null && node.right == null)
			{
				System.out.println("Path " + path);	
			}
			
			if(node.left != null)
			{
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
