import java.util.*;
public class BST {

    public BSTNode root;

    public BST() {
        root = null;
    }
    public int Htree(BSTNode root){
        if (root == null) {
            return 0;
         }
         root.height= maxi(Htree(root.left),Htree(root.right))+1;
         return root.height;
    }
    //convinient , no need to put Math.max again and again
    public int maxi(int a, int b) {
        if(a>b){
            return a;
        }
        else{
            return b;
        }
    }
    
    //recursion is easy way to implement although it uses some extra space , also height is updated.
    public BSTNode insertRec(BSTNode root,int num){
        if (root==null){
            BSTNode x=new BSTNode(num);
            root=x;
            return root; 
        }
        
        
        
        else if(root.value>num){
            root.left=insertRec(root.left,num);
        }
        else if(root.value<num){
            root.right=insertRec(root.right,num);
        }
        root.height=1+maxi(Htree(root.left),Htree(root.right));
        return root;
    }


    public void insert(int num) {
        // TO be completed by students
        //no need to insert, if already present
        if(search(num)==true){
            return;}
            root=insertRec(root,num);
            
           // System.out.println("insert");
            //root.height=1+maxi(Htree(root.left),Htree(root.right));
            return;
    }

    public int getPred(BSTNode root,int pred){
        int ret=root.value;
        while(root.right!=null){
            ret=root.right.value;
            root=root.right;
        }
        return ret;
    }

    //similar  to insert, replacing by predecesor if deleted
    public BSTNode deleteNode(BSTNode root,int num){
        if(root==null){
            return root;
        }
        if(root.value>num){
            root.left=deleteNode(root.left,num);
        }
        else if(root.value<num){
            root.right=deleteNode(root.right,num);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            int pred=getPred(root.left,num);
            root.value=pred;
            root.left=deleteNode(root.left,pred);
        }
        root.height=1+maxi(Htree(root.left),Htree(root.right));
        
        return root;
    }
//made recursion function , for easiness.
    public boolean delete(int num) {
        // TO be completed by students
        boolean x=search( num);
        if (x==true){

        
        root = deleteNode(root, num);
        //System.out.println("delete");
        //root.height=1+maxi(Htree(root.left),Htree(root.right));

        return true;}
		return false;
    }

    public boolean search(int num) {
        // TO be completed by students
        BSTNode curr=root;
        while(curr!=null){
            if(curr.value==num){
                return true;
            }
            else if(curr.value<num){
                curr=curr.right;
            }
            else{
                curr=curr.left;
            }
        }
        return false;
    }

    public void inOrder(BSTNode root,ArrayList<Integer> al){
        if(root!=null){
            inOrder(root.left,al);
            al.add(root.value);
            inOrder(root.right,al);
        }
    }


    public ArrayList<Integer> inorder() {
        // TO be completed by students
		ArrayList<Integer> al = new ArrayList<>();
        inOrder(root,al);
		return al;
    }

    public void preOrder(BSTNode root,ArrayList<Integer> al){
        if(root!=null){
            al.add(root.value);
            preOrder(root.left,al);
            preOrder(root.right,al);
        }
    }
    public ArrayList<Integer> preorder() {
        // TO be completed by students
		ArrayList<Integer> al = new ArrayList<>();
        preOrder(root,al);
		return al;
    }

    public void postOrder(BSTNode root,ArrayList<Integer> al){
        if(root!=null){
            postOrder(root.left,al);
            postOrder(root.right,al);
            al.add(root.value);
        }
    }

    public ArrayList<Integer> postorder() {
        // TO be completed by students
		ArrayList<Integer> al = new ArrayList<>();
        postOrder(root,al);
		return al;
    }
}