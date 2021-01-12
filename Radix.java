//TODO: sort
//ISSUES:

public class Radix extends SortableLinkedList {

public static int nth(int n, int col) {
	return (int) (n / Math.pow(10, col)) % 10;
}

public static int length(int n) {
	return (int) Math.log10(n) + 1;
}

public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
	for (int i = 0; i < buckets.length; i++) {
		original.extend(buckets[i]); //assumes you are able to clear out original before running
	} // buckets will all be empty by design, but how do you clear the original
}

public static void radixSortSimple(SortableLinkedList original) {
	SortableLinkedList bucket[] = new SortableLinkedList[10];
	for (int i = 0; i < original.size(); i++) {
		System.out.println(nth(original.get(0), 0));
		bucket[nth(original.get(0), 0)].add(original.get(0));
		original.remove(0);
	}
	for (int i = 0; i <= 9; i++) {
		System.out.println(bucket[i].toString());
	}
}
}
