class WordDictionary {
    private TreeNode root;

    private static class TreeNode{
        private final Map<Character,TreeNode> map;
        private boolean isEndOfWord;

        TreeNode(){
            map = new HashMap<Character,TreeNode>();
        }

        TreeNode(Character c){
            map=new HashMap<Character,TreeNode>();
            map.put(c,null);
        }

       public boolean containsKey(Character c){
        return map.containsKey(c);
       }

       public TreeNode get(Character c){
        return map.get(c);
       }

       public void put(Character c, TreeNode n){
        map.put(c,n);
       }

       public boolean isEndOfWord(){
        return this.isEndOfWord;
       }

       public void setEndOfWord(boolean value){
        isEndOfWord=value;
       }

       public Collection<TreeNode> values(){
        return map.values();
       }
    }

    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode trav = root;
        for (Character c: word.toCharArray()){
            if (trav.containsKey(c)){
                trav =trav.get(c);
            }else{
                trav.put(c,new TreeNode());
                trav=trav.get(c);
            }
        }
        trav.setEndOfWord(true);
    }

    public boolean search(String word) {
        return dfs(word,root);
    }

    private boolean dfs(String s, TreeNode root){

        if (s.length()==0) return root.isEndOfWord();

        Character c = s.toCharArray()[0];

        if (c=='.'){
            boolean flag =false;
            Collection<TreeNode> values = root.values();

            for (TreeNode node: values){
                if (dfs(s.substring(1),node) ==true) {
                    flag=true;
                }
            }
            return flag;
        }

        if (!root.containsKey(c)) return false;

        return dfs(s.substring(1),root.get(c));

    }
}
