package Lista;

public class Test {

    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertar("a", 1);
        lista.insertar("b", 2);
        lista.insertar("c", 3);
        lista.insertar("d", 4);
        lista.insertar("e", 5);
        
        lista.insertar("a0", 1);
        lista.insertar("b1", 3);
        lista.insertar("last", 7);
        
        
        System.out.println(lista.toString());
    }

}
