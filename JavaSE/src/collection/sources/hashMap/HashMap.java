package collection.sources.hashMap;

import collection.sources.Map;

import java.util.Arrays;

public class HashMap<K,V> implements Map<K,V> {

    transient Entry<K,V>[] table;
    transient int size = 0 ;



    public HashMap() {
        this(16);
    }

    public HashMap(int capacity) {
        this.table = new Entry[capacity];
    }


    @Override
    public int size() {
        return this.size;
    }


    // TODO 暂不考虑扩容
    @Override
    public void put(K key, V value) {

        int hash = key.hashCode();

        int index = hash % this.table.length;

        if(this.table[index] == null) {
            this.table[index] = new Entry<>(hash,key,value,null);
        }else{
            Entry<K,V> entry = this.table[index];
            while(entry != null) {

                if(entry.hash == hash && (entry.key == key || entry.getKey().equals(key))){
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            Entry<K,V> first = this.table[index];
            this.table[index] = new Entry<K,V>(hash,key,value,first);
        }
        this.size ++;
    }

    @Override
    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % this.table.length;
        Entry<K, V> entry = this.table[index];

        while(entry != null && entry.key != key && entry.key.equals(key)){
            entry = entry.next;
        }
        return entry == null ? null : entry.value;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    static class Entry<K,V> implements Map.Entry<K,V> {
        final K key;
        V value;
        Entry next;
        int hash;

        public Entry(int hash , K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            if(this.next != null)
                return "Entry{" +
                        "key=" + key +
                        ", value=" + value +
                        ", next=" + next +
                        ", hash=" + hash +
                        '}';
            else
                return "Entry{" +
                        "key=" + key +
                        ", value=" + value +
                        ", hash=" + hash +
                        '}';
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(int i = 0 ; i < this.table.length ; i++){
            if(this.table[i] != null){
                Entry<K, V> start = this.table[i];
                while(start != null){
                    builder.append(start.key +"="+start.value+",");
                    start = start.next;
                }
            }
        }
        if(this.size > 0){
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("}");

        return builder.toString();
    }
}
