import java.util.ArrayList;
import java.util.Collections;

public class SkipList {

        public SkipListNode head;
        public SkipListNode tail;
        public int height;
        public Randomizer randomizer;
        private final int NEG_INF = Integer.MIN_VALUE;
        private final int POS_INF = Integer.MAX_VALUE;

        SkipList(){
            /*
            * DO NOT EDIT THIS FUNCTION
            */
            this.head = new SkipListNode(NEG_INF,1);
            this.tail = new SkipListNode(POS_INF,1);
            this.head.next.add(0,this.tail);
            this.tail.next.add(0,null);
            this.height = 1;
            this.randomizer = new Randomizer();
        }

        public boolean delete(int num){
            // TO be completed by students
        
            //System.out.println(num);
            //First of all, searching, if not found, nothing to delete.
            boolean state=search(num);
            if(state==false){
                return false;
            }
            //if found, do this , increase level by 1 if high is greater than height
            if(state){
            SkipListNode it=this.head;
                for(int i=this.height-1;i>=0;i--){
                    while(it.next.get(i)!=null && it.next.get(i).value<num){
                        it=it.next.get(i);
                    }
                    if(it.next.get(i)!=null&&it.next.get(i).value==num){
                        SkipListNode temp=it.next.get(i).next.get(i);
                        it.next.set(i,temp);
                    }}
            }
            
                return true;
            }
    
        

        public boolean search(int num){
            // TO be completed by students
            
            SkipListNode it = this.head;
            for (int i = this.height - 1; i >= 0; i--) {
            while (it.next.get(i) != null && it.next.get(i).value < num) {
                it = it.next.get(i);
            }}
            it=it.next.get(0);
            if(it!=null && it.value==num){
                return true;
            
            }
            return false;
        }

        public Integer upperBound(int num){ 
            // TO be completed by students

            SkipListNode it = this.head;
            for (int i = this.height - 1; i >= 0; i--) {
            while (it.next.get(i) != null && it.next.get(i).value < num) {
                it = it.next.get(i);
            }}
            while(it.next.get(0).value<=num && it.next.get(0)!=null){
                it=it.next.get(0);
            }
            it=it.next.get(0);
            Integer y=it.value;
            return y;
                
        }

        public void insert(int num){
            // TO be completed by student
            //System.out.println(num);
            int high=1;
            while(high<this.height+1 && randomizer.binaryRandomGen()){
                high=high+1;
                if(high>this.height){
                    //this.height=this.height+1;
                    this.height=this.height+1;
                    this.tail.height=this.tail.height+1;
                    this.head.height=this.head.height+1;
                    this.head.next.add(tail);
                    this.tail.next.add(null);
                    break;
                    
                    
                }
            }
            SkipListNode it=this.head;
            SkipListNode node=new SkipListNode(num, high);

             for(int i=high;i>0;i--){
                 node.next.add(null);}

           
             // ArrayList<SkipListNode> store=new ArrayList<SkipListNode>();
               for(int i=this.height-1;i>=0;i--){
                     while(it.next.get(i)!=null && it.next.get(i).value<num){
                         it=it.next.get(i);
                     }
               
            //         //store.add(it);
                      SkipListNode temp= it.next.get(i);
                     it.next.set(i,node);
                      node.next.add(i,temp);
                 }


            
           
                 it=it.next.get(0);
                 for(int i=high-1;i>=0;i--){
                     while(it.next.get(i)!=null && it.next.get(i).value<num){
                         it=it.next.get(i);
                     }
                    
                        SkipListNode temp= it.next.get(i);
                         it.next.set(i,node);
                         node.next.set(i,temp);
                     }
                
        }

        public void print(){
            /*
            * DO NOT EDIT THIS FUNCTION
            */
            for(int i = this.height ; i>=1; --i){
                SkipListNode it = this.head;
                while(it!=null){
                    if(it.height >= i){
                        System.out.print(it.value + "\t");
                    }
                    else{
                        System.out.print("\t");
                    }
                    it = it.next.get(0);
                }
                System.out.println("null");
            }
        }
    //     public static void main(String args[]){
    //         SkipList skip=new SkipList();
    //    skip.insert(45);
    //        skip.insert(4);
    //        skip.insert(4);
    //        skip.insert(4);
    //    //     skip.insert(46);
    //    //     skip.insert(3);
    //    //     skip.insert(1);
    //    //     skip.delete(45);
           

    //      skip.print();
    //    //     //skip.insert(4);
    //    //     //skip.print();
    //    //     //System.out.println(skip.upperBound(4));
    //    //     //System.out.println(skip.search(45));
           
       // }
    //    public static void main(String[] args) {
    //     // Create a new SkipList object
    //     SkipList skipList = new SkipList();
    
    //     // Insert some numbers into the SkipList
    //     skipList.insert(1);
    //      skipList.print();
    //      skipList.insert(3);
    //      skipList.print();
    //      skipList.insert(2);
    //      skipList.print();
    //      skipList.insert(5);
    //     skipList.print();
    //     System.out.println(skipList.delete(4));
    //    // System.out.println(skipList.s(10));
    //     System.out.println(skipList.delete(20));
    //     skipList.print();
    //      System.out.println(skipList.delete(3));
    //     System.out.println(skipList.delete(3));
    //     System.out.println(skipList.delete(3));
    //     //skipList.insert(3);
    //     //System.out.println(skipList.insert(3));
    //     //skipList.print();
    //     //skipList.delete(4);
    //     //skipList.delete(8);
    
    
    //     // skipList.print();
    //     // System.out.println(skipList.search(5));
    //     // System.out.println(skipList.search(4));
    //     // skipList.delete(20);
    //     // skipList.delete(3);
    //     // skipList.print();
    //     // skipList.delete(3);
    //     // skipList.print();
        // System.out.println(skipList.delete(3));
        // System.out.println(skipList.upperBound(3));
        // SkipListNode x= skipList.head;
        // while(x!=null){
        // System.out.println(x.height);
        // x=x.next.get(0);
        // }System.out.println("Heightofskiplist");
        // System.out.println(skipList.height);
        // System.out.println(skipList.search(9));
    
        // System.out.println(skipList.upperBound(1));
        }
   
