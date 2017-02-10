package ru.hostco.competence.web.page.data;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private T value;
    private List<Node<T>> childs;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void appendChild(Node<T> child) {
        if (child != null) {
            if (this.childs != null) {
                this.childs.add(child);
            } else {
                this.childs = new ArrayList<>();
                this.childs.add(child);
            }
        }
    }

    public List<Node<T>> getChilds() {
        if (this.childs == null)
            return null;
        return childs;
    }

    public void setValueAndChild(T value, Node<T> child) {
        appendChild(child);
        setValue(value);
    }

    public void deleteChild(Node<T> child) {
        childs.remove(child);
    }
}
