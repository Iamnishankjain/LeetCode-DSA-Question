class LFUCache {

    static HashMap<Integer, Integer> cache;
    static HashMap<Integer, Integer> keyCount;
    static HashMap<Integer, LinkedHashSet<Integer>> freqMap;
    static int cap,min;

    LFUCache(int capacity) {
        cap = capacity;
        min=-1;
        cache = new HashMap<>();
        keyCount = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(1,new LinkedHashSet<>());
    }

    public static int get(int key) {
        if(!keyCount.containsKey(key)) return -1;
        int count=keyCount.get(key);
        keyCount.put(key,count+1);
        freqMap.get(count).remove(key);
        if(count==min && freqMap.get(count).size()==0){
            min++;
        }
        if(!freqMap.containsKey(count+1)){
            freqMap.put(count+1,new LinkedHashSet<>());
        }
        freqMap.get(count+1).add(key);
        return cache.get(key);
    }

        
    public static void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            get(key);
            return;
        }

        if(cache.size()>=cap){
            int minFreq=freqMap.get(min).iterator().next();
            freqMap.get(min).remove(minFreq);
            keyCount.remove(minFreq);
            cache.remove(minFreq);
        }
        cache.put(key,value);
        keyCount.put(key,1);
        freqMap.get(1).add(key);
        min=1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */