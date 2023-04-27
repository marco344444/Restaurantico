package Auxiliar.ArbolBinario;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario {
    NodoArbol root;

    public ArbolBinario() {
        this.root = null;
    }

    public void insertByDepth(Object val) {
        NodoArbol node = new NodoArbol(val);
        if (root == null) {
            root = node;
        } else {
            Queue<NodoArbol> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                NodoArbol current = queue.poll();
                if (current.izquierda == null) {
                    current.izquierda = node;
                    break;
                } else if (current.derecha == null) {
                    current.derecha = node;
                    break;
                } else {
                    queue.offer(current.izquierda);
                    queue.offer(current.derecha);
                }
            }
        }
    }
    
    public void insertByWidth(Object val) {
        NodoArbol node = new NodoArbol(val);
        if (root == null) {
            root = node;
        } else {
            Queue<NodoArbol> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                NodoArbol current = queue.poll();
                if (current.izquierda == null) {
                    current.izquierda = node;
                    break;
                } else {
                    queue.offer(current.izquierda);
                }
                if (current.derecha == null) {
                    current.derecha = node;
                    break;
                } else {
                    queue.offer(current.derecha);
                }
            }
        }
    }

    public boolean remove(Object val) {
        if (root == null) {
            return false;
        }
        if (root.val.equals(val)) {
            if (root.izquierda == null && root.derecha == null) {
                root = null;
            } else if (root.izquierda == null) {
                root = root.derecha;
            } else if (root.derecha == null) {
                root = root.izquierda;
            } else {
                NodoArbol temp = root.izquierda;
                while (temp.derecha != null) {
                    temp = temp.derecha;
                }
                root.val = temp.val;
                root.izquierda = removeRecursivo(root.izquierda, temp.val);
            }
            return true;
        }
        root = removeRecursivo(root, val);
        return root != null;
    }

    private NodoArbol removeRecursivo(NodoArbol node, Object val) {
        if (node == null) {
            return null;
        }
        if (node.val.equals(val)) {
            if (node.izquierda == null && node.derecha == null) {
                return null;
            } else if (node.izquierda == null) {
                return node.derecha;
            } else if (node.derecha == null) {
                return node.izquierda;
            } else {
                NodoArbol temp = node.izquierda;
                while (temp.derecha != null) {
                    temp = temp.derecha;
                }
                node.val = temp.val;
                node.izquierda = removeRecursivo(node.izquierda, temp.val);
            }
        } else if (node.val.hashCode() > val.hashCode()) {
            node.izquierda = removeRecursivo(node.izquierda, val);
        } else {
            node.derecha = removeRecursivo(node.derecha, val);
        }
        return node;
    }

    // Busca el sucesor inorden de un nodo
    private NodoArbol buscarSucesorInorden(NodoArbol nodo) {
        NodoArbol current = nodo.derecha;
        while (current.izquierda != null) {
            current = current.izquierda;
        }
        return current;
    }

    public void preorder(NodoArbol node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorder(node.izquierda);
            preorder(node.derecha);
        }
    }

    public void inorder(NodoArbol node) {
        if (node != null) {
            inorder(node.izquierda);
            System.out.print(node.val + " ");
            inorder(node.derecha);
        }
    }

    public void posorder(NodoArbol node) {
        if (node != null) {
            posorder(node.izquierda);
            posorder(node.derecha);
            System.out.print(node.val + " ");
        }
    }
    public void widthorder() {
        if (root == null) {
            return;
        }
        Queue<NodoArbol> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            NodoArbol current = queue.poll();
            System.out.print(current.val + " ");
            if (current.izquierda != null) {
                queue.offer(current.izquierda);
            }
            if (current.derecha != null) {
                queue.offer(current.derecha);
            }
        }
    }
    public NodoArbol buscarPreorden(NodoArbol node, Object val) {
        if (node == null) {
            return null;
        }
        if (node.val.equals(val)) {
            return node;
        }
        NodoArbol izq = buscarPreorden(node.izquierda, val);
        if (izq != null) {
            return izq;
        }
        NodoArbol der = buscarPreorden(node.derecha, val);
        if (der != null) {
            return der;
        }
        return null;
    }

    public NodoArbol buscarInorden(NodoArbol node, Object val) {
        if (node == null) {
            return null;
        }
        NodoArbol izq = buscarInorden(node.izquierda, val);
        if (izq != null) {
            return izq;
        }
        if (node.val.equals(val)) {
            return node;
        }
        NodoArbol der = buscarInorden(node.derecha, val);
        if (der != null) {
            return der;
        }
        return null;
    }

    public NodoArbol buscarPosorden(NodoArbol node, Object val) {
        if (node == null) {
            return null;
        }
        NodoArbol izq = buscarPosorden(node.izquierda, val);
        if (izq != null) {
            return izq;
        }
        NodoArbol der = buscarPosorden(node.derecha, val);
        if (der != null) {
            return der;
        }
        if (node.val.equals(val)) {
            return node;
        }
        return null;
    }
    public int countNodes(NodoArbol node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.izquierda) + countNodes(node.derecha);
    }

    public int getHeight(NodoArbol node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.izquierda);
        int rightHeight = getHeight(node.derecha);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isComplete(NodoArbol node) {
        if (node == null) {
            return true;
        }
        Queue<NodoArbol> queue = new LinkedList<>();
        queue.offer(node);
        boolean end = false;
        while (!queue.isEmpty()) {
            NodoArbol current = queue.poll();
            if (current == null) {
                end = true;
            } else if (end) {
                return false;
            } else {
                queue.offer(current.izquierda);
                queue.offer(current.derecha);
            }
        }
        return true;
    }

    public boolean isFull(NodoArbol node) {
        if (node == null) {
            return true;
        }
        if (node.izquierda == null && node.derecha == null) {
            return true;
        }
        if (node.izquierda != null && node.derecha != null) {
            return isFull(node.izquierda) && isFull(node.derecha);
        }
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }
    
}