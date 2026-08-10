class PrefixTree {

    TreeNode root;


    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode trav = root;
        for (Character c: word.toCharArray()){
            if (!trav.containsKey(c)){
                TreeNode temp = new TreeNode();
                trav.put(c,temp);
                trav=temp;
            }else{
                trav=trav.get(c);
            }

        }
        trav.setIsEndOfWord(true);

    }

    public boolean search(String word) {
        TreeNode trav = root;
        for (Character c: word.toCharArray()){
            if (!trav.containsKey(c)){
                return false;
            }
            trav = trav.get(c);
        }
        return trav.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        TreeNode trav = root;
        for (Character c: prefix.toCharArray()){
            if (!trav.containsKey(c)){
                return false;
            }
            trav = trav.get(c);
        }
        return true;
    }
}

class TreeNode {
    private Map<Character,TreeNode> map;
    private boolean isEndOfWord;

    TreeNode(Map<Character,TreeNode> map,boolean isEndOfWord){
        this.map = map;
        this.isEndOfWord = isEndOfWord;
    }
    
    TreeNode(){
        this.map=new HashMap<Character,TreeNode>();
    }
    
    protected boolean isEndOfWord(){
        return this.isEndOfWord;
    }
    
    protected void setIsEndOfWord(boolean value){
        this.isEndOfWord = value;
    }

    protected boolean containsKey(Character c){
        return map.containsKey(c);
    }

    protected TreeNode get(Character c){
        return map.get(c);
    }

    protected void put(Character c,TreeNode n){
        map.put(c,n);
    }

    
}
