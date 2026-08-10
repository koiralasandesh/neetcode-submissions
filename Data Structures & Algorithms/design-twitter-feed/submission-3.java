class Twitter {

    record Tweet(int time,int tweetId,int userId, int tweetIndexPerUser){}
    
    Map<Integer,List<Tweet>> userTweets;
    Map<Integer,Set<Integer>> folowees;

    int time=0;


    public Twitter() {
        userTweets = new HashMap<Integer,List<Tweet>>();
        folowees = new HashMap<Integer,Set<Integer>>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Tweet> temp = userTweets.getOrDefault(userId, new ArrayList<Tweet>());
        temp.add(new Tweet(time++,tweetId,userId,temp.size()));
        userTweets.put(userId,temp);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<Tweet>((a,b)-> Integer.compare(b.time(),a.time()));
        List <Integer> result = new ArrayList<>();

        Set<Integer> foloweesForUser= folowees.getOrDefault(userId,new HashSet<Integer>());

        foloweesForUser.add(userId);
        for (int folowee: foloweesForUser){
            List<Tweet> tweets = userTweets.get(folowee);
            if (tweets!=null && !tweets.isEmpty()){
                maxHeap.offer(tweets.get(tweets.size()-1));
            }
        }



        while(result.size()<10 && !maxHeap.isEmpty()){
            Tweet tweet = maxHeap.poll();
            result.add(tweet.tweetId());

            List<Tweet> temp = userTweets.get(tweet.userId);
            if (temp.size()>0 && tweet.tweetIndexPerUser()>0){
                maxHeap.offer(temp.get(tweet.tweetIndexPerUser()-1));
            }
        }

        return result;
        
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> temp=folowees.getOrDefault(followerId,new HashSet<Integer>());
        temp.add(followeeId);
        folowees.put(followerId,temp);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> temp = folowees.get(followerId);
        if(temp!=null){
            temp.remove(Integer.valueOf(followeeId));
            folowees.put(followerId,temp);
        }

    }
}
