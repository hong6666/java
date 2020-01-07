package lhh.array数组;

/**
 * @program: IdeaJava
 * @Date: 2020/1/7 15:13
 * @Author: lhh
 * @Description:
 */
public class MyArrayList {

    transient Object[] elementData;

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private int size;

    public MyArrayList(int initialCapacity)
    {
        if(initialCapacity > 0)
        {
            this.elementData = new Object[initialCapacity];
        }else if (initialCapacity == 0)
        {
            this.elementData = EMPTY_ELEMENTDATA;
        }else
        {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public MyArrayList()
    {
        this(DEFAULT_CAPACITY);
    }

    private void ensureExplicitCapacity(int minCapacity)
    {
        if(size == elementData.length)
        {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0)
            {
                newCapacity = minCapacity;
            }
            Object[] objects = new Object[newCapacity];
            System.arraycopy(elementData,0,objects,0,elementData.length);
            elementData = objects;
        }
    }

    public void add(Object o)
    {
        ensureExplicitCapacity(size + 1);
        elementData[size++] = o;
    }

    public void add(int index ,Object o)
    {
        rangeCheck(index);
        ensureExplicitCapacity(size + 1);
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index] = o;
        size++;
    }


    private void rangeCheck(int index)
    {
        if (index >= size)
            throw new IndexOutOfBoundsException("下标越界");
    }

    public Object get(int index)
    {
        rangeCheck(index);
        return elementData[index];
    }

    public Object remove(int index)
    {
        rangeCheck(index);
        Object oldValue = elementData[index];

        int numMoved = size - index - 1;
        if(numMoved > 0)
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        elementData[--size] = null;

        return oldValue;
    }

    public boolean remove(Object o)
    {
        for(int index = 0;index < size;index++)
        {
            if(o.equals(elementData[index]))
            {
                remove(index);
                return true;
            }
        }
        return false;
    }


    public int getSize()
    {
        return size;
    }


}
