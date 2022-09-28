package com.cxy.advanced.datastructure.lru;

/**
 * @author xinyi.chen
 * @date 2022/6/30 0030
 * @description 简单LRU链表
 * @since JDK1.8
 */
public class SimpleLruLinkedList<E> {

    /**
     * 初始大小
     */
    private int capacity;

    /**
     * 链表长度
     */
    private int size;

    /**
     * 头结点
     */
    private Node<E> head;

    public SimpleLruLinkedList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node<>();
    }

    /**
     * 元素节点
     * @param <E>
     */
    static class Node<E>{
        Node<E> prev;
        Node<E> next;
        E item;
        public Node() {
            this.prev = null;
            this.next = null;
        }

        public Node(E item, Node<E> next, Node<E> prev) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        private Node<E> getNext(){
            return next;
        }

        private Node<E> getPrev(){
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    /**
     * 添加元素
     * @param o
     */
    private void add(E o){
        Node<E> eNode = get(o);
        if (eNode!=null){
            delNode(eNode);
            insertNode(o);
        }else {
            if (size >= capacity){
                delEndNode();
            }
            insertNode(o);
        }
    }

    /**
     * 插入元素
     * @param o
     */
    private void insertNode(E o){
        Node<E> objectNode = new Node<>();
        objectNode.setItem(o);
        Node<E> next = head.getNext();
        objectNode.setPrev(head);
        objectNode.setNext(next);
        if (next!=null){
            next.setPrev(objectNode);
        }
        head.setNext(objectNode);
        size++;
    }

    /**
     * 删除末尾元素
     */
    private void delEndNode() {
        Node<E> head = this.head;
        if (head.next==null){
            return;
        }

        while (head.next.next!=null){
            head = head.next;
        }
        Node<E> end = head.getNext();
        end.setPrev(null);
        head.setNext(null);
        size--;
    }

    /**
     * 查询元素
     * @param o
     * @return
     */
    public Node<E> get(Object o){
        Node<E> head = this.head;
        while ((head= head.getNext())!=null){
            if (o == head.item){
                return head;
            }
        }
        return null;
    }

    /**
     * 删除元素
     * @param node
     */
    public void delNode(Node<E> node){
        Node<E> next = node.getNext();
        Node<E> prev = node.getPrev();
        prev.setNext(next);
        if (next!=null){
            next.setPrev(prev);
        }
        size--;
    }

    /**
     * 打印链表
     */
    private void print(){
        Node<E> head = this.head;
        while (head.getNext()!=null){
            System.out.println(head.getNext().item);
            head = head.next;
        }
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) {
        SimpleLruLinkedList<Integer> list = new SimpleLruLinkedList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.print();
        list.add(8);
        list.print();
        list.add(10);
        list.print();
        list.delNode(list.get(10));
        list.print();
    }

    }