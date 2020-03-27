import java.util.PriorityQueue;
/**
 * @author Brandon Hernández 19375
 * @since 26/03/2020
 * @version 26/03/2020
 * @name JFCVectorHeap.java
 *
 * Implementación del contrato Heap, representando un heap pero utiliza el JFC
 * @param <E> tipo de dato que posee una extension de comparable
 */
public class JFCVectorHeap<E extends Comparable<E>> implements Heap<E>{

    private PriorityQueue<E> heap = new PriorityQueue<>();

    /**
     * Agruega un valor al heap
     *
     * @param value elemento que quiere ser agregado al heap
     * @pre heap tiene n elementos
     * @pos heap tiene (n + 1) elementos
     */
    @Override
    public void add(E value) {
        heap.add(value);
    }

    /**
     * Se consigue el valor que esta hasta arriba del heap
     *
     * @return el valor que se quito del heap
     * @pre heap !isEmpty y posee n valore s
     * @pos heap n - 1
     */
    @Override
    public E remove() {
        return heap.remove();
    }

    /**
     * Revisa si el heap esta vacio
     *
     * @return true si esta vacia y false si no lo esta
     * @pos muestra si esta vacio el heap
     */
    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

}
