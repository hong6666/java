package lhh.dataStructureAndAlgorithm;

/**
 * @program: IdeaJava
 * @Date: 2019/11/19 15:10
 * @Author: lhh
 * @Description:
 */
public class BinarySearch {
    public static void main(String[] args) {
        ordArray arr = new ordArray(100);

        arr.insert(72);
        arr.insert(90);
        arr.insert(45);
        arr.insert(126);
        arr.insert(54);
        arr.insert(165);
        arr.insert(55);
        arr.insert(66);
        arr.insert(78);
        arr.insert(22);
        arr.insert(45);
        arr.insert(23);
        arr.insert(32);
        arr.insert(63);
        arr.insert(182);
        arr.display();
        int searchKey = 22;
        if (arr.find(searchKey) != arr.size())
            System.out.println("Found" + searchKey);
        else
            System.out.println("Can't find " + searchKey);
    }
}

class ordArray {
    private long[] a;
    private int nElems;

    public ordArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        return recFind(searchKey, 0, nElems - 1);
    }

    private int recFind(long searchKey, int lowerBound, int upperBound) {
        int curIn;
        curIn = (lowerBound + upperBound) / 2;
        if (a[curIn] == searchKey)
            return curIn;
        else if (lowerBound > upperBound)
            return nElems;
        else {
            if (a[curIn] < searchKey)
                return recFind(searchKey, curIn + 1, upperBound);
            else
                return recFind(searchKey, lowerBound, curIn - 1);
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] > value)
                break;
        }
        for (int k = nElems; k > j; k--){
            a[k] = a[k - 1];
        }
        a[j] = value;
        nElems++;

    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println(" ");
    }
}
