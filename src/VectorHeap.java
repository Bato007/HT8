import java.util.Vector;
/**
 * @author Brandon Hernández 19375
 * @since 26/03/2020
 * @version 26/03/2020
 * @name VectorHeap.java
 *
 * Implementación del contrato Heap, representando un heap
 * @reference Java Structures, Duane Bailey
 * @param <E> tipo de dato que posee una extension de comparable
 */
public class VectorHeap<E extends Comparable<E>> implements Heap<E> {

    protected Vector<E> data; // the data, kept in heap order

    public VectorHeap()
    // post: constructs a new priority queue
    {
        data = new Vector<E>();
    }

    public VectorHeap(Vector<E> v)
    // post: constructs a new priority queue from an unordered vector
    {
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++)
        { // add elements to heap
            add(v.get(i));
        }
    }
    protected static int parent(int i)
    // pre: 0 <= i < size
    // post: returns parent of node at location i
    {
        return (i-1)/2;
    }

    protected static int left(int i)
    // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2*i+1;
    }

    protected static int right(int i)
    // pre: 0 <= i < size
    // post: returns index of right child of node at location i
    {
        return (2*i+1) + 1;
    }

    protected void percolateUp(int leaf)
    // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    protected void pushDownRoot(int root)
    // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos+1)).compareTo
                                (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo
                        (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root,value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root,value);
                return;
            }
        }
    }

    /**
     * Agruega un valor al heap
     *
     * @param value elemento que quiere ser agregado al heap
     * @pre heap tiene n elementos
     * @pos heap tiene (n + 1) elementos
     */
    public void add(E value) {
        data.add(value);
        percolateUp(data.size()-1);
    }

    /**
     * Se consigue el valor que esta hasta arriba del heap
     *
     * @return el valor que se quito del heap
     * @pre heap !isEmpty y posee n valore s
     * @pos heap n - 1
     */
    public E remove() {
        E minVal = this.data.get(0);
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    /**
     * Revisa si el heap esta vacio
     *
     * @return true si esta vacia y false si no lo esta
     * @pos muestra si esta vacio el heap
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

}
