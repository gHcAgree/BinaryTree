package tree;

import java.util.*;

public class BinaryTree {
	public BiNode root;
	
	public void preOrder() {
		Stack<BiNode> stk = new Stack<BiNode>();
		stk.push(root);
		while(!stk.empty()) {
			BiNode tmp = stk.pop();
			tmp.visit();
			if(tmp.right!=null) stk.push(tmp.right);
			if(tmp.left!=null) stk.push(tmp.left);
		}
		System.out.println();
	}
	
	public void inOrder() {
		Stack<BiNode> stk = new Stack<BiNode>();
		stk.push(root);
		while(!stk.empty()) {
			BiNode tmp = stk.peek();
			while(tmp!=null) {
				tmp = tmp.left;
				stk.push(tmp);
			}
			stk.pop();   //pop an empty node
			if(!stk.empty()) {
				tmp = stk.pop();
				tmp.visit();
				stk.push(tmp.right);
			}
		}
		System.out.println();
	}
	
	public void postOrder() {
		Stack<BiNode> stk = new Stack<BiNode>();
		BiNode lastVisited = null;
		stk.push(root);
		while(!stk.empty()) {
			BiNode tmp = stk.peek();
			while(tmp!=null) {
				tmp = tmp.left;
				stk.push(tmp);
			}
			stk.pop();
			
			while(!stk.empty()) {
				tmp = stk.peek();
				if(tmp.right==null||tmp.right.equals(lastVisited)) {
					tmp.visit();
					lastVisited = tmp;
					stk.pop();
				}
				else {
					stk.push(tmp.right);
					break;
				}
			}
		}
		System.out.println();
	}
	
	public void levelOrder() {
		ArrayList<BiNode> queue = new ArrayList<BiNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BiNode tmp = queue.remove(0);
			if(tmp!=null) {
				tmp.visit();
				queue.add(tmp.left);
				queue.add(tmp.right);
			}
		}
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
		/**
		 *          A
		 *     B
		 *  C     D
		 *      E   F
		 *        G 
		 * When traversing a tree, every node should always be visited as a root of a tree!!!
		 * preOrder:   A B C D E G F
		 * inOrder:    C B E G D F A
		 * postOrder:  C G E F D B A
		 * levelOrder: A B C D E F G
		 */
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
		
		//operations
		btree.preOrder();
		btree.inOrder();
		btree.postOrder();
		btree.levelOrder();
	}
}