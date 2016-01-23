class BinaryTree{
    private Node root;

    public void add(int newData){
        Node newNode = new Node(newData);

        Node temp = root;
        Node parent;
        if(temp == null){
            root = newNode;
        }else{
            while(true){
                parent = temp;
                if(newData < temp.data){
                    temp = temp.leftChild;
                    if(temp == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else{
                    temp = temp.rightChild;
                    if(temp == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }

    public void preOrderTraversal(Node temp){
        if(temp != null){
            preOrderTraversal(temp.leftChild);
            System.out.println(temp);
            preOrderTraversal(temp.rightChild);
        }
    }

    public void inOrederTraversal(Node temp){
        if(temp != null){
            System.out.println(temp);
            inOrederTraversal(temp.leftChild);
            inOrederTraversal(temp.rightChild);
        }
    }

    public void postOrederTraversal(Node temp){
        if(temp != null){
            postOrederTraversal(temp.leftChild);
            postOrederTraversal(temp.rightChild);
            System.out.println(temp);
        }
    }

    public Node find(int newData){
        Node temp = root;
        while(temp.data != newData){
            if(newData < temp.data){
                temp = temp.leftChild;
            }else {
                temp = temp.rightChild;
            }
            if(temp == null){
                return null;
            }
        }
        return temp;
    }

    public boolean remove(int dataToRemove){
        Node temp = root;
        Node parent = root;

        boolean isItALeftChild = true;
        while(temp.data != dataToRemove){
            parent = temp;
            if (dataToRemove < temp.data) {
                temp = temp.leftChild;
                isItALeftChild = true;
            } else{
                temp = temp.rightChild;
                isItALeftChild = false;
            }
            if(temp == null){
                return false;
            }
        }

        if(temp.leftChild == null && temp.rightChild == null){
            if(temp == root){
                root = null;
            }else if(isItALeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        } else if(temp.rightChild == null){
            if(temp == root){
                root = temp.leftChild;
            }else if(isItALeftChild){
                parent.leftChild = temp.leftChild;
            }else{
                parent.rightChild = temp.leftChild;
            }
        }else if(temp.leftChild == null){
            if(temp == root){
                root = temp.rightChild;
            }else if(isItALeftChild){
                parent.leftChild = temp.rightChild;
            }else{
                parent.rightChild = temp.rightChild;
            }
        } else{

            Node replacmentParent = temp;
            Node replacment = temp;

            Node temp2 = temp.rightChild;

            while(temp2 != null){
                replacmentParent = replacment;
                replacment = temp2;
                temp2 = temp2.leftChild;
            }

            if(replacment != temp.rightChild){
                replacmentParent.leftChild = replacment.rightChild;
                replacment.rightChild = temp.rightChild;
            }

            if(temp == root){
                root = replacment;
            }else if(isItALeftChild){
                parent.leftChild = replacment;
            }else{
                parent.rightChild = replacment;
            }

            replacment.leftChild = temp.leftChild;
        }

        return true;
    }


    public static void main(String[] args){
        System.out.println("Tree work:");

        BinaryTree tree = new BinaryTree();

        tree.add(12);
        tree.add(2);
        tree.add(6);
        tree.add(7);
        tree.add(4);
        tree.add(9);
        tree.add(7);
        tree.remove(6);

        tree.inOrederTraversal(tree.root);

        System.out.println();

        System.out.println(tree.find(0));


    }
}
class Node{
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int newData) {
        data = newData;
    }

    public String toString() {
        return "this node contains the data: " + data;
    }
}
