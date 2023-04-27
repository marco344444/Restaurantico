package Auxiliar.ArbolBinBusqueda;


public class NodoArbol<T>  {
    T val;
    NodoArbol<T> izquierda;
    NodoArbol<T> derecha;

    public NodoArbol(T val) {
        this.val = val;
        this.izquierda = null;
        this.derecha = null;
    }

    public boolean setObject(T object) {
        this.val = object;
        return true;
    }

    public T getObject() {
        return val;
    }

    public boolean isEquals(T object) {
        return this.val.equals(object);
    }

    @Override
    public String toString() {
        return val.toString();
    }
}