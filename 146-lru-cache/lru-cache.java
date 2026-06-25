class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        // Constructor to initialize node
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap ;
    HashMap<Integer , Node> mpp = new HashMap<>();
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    void delNode(Node delNode){
        Node delprev = delNode.prev;
        Node delNext = delNode.next;
        delprev.next = delNext;
        delNext.prev = delprev;
    }

    public int get(int key) {
        if(mpp.containsKey(key)){
            Node resNode = mpp.get(key);
            int res = resNode.val;

            mpp.remove(key);
            delNode(resNode);
            addNode(resNode);
            mpp.put(key,head.next);

            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mpp.containsKey(key)){
            Node existingNode = mpp.get(key);
            mpp.remove(key);
            delNode(existingNode);
        }
        if(mpp.size() == cap){
            mpp.remove(tail.prev.key);
            delNode(tail.prev);
        }
        addNode(new Node(key,value));
        mpp.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */