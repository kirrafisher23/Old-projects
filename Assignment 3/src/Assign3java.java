import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int key;

	/*
	 * Node left; Node right;
	 */

	ArrayList<Node> children = new ArrayList<Node>();

	// level order
	int data;

	public Node(int item) {
		this.key = item;
		this.data = item;
	}

}

class BinaryTree {

	Node root;
	boolean isBinary;

	BinaryTree() {
		this.root = null;
		this.isBinary = true;
	}

	void printInorder(Node node) {
		if (node == null) {
			return;
		}

		// recur on left child first
		printInorder(node.children.get(0));

		System.out.print(node.key + " ");

		// recur on right
		printInorder(node.children.get(1));
	}

	void printInorder() {
		if (!isBinary) {
			System.out.println("Not a binary tree");
			return;
		}
		printInorder(root);
	}

	void printPreorder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.key + " ");
		for (int i = 0; i < node.children.size(); i++) {
			printPreorder(node.children.get(i));
		}

	}

	void printPreorder() {
		printPreorder(root);
	}

	void printPostorder(Node node) {
		if (node == null) {
			return;
		}

		for (int i = 0; i < node.children.size(); i++) {
			printPostorder(node.children.get(i));
		}
		System.out.print(node.key + " ");

	}

	void printPostorder() {
		printPostorder(root);
	}

	void printLevelOrder() {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			for (int i = 0; i < tempNode.children.size(); i++) {
				queue.add(tempNode.children.get(i));
			}

		}

	}

	Node findNode(int data) {
		if (root == null) {
			return null;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			if (data == tempNode.data) {
				return tempNode;
			}

			for (int i = 0; i < tempNode.children.size(); i++) {
				queue.add(tempNode.children.get(i));
			}

		}
		return null;
	}

}

public class Assign3java {

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();

		fileRead(binaryTree);

		System.out.println("Pre-order traversal:");
		binaryTree.printPreorder();
		System.out.println();
		System.out.println();
		System.out.println("Post-order traversal:");
		binaryTree.printPostorder();
		System.out.println();
		System.out.println();
		System.out.println("Inorder traversal:");
		binaryTree.printInorder();
		System.out.println();
		System.out.println();
		System.out.println("BFS traversal:");
		binaryTree.printLevelOrder();
		System.out.println();

	}

	public static void fileRead(BinaryTree tree) {

		try {
			Scanner treeFile = new Scanner(new File("tree.txt"));

			while (treeFile.hasNextLine()) {

				String line = treeFile.nextLine();

				String[] lineSplit = line.split(" ");

				int[] data = new int[lineSplit.length];
				if (data.length > 3) {
					tree.isBinary = false;
				}
				for (int i = 0; i < lineSplit.length; i++) {

					data[i] = Integer.parseInt(lineSplit[i]);

				}
				int parentNum = data[0];
				Node parent = tree.findNode(parentNum);

				// not sure if parent was null!!!!!

				if (parent == null) {
					parent = new Node(parentNum);
					if (tree.root == null) {
						tree.root = parent;
					} else {
						parent.children.add(tree.root);
						tree.root = parent;
					}

				}

				for (int i = 1; i < data.length; i++) {

					Node child = new Node(data[i]);
					parent.children.add(child);

				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}

	}

}
