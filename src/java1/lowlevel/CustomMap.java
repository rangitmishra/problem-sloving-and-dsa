package java1.lowlevel;

import java.util.HashMap;
import java.util.Map;

class Node<K, V> {
    public K key;
    public V value;
    public int hashCode;
    public Node<K,V> next;
    public Node(K key, V value, int hashCode){
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }

}
public class CustomMap<K, V> {
    private Node[] bucket;
    private int initialCapacity;
    private int currentCapacity;
    private float loadFactor;

    public CustomMap(int initialCapacity, float loadFactor){
        bucket = new Node[initialCapacity];
        currentCapacity = initialCapacity;
        this.loadFactor = loadFactor;
    }

    public V put(K key, V value){
        Map<String, String> amp = new HashMap<>();
        int hashCode = key.hashCode();
        int idx = hashCode % 16;
        Node<K, V> node = bucket[idx];
        if(node == null){
            bucket[idx] = new Node<>(key, value, hashCode);
            return null;
        } else {
            while (node.next != null){
                node = node.next;
            }
            node.next = new Node<>(key, value, hashCode);
            return node.value;
        }
    }

    public  V get(String key){
        int hashCode = key.hashCode();
        int idx = hashCode % 16;
        Node<K, V> node = bucket[idx];
        if(node == null){
            return null;
        } else {
            while (node != null){
                if(node.key.equals(key) || node.hashCode == hashCode){
                    return node.value;
                }
                node = node.next;
            }
        }
        return null;

    }

}

