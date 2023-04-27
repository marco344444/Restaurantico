package Auxiliar.ArbolBinBusqueda;

public class ArbolBusqueda<T extends Comparable<T>> {
    private NodoArbol<T> raiz;

    public ArbolBusqueda() {
        this.raiz = null;
    }

    public void agregar(T valor) {
        NodoArbol<T> nuevoNodo = new NodoArbol<>(valor);

        if (raiz == null) {
            raiz = nuevoNodo;
        } else {
            agregar(raiz, nuevoNodo);
        }
    }

    private void agregar(NodoArbol<T> nodoActual, NodoArbol<T> nuevoNodo) {
        if (nuevoNodo.getObject().compareTo(nodoActual.getObject()) < 0) {
            if (nodoActual.izquierda == null) {
                nodoActual.izquierda = nuevoNodo;
            } else {
                agregar(nodoActual.izquierda, nuevoNodo);
            }
        } else {
            if (nodoActual.derecha == null) {
                nodoActual.derecha = nuevoNodo;
            } else {
                agregar(nodoActual.derecha, nuevoNodo);
            }
        }
    }
    public boolean eliminar(T valor) {
        NodoArbol<T> nodoActual = raiz;
        NodoArbol<T> nodoPadre = null;
        while (nodoActual != null) {
            int comparacion = valor.compareTo(nodoActual.getObject());
            if (comparacion == 0) {
                if (nodoActual.izquierda == null) {
                    if (nodoPadre == null) {
                        raiz = nodoActual.derecha;
                    } else if (nodoPadre.izquierda == nodoActual) {
                        nodoPadre.izquierda = nodoActual.derecha;
                    } else {
                        nodoPadre.derecha = nodoActual.derecha;
                    }
                    return true;
                } else if (nodoActual.derecha == null) {
                    if (nodoPadre == null) {
                        raiz = nodoActual.izquierda;
                    } else if (nodoPadre.izquierda == nodoActual) {
                        nodoPadre.izquierda = nodoActual.izquierda;
                    } else {
                        nodoPadre.derecha = nodoActual.izquierda;
                    }
                    return true;
                } else {
                    NodoArbol<T> sucesor = buscarSucesor(nodoActual.derecha);
                    nodoActual.setObject(sucesor.getObject());
                    nodoActual = sucesor;
                }
            }
            nodoPadre = nodoActual;
            nodoActual = comparacion < 0 ? nodoActual.izquierda : nodoActual.derecha;
        }
        return false;
    }

    private NodoArbol<T> buscarSucesor(NodoArbol<T> nodoActual) {
        while (nodoActual.izquierda != null) {
            nodoActual = nodoActual.izquierda;
        }
        return nodoActual;
    }
    public boolean buscar(T valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(NodoArbol<T> nodoActual, T valor) {
        if (nodoActual == null) {
            return false;
        }

        if (nodoActual.getObject().equals(valor)) {
            return true;
        }

        if (valor.compareTo(nodoActual.getObject()) < 0) {
            return buscar(nodoActual.izquierda, valor);
        } else {
            return buscar(nodoActual.derecha, valor);
        }
    }
    public int countNodes() {
        return countNodes(raiz);
    }

    private int countNodes(NodoArbol<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + countNodes(nodo.izquierda) + countNodes(nodo.derecha);
    }

    public int height() {
        return height(raiz);
    }

    private int height(NodoArbol<T> nodo) {
        if (nodo == null) {
            return -1;
        }
        return 1 + Math.max(height(nodo.izquierda), height(nodo.derecha));
    }

    public boolean isComplete() {
        int height = height();
        int nodes = countNodes();
        return nodes == (int) Math.pow(2, height + 1) - 1;
    }

    public boolean isFull() {
        int height = height();
        int nodes = countNodes();
        return nodes == (int) Math.pow(2, height + 1) - 1 && height >= 0;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    
}
