package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap map;

    public AmigoSet() {
        map = new HashMap<>();

    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16,(int)Math.ceil(collection.size()/.75f));
        map = new HashMap(capacity);
        this.addAll(collection);

    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        int size = map.size();
        out.writeInt(capacity);
        out.writeFloat(loadFactor);
        out.writeInt(size);
        Set<E> set = map.keySet();
        for (E element : set) {
            out.writeObject(element);
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        int size = in.readInt();
        map = new HashMap<>(capacity, loadFactor);
        for (int i = 0; i < size; i++) {
            map.put((E)in.readObject(), PRESENT);
        }

    }


    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<E> cloneSet = new AmigoSet<>();
            cloneSet.addAll(this);
            cloneSet.map = (HashMap<E, Object>) map.clone();
            return cloneSet;
        } catch (Throwable e) {
            throw new InternalError(e);
        }
    }
}
