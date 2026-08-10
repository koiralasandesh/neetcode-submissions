class TimeMap {

    Map<String,TreeMap<Integer,String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> childStore = store.computeIfAbsent(key,k->new TreeMap<>());
        childStore.put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if (store.containsKey(key)){
            TreeMap<Integer,String> childStore = store.get(key);
            Integer floorKey =  childStore.floorKey(timestamp);

            if (floorKey!=null){
                return childStore.get(floorKey);
            }

        }
        return "";
    }
}
