package tree;

public class BinaryThreadTree {
	public BtNode root;
	public BtNode head;
	
	public void inOrderThreading() {
		head = new BtNode();
		head.lthread = false;
		head.rthread = true;
		head.right = head;
		
		if(root==null) head.left = head;
		else {
			head.left = root;
			BtNode prev = head;
			
			inThreading(root,prev);
			
			prev.rthread = true;
			prev.right = head;
			head.right = prev;
		}
	}
	
	private void inThreading(BtNode root, BtNode prev) {
		if(root!=null) {
			inThreading(root.left,prev);
			
			if(root.left==null) {
				root.lthread = true;
				root.left = prev;
			}
			if(prev.right==null) {
				prev.rthread = true;
				prev.right = root;
			}
			prev = root;
			
			inThreading(root.right,prev);
		}
	}
	
	public void inOrder() {
		if(root==null) return;
		
		BtNode tmp = head.left;
		while(tmp!=head) {
			while(!tmp.lthread) tmp = tmp.left;
			tmp.visit();
			System.out.println(tmp.rthread);
			while(tmp.rthread&&!tmp.right.equals(head)) {
				tmp = tmp.right;
				tmp.visit();
			}
			tmp = tmp.right;
		}
	}
}

class BtNode {
	Object key;
	BtNode left,right;
	boolean lthread,rthread;
	
	public BtNode() {
		this(null);
	}
	
	public BtNode(Object k) {
		key = k;
		left = null; right = null;
		lthread = false; rthread = false;
	}
	
	public void visit() {
		System.out.print(key+" ");
	}
}

class Main2 {
	public static void main(String[] args) {
		/**
		 *          A
		 *     B
		 *  C     D
		 *      E   F
		 *        G 
		 * When traversing a tree, every node should always be visited as a root of a tree!!!
		 * preOrder: A B C D E G F
		 * inOrder:  C B E G D F A
		 * postOrder:C G E F D B A
		 */
		BinaryThreadTree btree = new BinaryThreadTree();
		BtNode[] nodes = new BtNode[7];
		nodes[0] = new BtNode("A");
		nodes[1] = new BtNode("B");
		nodes[2] = new BtNode("C");
		nodes[3] = new BtNode("D");
		nodes[4] = new BtNode("E");
		nodes[5] = new BtNode("F");
		nodes[6] = new BtNode("G");
		
		btree.root = nodes[0];
		nodes[0].left  = nodes[1]; 
		nodes[1].left  = nodes[2]; 
		nodes[1].right = nodes[3]; 
		nodes[3].left  = nodes[4]; 
		nodes[3].right = nodes[5]; 
		nodes[4].right = nodes[6]; 
		
		btree.inOrderThreading();
		btree.inOrder();
	}
}