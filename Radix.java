//TODO: sort
//ISSUES:

public class Radix extends SortableLinkedList {

public static int nth(int n, int col) {
	return (int) (n / Math.pow(10, col)) % 10;
}

public static int length(int n) {
	return (int) Math.log10(Math.abs(n)) + 1;
}

public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
	for (int i = 0; i < buckets.length; i++) {
		original.extend(buckets[i]);
	}
}

public static void radixSortSimple(SortableLinkedList data) {
	SortableLinkedList bucket[] = new SortableLinkedList[10];
	for (int i = 0; i < 10; i++) {
		bucket[i] = new SortableLinkedList();
	}
	int largestLength = 1;
	int size = data.size();
	for (int col = 0; col < largestLength; col++) {
		for (int i = 0; i < size; i++) {
			if (col == 0 && length(data.get(0)) > largestLength) {
				largestLength = length(data.get(0));
			}
			bucket[nth(data.get(0), col)].add(data.get(0));
			data.remove(0);
		}
		merge(data, bucket);
	}
}

public static void radixSort(SortableLinkedList data) {
	SortableLinkedList bucket[] = new SortableLinkedList[10];
	for (int i = 0; i < 10; i++) {
		bucket[i] = new SortableLinkedList();
	}
	int largestLength = 1;
	int size = data.size();

	for (int col = 0; col < largestLength; col++) {
		for (int i = 0; i < size; i++) {
			if (col == 0 && length(data.get(0)) > largestLength) {
				largestLength = length(data.get(0));
			}
			if (data.get(0) > 0) {
				bucket[nth(data.get(0), col)].add(data.get(0));
				data.remove(0);
			}
			else {
				bucket[0].add(data.get(0));
				data.remove(0);
			}
		}
		merge(data, bucket);
	}
}
}
