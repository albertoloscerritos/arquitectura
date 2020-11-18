package Arquitectura;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MyTest{

    private List <Integer> list;

    public void newList(){
        list = new ArrayList<>();
    }

    // Unit testing for list size
    @Test
    public void getSizeOfList() {
        // Inicialización/escenario
        newList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // ¿qué es lo que queremos probar?
        assertEquals(4, list.size());
    }

    @Test
    public void getSizeOfListEmpty() {
        // Inicialización/escenario
        newList();

        // ¿qué es lo que queremos probar?
        assertEquals(0, list.size());
    }

    @Test(expected = NullPointerException.class)
    public void getSizeOfListNull() {
        // Inicialización/escenario
        List<Integer> list = null;

        // ¿qué es lo que queremos probar?
        list.size();
    }

    @Test
    public void getSizeOfListWhenRemovingElements() {
        // Inicialización/escenario
        newList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // ¿qué es lo que queremos probar?
        assertEquals(4, list.size());

        list.remove(1);

        // ¿qué es lo que queremos probar?
        assertEquals(3, list.size());
    }


    // Unit testing for clearing the list
    @Test
    public void clearList() {
        // Inicialización/escenario
        newList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.clear();

        // ¿qué es lo que queremos probar?
        assertEquals(0, list.size());
    }

    @Test
    public void clearListWhenEmpty(){
        newList();
        list.clear();
        assertEquals(0, list.size());
    }

    @Test(expected = NullPointerException.class)
    public void clearListNull() {
        // Inicialización/escenario
        List<Integer> list = null;

        // ¿qué es lo que queremos probar?
        list.clear();
    }


    // Unit testing for add Items

    @Test
    public void addItem(){

        // Inicialización/escenario
        newList();
        this.list.add(2);
        assertEquals(2, (int) list.get(0));

    }

    @Test
    public void addItemArray(){

        // Inicialización/escenario
        newList();

        int [] array = new int[10];
        array[0] = 1;
        this.list.add(array[0]);
        assertEquals(array[0],(int) list.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void addItemToNullList() {
        // Inicialización/escenario
        List<Integer> list = null;

        // ¿qué es lo que queremos probar?
        list.add(0);
    }


    // Unit testing be able to check if an item exists

    @Test
    public void checkIfItemExists(){

        // Inicialización/escenario
        newList();
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);

        assertTrue(list.contains(3));
    }

    @Test
    public void checkIfItemExistsInEmptyList(){

        // Inicialización/escenario
        newList();

        assertFalse(list.contains(3));
    }

    @Test
    public void checkIfItemExistsWhenItDoesntExists(){

        // Inicialización/escenario
        newList();
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);

        assertFalse(list.contains(5));
    }


    // Unit testing get elements by index
    @Test
    public void getElementByIndex(){

        // Inicialización/escenario
        newList();
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);

        assertEquals(4,(int) list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementByIndexWhenIndexOutOfBounds(){

        // Inicialización/escenario
        newList();
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);

        list.get(3);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementByIndexWhenEmptyList(){

        // Inicialización/escenario
        newList();

        list.get(3);
    }



    // Unit testing search the index of an object
    // How indexOf works:
    //Returns the index of the first occurrence of the specified
    // element in this list, or -1 if this list does not contain the element.
    @Test
    public void searchIndexOfAnObject(){

        // Inicialización/escenario
        newList();
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);

        assertEquals(1,(int) list.indexOf(3));
    }

    @Test
    public void searchIndexOfAnObjectWhenMultipleInstancesOfSameElement(){

        // Inicialización/escenario
        newList();
        this.list.add(2);
        this.list.add(3);
        this.list.add(3);

        assertEquals(1,(int) list.indexOf(3));
    }

    @Test
    public void searchIndexOfAnObjectWhenElementIsNoInTheList(){

        // Inicialización/escenario
        newList();
        this.list.add(2);
        this.list.add(3);
        this.list.add(3);

        assertEquals(-1,(int) list.indexOf(7));
    }


    // Unit testing remove an item by index
    @Test
    public void removeItemByIndex(){

        // Inicialización/escenario
        newList();
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);
        assertEquals(3,(int) list.get(1));

        this.list.remove(1);
        assertEquals(4,(int) list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeItemByIndexWhenIndexOutOfBounds(){

        // Inicialización/escenario
        newList();
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);
        list.remove(10);

    }

    @Test(expected = NullPointerException.class)
    public void removeItemByIndexWhenNullPointer(){

        // Inicialización/escenario
        List<Integer> list = null;

        // ¿qué es lo que queremos probar?
        list.remove(0);

    }


}
