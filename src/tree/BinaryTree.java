package tree;

import java.util.Stack;

public class BinaryTree {
	public BiNode root;
	
	public void preOrder() {
		Stack<BiNode> stk = new Stack<BiNode>();
	}
	
	public void inOrder() {
		
	}
	
	public void postOrder() {
		
	}
}

class BiNode {
	public Object key;
	public BiNode left,right;
	
	public BiNode(Object k) {
		key = k;
		left = null;    right = null;
	}
	
	public void visit() {
		System.out.print(key+" ");
	}
}

class Main {
	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree();
		BiNode[] nodes = new BiNode[7];
		nodes[0] = new BiNode("A");
		nodes[1] = new BiNode("B");
		nodes[2] = new BiNode("C");
		nodes[3] = new BiNode("D");
		nodes[4] = new BiNode("E");
		nodes[5] = new BiNode("F");
		nodes[6] = new BiNode("G");
		
		btree.root = nodes[0];
		nodes[0].left = nodes[1];
		nodes[1].left = nodes[2];
		nodes[1].right = nodes[3];
		nodes[3].left = nodes[4];
		nodes[3].right = nodes[5];
		nodes[4].right = nodes[6];
		
	}
}