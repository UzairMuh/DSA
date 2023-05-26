                                " This code is BFS Approacht to find the paths(from root to leaf nodes) in BST(as well as in binary tree). This code traverse the BST in level by
                                " level
                                  
public static void findPathsBFS(Exp1.Node root)
	{
		if (root == null)
		{
			return;
		}
		Queue<Exp1.Node> queue = new LinkedList<>();
		Queue<ArrayList<Integer>> pathQueue = new LinkedList<>();
		queue.add(root);
		pathQueue.add(new ArrayList<>());
		
		while(!queue.isEmpty())
		{
			Exp1.Node node = queue.poll();
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
