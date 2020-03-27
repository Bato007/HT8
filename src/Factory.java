/**
 * @author Brandon Hernández 19376
 * @since 26/03/2020
 * @version 26/03/2020
 * @name Factory.java
 *
 * Se encarga de devolver uns instancia de un JFC o un personal heap
 */
public class Factory {

    /**
     * Se encarga de conseguir la instancia deseada
     * @pre no se posee una instancia
     * @pos se tiene una instancia de Heap
     * @param option es la opcion que eligio el usuario
     * @return la instancia que quiere el usuario
     */
    public static Heap<Patient<String>> factory(String option){
        if(option.equalsIgnoreCase("1")){
            return new JFCVectorHeap<>();
        }else{
            return new VectorHeap<>();
        }
    }

}
