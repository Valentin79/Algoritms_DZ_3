package ru.geekbrains.lesson3;




public class Program {

    public static void main(String[] args) {

        LinkedList<Student> linkedList = new LinkedList<>();
        linkedList.addLast(new Student("dAStudent1", 19));
        linkedList.addLast(new Student("AaStudent2", 19));
        linkedList.addLast(new Student("VcStudent3", 20));
        linkedList.addLast(new Student("FfStudent4", 22));
        linkedList.addLast(new Student("BaStudent5", 24));
        linkedList.addLast(new Student("ffStudent6", 18));

        printLinkedList(linkedList);
        linkedList.recursiveRevert();
        printLinkedList(linkedList);

//        linkedList.directSort(new StudentAgeComparator(SortType.Ascending));
//        printLinkedList(linkedList);
//
//        linkedList.directSort(new StudentAgeComparator(SortType.Descending));
//        printLinkedList(linkedList);
//
//        linkedList.directSort(new StudentNameComparator(SortType.Ascending));
//        printLinkedList(linkedList);
//
//        linkedList.directSort(new StudentNameComparator(SortType.Descending));
//        printLinkedList(linkedList);

    }

    public static <T> void printLinkedList(LinkedList<T> list){
        LinkedList<T>.Node node = list.getHead();
        System.out.println();
        while (node != null){
            System.out.println(node.getValue());
            node = node.getNext();
        }
        System.out.println();
    }

}
