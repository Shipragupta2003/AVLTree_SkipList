public class BalancedBST extends BST {

    public BSTNode rightRotation(BSTNode z) {
        BSTNode x = z.left;
        BSTNode store = x.right;
        x.right = z;
        z.left = store;
        //checked rotation above
        z.height = maxi(Htree(z.left), Htree(z.right)) + 1;
        x.height =maxi(Htree(x.left), Htree(x.right)) + 1;
        //updated heights
 
        return x;
    }

    public BSTNode leftRotation(BSTNode z) {
        BSTNode y = z.right;
        BSTNode store = y.left;
        y.left = z;
        z.right = store;
        //  rotation done
        
        z.height = maxi(Htree(z.left), Htree(z.right)) + 1;
        y.height = maxi(Htree(y.left), Htree(y.right)) + 1;
        //  Updated height
 
        return y;
    }

    //recursion is easy way, to do insertion, I have done
    // root.left=insertRec() like this because we need to ensure that pointers are also correctly connected
    public BSTNode insertRec(BSTNode root,int num){
        if (root==null){
            BSTNode x=new BSTNode(num);
            root=x;
            return root; 
        }
        
        
        else if(root.value>num){
            root.left=insertRec(root.left,num);
        }
        else{
            root.right=insertRec(root.right,num);
        }

        root.height=1+maxi(Htree(root.left),Htree(root.right));
        int balancef =0;
        if(root==null){
            balancef=0;}
        else{
            balancef=Htree(root.left)-Htree(root.right);
        }
        //L-L
        if( balancef >1 && num<root.left.value){
            BSTNode a=rightRotation(root);
            return a;
        }
        //R-R
        else if(balancef <-1 && num>root.right.value){
            return leftRotation(root);
        }
        //l-R
        else if(balancef >1 && num>root.left.value){
            root.left = leftRotation(root.left);
            BSTNode a=rightRotation(root);
            return a;
        }
        //R-L
        else if( balancef <-1 && num<root.right.value){
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        root.height=1+maxi(Htree(root.left),Htree(root.right));
        return root;
        }
    public void insert(int key){
        boolean x=search( key);
        if(x==true){
            return;}
        
    
    
        root=insertRec(root,key);
        //System.out.println("insert");        
        return;
        // TO be completed by students
    }


    //similar to insert, extra only predecessor part
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
        int balancef =0;
        if(root==null){
            balancef=0;}
        else{
            balancef=Htree(root.left)-Htree(root.right);
        }
        //here , I have made the four cases of using rotation to balance , 
        //they all depend on balance factor which is calculated by subtracting height of left tree- right tree.
        //L-L case
        if(num<root.left.value && balancef >1){
            BSTNode a=rightRotation(root);
            return a;
        }
        //R-R case
        else if(num<root.right.value && balancef <-1){
            BSTNode a=rightRotation(root);
            return a;
        }
        // L-R case
        else if(num>root.left.value && balancef >1){
            root.left = leftRotation(root.left);
            BSTNode b=rightRotation(root);
            return b;
        }
        //R-R case
        else if(num<root.right.value && balancef <-1){
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        //root.height=1+maxi(Htree(root.left),Htree(root.right));
        return root;
        }



    public boolean delete(int key){
        // TO be completed by students
        boolean x=search( key);
        if (x==true){

        
        root = deleteNode(root, key);
        //System.out.println("delete");
        return true;}
		return false;
    }
    
    //     System.out.println(y.inorder());
    //     System.out.println(y.Htree(y.root));

    //    System.out.println(y.delete(3));
    //     System.out.println(y.delete(7));
    //    System.out.println(y.search(3));
    //    System.out.println(y.search(5));
    //    System.out.println(y.Htree(y.root));
   
    //    System.out.println(y.inorder());
    //     System.out.println(y.preorder());
    //     System.out.println(y.postorder());
   }

    


