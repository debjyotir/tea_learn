class BinaryTree{
	BTNode root;
	class BTNode{
		int value;
		BTNode left,right;
		BTNode(int val,BTNode l,BTNode r){
			value=val;
			left=l;
			right=r;
		}
		BTNode(int val){
			value=val;
			left=right=null;
		}
	}

	int minDepth(BTNode node){
		if(node==null) return 0;
		else{
			return minimum(minDepth(node.left)+1,minDepth(node.right)+1);
		}
	}

	int minimum(int a,int b){
		if(a<b) return a;
		else return b;
	}
	BTNode newNode(int data){
		BTNode x = new BTNode(data);
		return x;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		BTNode root = bt.newNode(10);
		root.left= bt.newNode(1);
		root.right=bt.newNode(3);
		root.left.left= bt.newNode(5);
		root.left.right=bt.newNode(9);
		
		System.out.println(bt.minDepth(root));
	}

}