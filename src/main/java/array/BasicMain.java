package array;

import java.lang.reflect.Array;

public class BasicMain {

  public static void main(String[] args) {
    int[] oneDimensionalArray = {1, 2};
    double[][] towDimensionalArray = {{1,2},{3,4}};
    inspectArrayValues(towDimensionalArray);
  }

  public static void inspectArrayValues(Object arrayObject){
    int arrayLength = Array.getLength(arrayObject);

    System.out.print("[");
    for (int i = 0; i < arrayLength; i++) {
      Object element = Array.get(arrayObject, i);

      if(element.getClass().isArray()){
        inspectArrayValues(element);
      } else {
        System.out.print(element);
      }

      if(i != arrayLength - 1){
        System.out.print(" , ");
      }
    }
    System.out.print("]");
  }

  public static void inspectArrayObject(Object arrayObject){
    Class<?> clazz = arrayObject.getClass();

    System.out.println(String.format("is array : %s", clazz.isArray()));

    Class<?> arrayComponentType = clazz.getComponentType();

    System.out.println(String.format("This is an array of type : %s", arrayComponentType.getTypeName()));
  }
}
