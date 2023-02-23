package ru.geekbrains.lesson3;

import java.util.Comparator;

/**
 * Однонаправленный связанный список
 */
public class LinkedList<T> {



    public Node head;

    public Node getHead() {
        return head;
    }



    /**
     * Узел
     */
    class Node{
        private T value;
        private Node next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * Добавить новый элемент в начало связанного списка
     * @param value Значение
     */
    public void addFirst(T value){
        Node node = new Node(value);
        if (head != null)
            node.setNext(head);
        head = node;
    }

    /**
     * Удалить первый элемент связанного списка
     */
    public  void removeFirst(){
        if (head != null)
            head = head.getNext();
    }

    /**
     * Поиск элемента в связанном списке
     * @param value Значение
     * @return Результат поиска
     */
    public boolean contains(T value){
        Node node = head;
        while (node != null){
            if (node.getValue().equals(value))
                return true;
            node = node.getNext();
        }
        return false;
    }

    public void directSort(Comparator<T> comparator){
        Node node = head;
        while (node != null){

            Node saveNode = node;

            Node node2 = node.getNext();
            while (node2 != null){
                if (comparator.compare(saveNode.getValue(), node2.getValue()) > 0){
                    saveNode = node2;
                }
                node2 = node2.getNext();
            }

            if (node != saveNode){
               T buf = node.getValue();
               node.setValue(saveNode.getValue());
               saveNode.setValue(buf);
            }

            node = node.getNext();
        }

    }

    /**
     * Добавить элемент в конец связанного списка
     * @param value Значение
     */
    public void addLast(T value){
        Node node = new Node(value);
        if (head == null){
            head = node;
        }
        else {
            Node last = head;
            while (last.getNext() != null)
                last = last.getNext();
            last.setNext(node);
        }
    }

    /**
     * Удалить последний элемент связанного списка
     */
    public void removeLast(){
        if (head == null)
            return;
        Node node = head;
        while (node.getNext() != null){
            if (node.getNext().getNext() == null){
                head.setNext(null);
                return;
            }
            node = node.getNext();
        }
        head = null;
    }

    public void revert(){
        Node previous = null;
        Node current = head;
        while (current != null){
            Node next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void recursiveRevert(){
        if(head.next != null && head != null){
            recursiveRevert(head.next, head);
        }
    }
    private void recursiveRevert(Node currentNode, Node previousNode){
        if(currentNode.getNext() == null){
            head = currentNode;
        }
        else{
            recursiveRevert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }
}
