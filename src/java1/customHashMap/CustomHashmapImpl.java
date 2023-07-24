package java1.customHashMap;

public class CustomHashmapImpl <K, V>{
    private Entry<K,V>[] nodes;
    private int n;

    public CustomHashmapImpl(){
        nodes = new Entry[16];
    }

    public V put(K key, V value){
        int index = index(key);
        Entry<K, V> prev = null;
        Entry<K, V> entry = new Entry<>(key, value, null);
        if(nodes[index] == null){
            nodes[index] = entry;
        } else {
            Entry<K, V> curr = nodes[index];
            while(curr != null && !curr.getValue().equals(value)){
                prev = curr;
                curr = curr.getNext();
            }
            if(curr == null){
                prev.setNext(entry);
            }else {
                curr.setValue(value);
            }
        }
        if(prev == null){
            return null;
        }
        return prev.getValue();
    }

    private int index(K key) {
        int hashcode = key.hashCode();
        int index = hashcode & (n-1);
        return index;
    }

    public V get(K key){
        return null;
    }

    public V remove(K key){
        return null;
    }
}
