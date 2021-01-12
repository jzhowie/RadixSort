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
		original.extend(buckets[i]);
	}
}

public static void radixSortSimple(SortableLinkedList original) {
	SortableLinkedList bucket[] = new SortableLinkedList[10];
	for (int i = 0; i < 10; i++) {
		bucket[i] = new SortableLinkedList();
	}
	int largestLength = 1;
	int size = original.size();
	for (int col = 0; col < largestLength; col++) {
		for (int i = 0; i < size; i++) {
			if (col == 0 && length(original.get(0)) > largestLength) {
				largestLength = length(original.get(0));
			}
			bucket[nth(original.get(0), col)].add(original.get(0));
			original.remove(0);
		}
		merge(original, bucket);
	}
}
}
