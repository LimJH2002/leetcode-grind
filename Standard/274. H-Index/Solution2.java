public class Solution2 {
  public int hIndex(int[] citations) {
    int[] buckets = new int[citations.length + 1];
    
    for (int citation : citations) {
      buckets[Math.min(citations.length, citation)]++;
    }

    int cummulativePaper = 0;
    for (int i = buckets.length - 1; i >= 0; i--) {
      cummulativePaper += buckets[i];

      if (cummulativePaper >= i) {
        return i;
      }
    }
    return 0;
  }
}
