//TODO: sort
//ISSUES:

public class Radix extends MyLinkedList {

public static int nth(int n, int col) {
	return (int) (n / Math.pow(10, col - 1)) % 10;
}

public static int length(int n) {
	return (int) Math.log10(n) + 1;
}

public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
	for (int i = 0; i < buckets.length; i++) {
		original.extend(buckets[i]); //assumes you are able to clear out original before running
	}
}
}
