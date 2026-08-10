class LRUCache {

    final int capacity;
    final DLList lRecent;
    final DLList mRecent;
    final HashMap<Integer,DLList> map;


    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>(); 
        lRecent = new DLList(-1,-1);
        mRecent = new DLList(-1,-1);
        mRecent.next=lRecent;
        lRecent.prev=mRecent;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        DLList node = map.get(key);
        separateNode(node);
        moveToMrecent(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            DLList node = map.get(key);
            separateNode(node);
            moveToMrecent(node);
            node.value=value;
        }
        else{
            DLList node = new DLList(key,value);
            moveToMrecent(node);
            map.put(key,node);

            if (map.size()>capacity){
                DLList lRNode = lRecent.prev;
                separateNode(lRNode);
                map.remove(lRNode.key);
            }
        }
    }

    private void moveToMrecent(DLList node){
        node.next=mRecent.next;
        node.next.prev=node;
        node.prev=mRecent;
        mRecent.next=node;
    }

    private void separateNode(DLList node){
        node.prev.next =node.next;
        node.next.prev=node.prev;
    }
}

class DLList{
    int key;
    int value;
    DLList prev;
    DLList next;

    public DLList(int key, int value){
        this.key=key;
        this.value=value;
    }
}
