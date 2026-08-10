class CountSquares {

    Map<List<Integer>,Integer> counts;
    List<List<Integer>> points;


    public CountSquares() {
        counts= new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> pt = List.of(point[0],point[1]);
        counts.put(pt,counts.getOrDefault(pt,0)+1);  
        points.add(pt); 
    }
    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int result =0;
        for (List<Integer> pt: points){
            int x = pt.get(0);
            int y = pt.get(1);

            if (Math.abs(px-x)==Math.abs(py-y) && px!=x && py!=y){
                result +=(counts.getOrDefault(List.of(px,y),0)*counts.getOrDefault(List.of(x,py),0));
            }
        }

        return result;
    }
}
