import java.util.*;
public class quick_sort {
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
System.out.println("enter the num numbers: ");
int n = sc.nextInt();

int i,temp,j;
System.out.println("enter the element");
int arr[] = new int[n];
for(i=0;i<n;i++)
{
arr[i] = sc.nextInt();
}
 
System.out.println("Original Array:");
for (int value : arr) {
System.out.print(value + " ");
}
System.out.println();

int low = 0;
int high = n - 1;
quickSort(arr, low, high);

System.out.println("Sorted Array:");
for (int value : arr) {
System.out.print(value + " ");
}
System.out.println();
}
public static void quickSort(int[] arr, int low, int high) {
if (low < high) {
int partitionIndex = partition(arr, low, high);
quickSort(arr, low, partitionIndex - 1);
quickSort(arr, partitionIndex + 1, high);
}
}
public static int partition(int[] arr, int low, int high) {
int pivot = arr[high];
int i = low - 1;
for (int j = low; j < high; j++) {
if (arr[j] < pivot) {
i++;
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}
}

int temp = arr[i + 1];
arr[i + 1] = arr[high];
arr[high] = temp;
return i + 1;
}
}
