package euler.problems;

import java.util.PriorityQueue;

class Problem107 {
	public static void main(String[] args) {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		DDM ddm = new DDM(matrix.length);
		
		int poor = 0;
		for (int i = 0; i < matrix.length; i++) {
			ddm.makeSet(i);
			for (int j = i; j < matrix[i].length; j++)
				if (matrix[i][j] > 0) {
					poor += matrix[i][j];
					queue.add(new Edge(i, j, matrix[i][j]));
				}
		}
		
		int edges = 0, sum = 0;
		Edge tmp;
		do {
			tmp = queue.poll();
			if (ddm.findSet(tmp.node1) != ddm.findSet(tmp.node2)) {
				sum += tmp.weight;
				edges++;
				ddm.union(ddm.findSet(tmp.node1), ddm.findSet(tmp.node2));
			}
		} while (edges < matrix.length - 1);
		
		System.out.println(poor - sum);
	}
	
	private static class DDM {
		private final int[] parent;
		
		public DDM(int size) {
			this.parent = new int[size];
		}
		
		public void makeSet(int v) {
			parent[v] = v;
		}
		
		public void union(int v, int w) {
			parent[v] = w;
		}
		
		public int findSet(int v) {
			int h = v;
			while (parent[h] != h)
				h = parent[h];
			return h;
		}
	}
	
	private static class Edge implements Comparable<Edge> {
		public final Integer weight, node1, node2;
		
		public Edge(int node1, int node2, int weight) {
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return weight.compareTo(o.weight);
		}
	}

	static int[][] matrix = new int[][] {
new int[] { Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,427,668,495,377,678,Integer.MIN_VALUE,177,Integer.MIN_VALUE,Integer.MIN_VALUE,870,Integer.MIN_VALUE,869,624,300,609,131,Integer.MIN_VALUE,251,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,856,221,514,Integer.MIN_VALUE,591,762,182,56,Integer.MIN_VALUE,884,412,273,636,Integer.MIN_VALUE,Integer.MIN_VALUE,774 },
new int[] { Integer.MIN_VALUE,Integer.MIN_VALUE,262,Integer.MIN_VALUE,Integer.MIN_VALUE,508,472,799,Integer.MIN_VALUE,956,578,363,940,143,Integer.MIN_VALUE,162,122,910,Integer.MIN_VALUE,729,802,941,922,573,531,539,667,607,Integer.MIN_VALUE,920,Integer.MIN_VALUE,Integer.MIN_VALUE,315,649,937,Integer.MIN_VALUE,185,102,636,289 },
new int[] { Integer.MIN_VALUE,262,Integer.MIN_VALUE,Integer.MIN_VALUE,926,Integer.MIN_VALUE,958,158,647,47,621,264,81,Integer.MIN_VALUE,402,813,649,386,252,391,264,637,349,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,108,Integer.MIN_VALUE,727,225,578,699,Integer.MIN_VALUE,898,294,Integer.MIN_VALUE,575,168,432,833 },
new int[] { 427,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,366,Integer.MIN_VALUE,Integer.MIN_VALUE,635,Integer.MIN_VALUE,32,962,468,893,854,718,427,448,916,258,Integer.MIN_VALUE,760,909,529,311,404,Integer.MIN_VALUE,Integer.MIN_VALUE,588,680,875,Integer.MIN_VALUE,615,Integer.MIN_VALUE,409,758,221,Integer.MIN_VALUE,Integer.MIN_VALUE,76,257 },
new int[] { 668,Integer.MIN_VALUE,926,366,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,250,268,Integer.MIN_VALUE,503,944,Integer.MIN_VALUE,677,Integer.MIN_VALUE,727,793,457,981,191,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,351,969,925,987,328,282,589,Integer.MIN_VALUE,873,477,Integer.MIN_VALUE,Integer.MIN_VALUE,19,450,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE },
new int[] { 495,508,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,765,711,819,305,302,926,Integer.MIN_VALUE,Integer.MIN_VALUE,582,Integer.MIN_VALUE,861,Integer.MIN_VALUE,683,293,Integer.MIN_VALUE,Integer.MIN_VALUE,66,Integer.MIN_VALUE,27,Integer.MIN_VALUE,Integer.MIN_VALUE,290,Integer.MIN_VALUE,786,Integer.MIN_VALUE,554,817,33,Integer.MIN_VALUE,54,506,386,381 },
new int[] { 377,472,958,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,120,42,Integer.MIN_VALUE,134,219,457,639,538,374,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,966,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,449,120,797,358,232,550,Integer.MIN_VALUE,305,997,662,744,686,239 },
new int[] { 678,799,158,635,250,765,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,35,Integer.MIN_VALUE,106,385,652,160,Integer.MIN_VALUE,890,812,605,953,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,79,Integer.MIN_VALUE,712,613,312,452,Integer.MIN_VALUE,978,900,Integer.MIN_VALUE,901,Integer.MIN_VALUE,Integer.MIN_VALUE,225,533,770,722 },
new int[] { Integer.MIN_VALUE,Integer.MIN_VALUE,647,Integer.MIN_VALUE,268,711,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,283,Integer.MIN_VALUE,172,Integer.MIN_VALUE,663,236,36,403,286,986,Integer.MIN_VALUE,Integer.MIN_VALUE,810,761,574,53,793,Integer.MIN_VALUE,Integer.MIN_VALUE,777,330,936,883,286,Integer.MIN_VALUE,174,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,828,711 },
new int[] { 177,956,47,32,Integer.MIN_VALUE,819,120,35,283,Integer.MIN_VALUE,50,Integer.MIN_VALUE,565,36,767,684,344,489,565,Integer.MIN_VALUE,Integer.MIN_VALUE,103,810,463,733,665,494,644,863,25,385,Integer.MIN_VALUE,342,470,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,730,582,468 },
new int[] { Integer.MIN_VALUE,578,621,962,503,305,42,Integer.MIN_VALUE,Integer.MIN_VALUE,50,Integer.MIN_VALUE,155,519,Integer.MIN_VALUE,Integer.MIN_VALUE,256,990,801,154,53,474,650,402,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,966,Integer.MIN_VALUE,Integer.MIN_VALUE,406,989,772,932,7,Integer.MIN_VALUE,823,391,Integer.MIN_VALUE,Integer.MIN_VALUE,933 },
new int[] { Integer.MIN_VALUE,363,264,468,944,302,Integer.MIN_VALUE,106,172,Integer.MIN_VALUE,155,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,380,438,Integer.MIN_VALUE,41,266,Integer.MIN_VALUE,Integer.MIN_VALUE,104,867,609,Integer.MIN_VALUE,270,861,Integer.MIN_VALUE,Integer.MIN_VALUE,165,Integer.MIN_VALUE,675,250,686,995,366,191,Integer.MIN_VALUE,433,Integer.MIN_VALUE },
new int[] { 870,940,81,893,Integer.MIN_VALUE,926,134,385,Integer.MIN_VALUE,565,519,Integer.MIN_VALUE,Integer.MIN_VALUE,313,851,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,248,220,Integer.MIN_VALUE,826,359,829,Integer.MIN_VALUE,234,198,145,409,68,359,Integer.MIN_VALUE,814,218,186,Integer.MIN_VALUE,Integer.MIN_VALUE,929,203,Integer.MIN_VALUE },
new int[] { Integer.MIN_VALUE,143,Integer.MIN_VALUE,854,677,Integer.MIN_VALUE,219,652,663,36,Integer.MIN_VALUE,Integer.MIN_VALUE,313,Integer.MIN_VALUE,132,Integer.MIN_VALUE,433,598,Integer.MIN_VALUE,Integer.MIN_VALUE,168,870,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,128,437,Integer.MIN_VALUE,383,364,966,227,Integer.MIN_VALUE,Integer.MIN_VALUE,807,993,Integer.MIN_VALUE,Integer.MIN_VALUE,526,17 },
new int[] { 869,Integer.MIN_VALUE,402,718,Integer.MIN_VALUE,Integer.MIN_VALUE,457,160,236,767,Integer.MIN_VALUE,380,851,132,Integer.MIN_VALUE,Integer.MIN_VALUE,596,903,613,730,Integer.MIN_VALUE,261,Integer.MIN_VALUE,142,379,885,89,Integer.MIN_VALUE,848,258,112,Integer.MIN_VALUE,900,Integer.MIN_VALUE,Integer.MIN_VALUE,818,639,268,600,Integer.MIN_VALUE },
new int[] { 624,162,813,427,727,582,639,Integer.MIN_VALUE,36,684,256,438,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,539,379,664,561,542,Integer.MIN_VALUE,999,585,Integer.MIN_VALUE,Integer.MIN_VALUE,321,398,Integer.MIN_VALUE,Integer.MIN_VALUE,950,68,193,Integer.MIN_VALUE,697,Integer.MIN_VALUE,390,588,848,Integer.MIN_VALUE },
new int[] { 300,122,649,448,793,Integer.MIN_VALUE,538,890,403,344,990,Integer.MIN_VALUE,Integer.MIN_VALUE,433,596,539,Integer.MIN_VALUE,Integer.MIN_VALUE,73,Integer.MIN_VALUE,318,Integer.MIN_VALUE,Integer.MIN_VALUE,500,Integer.MIN_VALUE,968,Integer.MIN_VALUE,291,Integer.MIN_VALUE,Integer.MIN_VALUE,765,196,504,757,Integer.MIN_VALUE,542,Integer.MIN_VALUE,395,227,148 },
new int[] { 609,910,386,916,457,861,374,812,286,489,801,41,Integer.MIN_VALUE,598,903,379,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,946,136,399,Integer.MIN_VALUE,941,707,156,757,258,251,Integer.MIN_VALUE,807,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,461,501,Integer.MIN_VALUE,Integer.MIN_VALUE,616,Integer.MIN_VALUE },
new int[] { 131,Integer.MIN_VALUE,252,258,981,Integer.MIN_VALUE,Integer.MIN_VALUE,605,986,565,154,266,248,Integer.MIN_VALUE,613,664,73,Integer.MIN_VALUE,Integer.MIN_VALUE,686,Integer.MIN_VALUE,Integer.MIN_VALUE,575,627,817,282,Integer.MIN_VALUE,698,398,222,Integer.MIN_VALUE,649,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,654,Integer.MIN_VALUE,Integer.MIN_VALUE },
new int[] { Integer.MIN_VALUE,729,391,Integer.MIN_VALUE,191,683,Integer.MIN_VALUE,953,Integer.MIN_VALUE,Integer.MIN_VALUE,53,Integer.MIN_VALUE,220,Integer.MIN_VALUE,730,561,Integer.MIN_VALUE,946,686,Integer.MIN_VALUE,Integer.MIN_VALUE,389,729,553,304,703,455,857,260,Integer.MIN_VALUE,991,182,351,477,867,Integer.MIN_VALUE,Integer.MIN_VALUE,889,217,853 },
new int[] { 251,802,264,760,Integer.MIN_VALUE,293,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,474,Integer.MIN_VALUE,Integer.MIN_VALUE,168,Integer.MIN_VALUE,542,318,136,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,392,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,267,407,27,651,80,927,Integer.MIN_VALUE,974,977,Integer.MIN_VALUE,Integer.MIN_VALUE,457,117,Integer.MIN_VALUE },
new int[] { Integer.MIN_VALUE,941,637,909,Integer.MIN_VALUE,Integer.MIN_VALUE,966,Integer.MIN_VALUE,810,103,650,104,826,870,261,Integer.MIN_VALUE,Integer.MIN_VALUE,399,Integer.MIN_VALUE,389,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,202,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,867,140,403,962,785,Integer.MIN_VALUE,511,Integer.MIN_VALUE,1,Integer.MIN_VALUE,707,Integer.MIN_VALUE },
new int[] { Integer.MIN_VALUE,922,349,529,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,761,810,402,867,359,Integer.MIN_VALUE,Integer.MIN_VALUE,999,Integer.MIN_VALUE,Integer.MIN_VALUE,575,729,392,Integer.MIN_VALUE,Integer.MIN_VALUE,388,939,Integer.MIN_VALUE,959,Integer.MIN_VALUE,83,463,361,Integer.MIN_VALUE,Integer.MIN_VALUE,512,931,Integer.MIN_VALUE,224,690,369,Integer.MIN_VALUE },
new int[] { Integer.MIN_VALUE,573,Integer.MIN_VALUE,311,351,66,Integer.MIN_VALUE,79,574,463,Integer.MIN_VALUE,609,829,Integer.MIN_VALUE,142,585,500,941,627,553,Integer.MIN_VALUE,202,388,Integer.MIN_VALUE,164,829,Integer.MIN_VALUE,620,523,639,936,Integer.MIN_VALUE,Integer.MIN_VALUE,490,Integer.MIN_VALUE,695,Integer.MIN_VALUE,505,109,Integer.MIN_VALUE },
new int[] { 856,531,Integer.MIN_VALUE,404,969,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,53,733,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,379,Integer.MIN_VALUE,Integer.MIN_VALUE,707,817,304,Integer.MIN_VALUE,Integer.MIN_VALUE,939,164,Integer.MIN_VALUE,Integer.MIN_VALUE,616,716,728,Integer.MIN_VALUE,889,349,Integer.MIN_VALUE,963,150,447,Integer.MIN_VALUE,292,586,264 },
new int[] { 221,539,Integer.MIN_VALUE,Integer.MIN_VALUE,925,27,Integer.MIN_VALUE,712,793,665,Integer.MIN_VALUE,270,234,128,885,Integer.MIN_VALUE,968,156,282,703,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,829,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,822,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,736,576,Integer.MIN_VALUE,697,946,443,Integer.MIN_VALUE,205,194 },
new int[] { 514,667,108,Integer.MIN_VALUE,987,Integer.MIN_VALUE,Integer.MIN_VALUE,613,Integer.MIN_VALUE,494,966,861,198,437,89,321,Integer.MIN_VALUE,757,Integer.MIN_VALUE,455,267,Integer.MIN_VALUE,959,Integer.MIN_VALUE,616,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,349,156,339,Integer.MIN_VALUE,102,790,359,Integer.MIN_VALUE,439,938,809,260 },
new int[] { Integer.MIN_VALUE,607,Integer.MIN_VALUE,588,328,Integer.MIN_VALUE,449,312,Integer.MIN_VALUE,644,Integer.MIN_VALUE,Integer.MIN_VALUE,145,Integer.MIN_VALUE,Integer.MIN_VALUE,398,291,258,698,857,407,Integer.MIN_VALUE,Integer.MIN_VALUE,620,716,822,Integer.MIN_VALUE,Integer.MIN_VALUE,293,486,943,Integer.MIN_VALUE,779,Integer.MIN_VALUE,6,880,116,775,Integer.MIN_VALUE,947 },
new int[] { 591,Integer.MIN_VALUE,727,680,282,290,120,452,777,863,Integer.MIN_VALUE,Integer.MIN_VALUE,409,383,848,Integer.MIN_VALUE,Integer.MIN_VALUE,251,398,260,27,867,83,523,728,Integer.MIN_VALUE,349,293,Integer.MIN_VALUE,212,684,505,341,384,9,992,507,48,Integer.MIN_VALUE,Integer.MIN_VALUE },
new int[] { 762,920,225,875,589,Integer.MIN_VALUE,797,Integer.MIN_VALUE,330,25,406,165,68,364,258,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,222,Integer.MIN_VALUE,651,140,463,639,Integer.MIN_VALUE,Integer.MIN_VALUE,156,486,212,Integer.MIN_VALUE,Integer.MIN_VALUE,349,723,Integer.MIN_VALUE,Integer.MIN_VALUE,186,Integer.MIN_VALUE,36,240,752 },
new int[] { 182,Integer.MIN_VALUE,578,Integer.MIN_VALUE,Integer.MIN_VALUE,786,358,978,936,385,989,Integer.MIN_VALUE,359,966,112,950,765,807,Integer.MIN_VALUE,991,80,403,361,936,889,Integer.MIN_VALUE,339,943,684,Integer.MIN_VALUE,Integer.MIN_VALUE,965,302,676,725,Integer.MIN_VALUE,327,134,Integer.MIN_VALUE,147 },
new int[] { 56,Integer.MIN_VALUE,699,615,873,Integer.MIN_VALUE,232,900,883,Integer.MIN_VALUE,772,675,Integer.MIN_VALUE,227,Integer.MIN_VALUE,68,196,Integer.MIN_VALUE,649,182,927,962,Integer.MIN_VALUE,Integer.MIN_VALUE,349,736,Integer.MIN_VALUE,Integer.MIN_VALUE,505,349,965,Integer.MIN_VALUE,474,178,833,Integer.MIN_VALUE,Integer.MIN_VALUE,555,853,Integer.MIN_VALUE },
new int[] { Integer.MIN_VALUE,315,Integer.MIN_VALUE,Integer.MIN_VALUE,477,554,550,Integer.MIN_VALUE,286,342,932,250,814,Integer.MIN_VALUE,900,193,504,Integer.MIN_VALUE,Integer.MIN_VALUE,351,Integer.MIN_VALUE,785,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,576,102,779,341,723,302,474,Integer.MIN_VALUE,689,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,451,Integer.MIN_VALUE,Integer.MIN_VALUE },
new int[] { 884,649,898,409,Integer.MIN_VALUE,817,Integer.MIN_VALUE,901,Integer.MIN_VALUE,470,7,686,218,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,757,Integer.MIN_VALUE,Integer.MIN_VALUE,477,974,Integer.MIN_VALUE,512,490,963,Integer.MIN_VALUE,790,Integer.MIN_VALUE,384,Integer.MIN_VALUE,676,178,689,Integer.MIN_VALUE,245,596,445,Integer.MIN_VALUE,Integer.MIN_VALUE,343 },
new int[] { 412,937,294,758,Integer.MIN_VALUE,33,305,Integer.MIN_VALUE,174,Integer.MIN_VALUE,Integer.MIN_VALUE,995,186,807,Integer.MIN_VALUE,697,Integer.MIN_VALUE,461,Integer.MIN_VALUE,867,977,511,931,Integer.MIN_VALUE,150,697,359,6,9,Integer.MIN_VALUE,725,833,Integer.MIN_VALUE,245,Integer.MIN_VALUE,949,Integer.MIN_VALUE,270,Integer.MIN_VALUE,112 },
new int[] { 273,Integer.MIN_VALUE,Integer.MIN_VALUE,221,19,Integer.MIN_VALUE,997,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,823,366,Integer.MIN_VALUE,993,818,Integer.MIN_VALUE,542,501,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,695,447,946,Integer.MIN_VALUE,880,992,186,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,596,949,Integer.MIN_VALUE,91,Integer.MIN_VALUE,768,273 },
new int[] { 636,185,575,Integer.MIN_VALUE,450,54,662,225,Integer.MIN_VALUE,Integer.MIN_VALUE,391,191,Integer.MIN_VALUE,Integer.MIN_VALUE,639,390,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,1,224,Integer.MIN_VALUE,Integer.MIN_VALUE,443,439,116,507,Integer.MIN_VALUE,327,Integer.MIN_VALUE,Integer.MIN_VALUE,445,Integer.MIN_VALUE,91,Integer.MIN_VALUE,248,Integer.MIN_VALUE,344 },
new int[] { Integer.MIN_VALUE,102,168,Integer.MIN_VALUE,Integer.MIN_VALUE,506,744,533,Integer.MIN_VALUE,730,Integer.MIN_VALUE,Integer.MIN_VALUE,929,Integer.MIN_VALUE,268,588,395,Integer.MIN_VALUE,654,889,457,Integer.MIN_VALUE,690,505,292,Integer.MIN_VALUE,938,775,48,36,134,555,451,Integer.MIN_VALUE,270,Integer.MIN_VALUE,248,Integer.MIN_VALUE,371,680 },
new int[] { Integer.MIN_VALUE,636,432,76,Integer.MIN_VALUE,386,686,770,828,582,Integer.MIN_VALUE,433,203,526,600,848,227,616,Integer.MIN_VALUE,217,117,707,369,109,586,205,809,Integer.MIN_VALUE,Integer.MIN_VALUE,240,Integer.MIN_VALUE,853,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,768,Integer.MIN_VALUE,371,Integer.MIN_VALUE,540 },
new int[] { 774,289,833,257,Integer.MIN_VALUE,381,239,722,711,468,933,Integer.MIN_VALUE,Integer.MIN_VALUE,17,Integer.MIN_VALUE,Integer.MIN_VALUE,148,Integer.MIN_VALUE,Integer.MIN_VALUE,853,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,264,194,260,947,Integer.MIN_VALUE,752,147,Integer.MIN_VALUE,Integer.MIN_VALUE,343,112,273,344,680,540,Integer.MIN_VALUE }
	};
}