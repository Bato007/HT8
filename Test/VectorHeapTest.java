import org.junit.Test;

public class VectorHeapTest {

    @Test
    public void test() {
        Heap<Patient<String>> heap = new VectorHeap<>();

        heap.add(new Patient<>("Martin Amado", "Se fracturo los dedos", "C"));
        heap.add(new Patient<>("Andrea Amaya", "Alergia", "A"));
        heap.add(new Patient<>("Oliver de Leon", "Vegetariano", "E"));
        heap.add(new Patient<>("Laura Tamath", "Pendeja", "B"));

        System.out.println(heap.remove().getPatientInfo());
        System.out.println(heap.remove().getPatientInfo());
        System.out.println(heap.remove().getPatientInfo());
        System.out.println(heap.remove().getPatientInfo());
    }

}