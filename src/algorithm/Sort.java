package algorithm;

public class Sort {

	public static void main(String[] args) {
		Sort sort = new Sort();
		Integer[] ar = { 9, 8, 6, 2, 1, 0, 3, 4, 5, 7 };
		sort.BubbleSort(ar);
	}

	public void BubbleSort(Integer ar[]) {
		Integer a[] = ar.clone();
		long currentTime = System.currentTimeMillis();
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		long nowTime = System.currentTimeMillis();
		System.out.println("BubbleSort-----------cost time:" + (nowTime - currentTime));
	}

}
