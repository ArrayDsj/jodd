// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package jodd.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArraysUtilTest {

	int[] x;
	int[] y;

	Long[] xx;
	Long[] yy;
	Object[] oo;

	@Before
	public void setUp() throws Exception {
		x = new int[5];
		xx = new Long[5];
		for (int i = 0; i < x.length; i++) {
			x[i] = i + 1;
			xx[i] = Long.valueOf(x[i]);
		}
		y = new int[3];
		yy = new Long[3];
		for (int i = 0; i < y.length; i++) {
			y[i] = 11 + i;
			yy[i] = Long.valueOf(y[i]);
		}
	}

	@Test
	public void testJoin() {
		assertArrayEquals(new int[] {}, ArraysUtil.join(new int[0]));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, ArraysUtil.join(x));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 11, 12, 13 }, ArraysUtil.join(x, y));
		assertArrayEquals(new long[] { 1, 2, 3, 4, 5, 11, 12, 13 }, ArraysUtil.values(ArraysUtil.join(xx, yy)));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 11, 12, 13, 11, 12, 13 }, ArraysUtil.join(x, y, y));
		assertArrayEquals(new long[] { 1, 2, 3, 4, 5, 11, 12, 13, 11, 12, 13 },
				ArraysUtil.values(ArraysUtil.join(xx, yy, yy)));

		assertArrayEquals(new int[0], ArraysUtil.join(new int[0][]));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, ArraysUtil.join(x));
		assertEquals("[1, 2, 3, 4, 5, 11, 12, 13]", Arrays.toString(ArraysUtil.join(Number.class, new Number[][] { xx, yy })));
		assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(ArraysUtil.join(Number.class, new Number[][] { xx })));
		assertEquals("[]", Arrays.toString(ArraysUtil.join(Number.class, new Number[][] {})));

		assertArrayEquals(new String[0], ArraysUtil.join(new String[0][]));
		assertArrayEquals(new String[] {}, ArraysUtil.join(new String[0]));
		String[] strings1 = new String[] { "f", "o", "o" };
		String[] strings2 = new String[] { "b", "a", "r" };
		assertArrayEquals(new String[] { "f", "o", "o" }, ArraysUtil.join(strings1));
		assertArrayEquals(new String[] { "f", "o", "o", "b", "a", "r" }, ArraysUtil.join(strings1, strings2));

		assertArrayEquals(new byte[0], ArraysUtil.join(new byte[0][]));
		assertArrayEquals(new byte[] {}, ArraysUtil.join(new byte[0]));
		byte[] bytes1 = new byte[] { 1, 2 };
		byte[] bytes2 = new byte[] { 3, 4 };
		assertArrayEquals(new byte[] { 1, 2 }, ArraysUtil.join(bytes1));
		assertArrayEquals(new byte[] { 1, 2, 3, 4 }, ArraysUtil.join(bytes1, bytes2));

		assertArrayEquals(new char[0], ArraysUtil.join(new char[0][]));
		assertArrayEquals(new char[] {}, ArraysUtil.join(new char[0]));
		char[] chars1 = new char[] { 'f', 'o', 'o' };
		char[] chars2 = new char[] { 'b', 'a', 'r' };
		assertArrayEquals(new char[] { 'f', 'o', 'o' }, ArraysUtil.join(chars1));
		assertArrayEquals(new char[] { 'f', 'o', 'o', 'b', 'a', 'r' }, ArraysUtil.join(chars1, chars2));

		assertArrayEquals(new short[0], ArraysUtil.join(new short[0][]));
		assertArrayEquals(new short[] {}, ArraysUtil.join(new short[0]));
		short[] shorts1 = new short[] { 1, 2 };
		short[] shorts2 = new short[] { 3, 4 };
		assertArrayEquals(new short[] { 1, 2 }, ArraysUtil.join(shorts1));
		assertArrayEquals(new short[] { 1, 2, 3, 4 }, ArraysUtil.join(shorts1, shorts2));

		assertArrayEquals(new long[0], ArraysUtil.join(new long[0][]));
		assertArrayEquals(new long[] {}, ArraysUtil.join(new long[0]));
		long[] longs1 = new long[] { 1l, 2l };
		long[] longs2 = new long[] { 3l, 4l };
		assertArrayEquals(new long[] { 1l, 2l }, ArraysUtil.join(longs1));
		assertArrayEquals(new long[] { 1l, 2l, 3l, 4l }, ArraysUtil.join(longs1, longs2));

		assertArrayEquals(new float[0], ArraysUtil.join(new float[0][]), 0);
		assertArrayEquals(new float[] {}, ArraysUtil.join(new float[0]), 0);
		float[] floats1 = new float[] { 1.0f, 2.0f };
		float[] floats2 = new float[] { 3.0f, 4.0f };
		assertArrayEquals(new float[] { 1.0f, 2.0f }, ArraysUtil.join(floats1), 0);
		assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }, ArraysUtil.join(floats1, floats2), 0);

		assertArrayEquals(new double[0], ArraysUtil.join(new double[0][]), 0);
		assertArrayEquals(new double[] {}, ArraysUtil.join(new double[0]), 0);
		double[] doubles1 = new double[] { 1.0, 2.0 };
		double[] doubles2 = new double[] { 3.0, 4.0 };
		assertArrayEquals(new double[] { 1.0, 2.0 }, ArraysUtil.join(doubles1), 0);
		assertArrayEquals(new double[] { 1.0, 2.0, 3.0, 4.0 }, ArraysUtil.join(doubles1, doubles2), 0);

		assertBooleanArrayEquals(new boolean[0], ArraysUtil.join(new boolean[0][]));
		assertBooleanArrayEquals(new boolean[] {}, ArraysUtil.join(new boolean[0]));
		boolean[] booleans1 = new boolean[] { true, true };
		boolean[] booleans2 = new boolean[] { false, false };
		assertBooleanArrayEquals(new boolean[] { true, true }, ArraysUtil.join(booleans1));
		assertBooleanArrayEquals(new boolean[] { true, true, false, false }, ArraysUtil.join(booleans1, booleans2));
	}

	@Test
	public void testAppend() {
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 100 }, ArraysUtil.append(x, 100));
		assertArrayEquals(new long[] { 1, 2, 3, 4, 5, 100 }, ArraysUtil.values(ArraysUtil.append(xx, Long.valueOf(100))));
		assertArrayEquals(new String[] { "f", "o", "o" }, ArraysUtil.append(new String[] { "f", "o" }, "o"));
		assertArrayEquals(new byte[] { 1, 2, 3 }, ArraysUtil.append(new byte[] { 1, 2 }, (byte) 3));
		assertArrayEquals(new char[] { 'f', 'o', 'o' }, ArraysUtil.append(new char[] { 'f', 'o' }, 'o'));
		assertArrayEquals(new short[] { 1, 2, 3 }, ArraysUtil.append(new short[] { 1, 2 }, (short) 3));
		assertArrayEquals(new long[] { 1, 2, 3 }, ArraysUtil.append(new long[] { 1, 2 }, 3l));
		assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f }, ArraysUtil.append(new float[] { 1.0f, 2.0f }, 3.0f), 0);
		assertArrayEquals(new double[] { 1.0, 2.0, 3.0 }, ArraysUtil.append(new double[] { 1.0, 2.0 }, 3.0), 0);
		assertBooleanArrayEquals(new boolean[] { true, true, false }, ArraysUtil.append(new boolean[] { true, true }, false));
	}

	@Test
	public void testResize() {
		assertArrayEquals(new int[] { 1, 2, 3 }, ArraysUtil.resize(x, 3));
		assertArrayEquals(new long[] { 1, 2, 3 }, ArraysUtil.values(ArraysUtil.resize(xx, 3)));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 0, 0 }, ArraysUtil.resize(x, 7));
		assertArrayEquals(new long[] { 1, 2, 3, 4, 5, 0, 0 }, ArraysUtil.values(ArraysUtil.resize(xx, 7)));
		assertArrayEquals(new int[] {}, ArraysUtil.resize(x, 0));

		String[] strings1 = new String[] { "f", "o", "o" };
		String[] strings2 = new String[] { "f", "o", "o", "b", "a", "r" };
		assertArrayEquals(new String[] { "f", "o", "o" }, ArraysUtil.resize(strings1, 3));
		assertArrayEquals(new String[] { "f", "o", "o" }, ArraysUtil.resize(strings2, 3));
		assertArrayEquals(new String[] { "f", "o", "o", null, null }, ArraysUtil.resize(strings1, 5));
		assertArrayEquals(new String[] {}, ArraysUtil.resize(strings1, 0));

		byte[] bytes1 = new byte[] { 1, 2 };
		byte[] bytes2 = new byte[] { 1, 2, 3, 4 };
		assertArrayEquals(new byte[] { 1, 2 }, ArraysUtil.resize(bytes1, 2));
		assertArrayEquals(new byte[] { 1, 2, 3 }, ArraysUtil.resize(bytes2, 3));
		assertArrayEquals(new byte[] { 1, 2, 0, 0, 0 }, ArraysUtil.resize(bytes1, 5));
		assertArrayEquals(new byte[] {}, ArraysUtil.resize(bytes1, 0));

		char[] chars1 = new char[] { 'f', 'o', 'o' };
		char[] chars2 = new char[] { 'f', 'o', 'o', 'b', 'a', 'r' };
		assertArrayEquals(new char[] { 'f', 'o', 'o' }, ArraysUtil.resize(chars1, 3));
		assertArrayEquals(new char[] { 'f', 'o', 'o' }, ArraysUtil.resize(chars2, 3));
		assertArrayEquals(new char[] { 'f', 'o', 'o', 0, 0 }, ArraysUtil.resize(chars1, 5));
		assertArrayEquals(new char[] {}, ArraysUtil.resize(chars1, 0));

		short[] shorts1 = new short[] { 1, 2 };
		short[] shorts2 = new short[] { 1, 2, 3, 4 };
		assertArrayEquals(new short[] { 1, 2 }, ArraysUtil.resize(shorts1, 2));
		assertArrayEquals(new short[] { 1, 2, 3 }, ArraysUtil.resize(shorts2, 3));
		assertArrayEquals(new short[] { 1, 2, 0, 0, 0 }, ArraysUtil.resize(shorts1, 5));
		assertArrayEquals(new short[] {}, ArraysUtil.resize(shorts1, 0));

		long[] longs1 = new long[] { 1l, 2l };
		long[] longs2 = new long[] { 1l, 2l, 3l, 4l };
		assertArrayEquals(new long[] { 1, 2 }, ArraysUtil.resize(longs1, 2));
		assertArrayEquals(new long[] { 1, 2, 3 }, ArraysUtil.resize(longs2, 3));
		assertArrayEquals(new long[] { 1, 2, 0, 0, 0 }, ArraysUtil.resize(longs1, 5));
		assertArrayEquals(new long[] {}, ArraysUtil.resize(longs1, 0));

		float[] floats1 = new float[] { 1.0f, 2.0f };
		float[] floats2 = new float[] { 1.0f, 2.0f, 3.0f, 4.0f };
		assertArrayEquals(new float[] { 1.0f, 2.0f }, ArraysUtil.resize(floats1, 2), 0);
		assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f }, ArraysUtil.resize(floats2, 3), 0);
		assertArrayEquals(new float[] { 1.0f, 2.0f, 0, 0, 0 }, ArraysUtil.resize(floats1, 5), 0);
		assertArrayEquals(new float[] {}, ArraysUtil.resize(floats1, 0), 0);

		double[] doubles1 = new double[] { 1.0, 2.0 };
		double[] doubles2 = new double[] { 1.0, 2.0, 3.0, 4.0 };
		assertArrayEquals(new double[] { 1.0, 2.0 }, ArraysUtil.resize(doubles1, 2), 0);
		assertArrayEquals(new double[] { 1.0, 2.0, 3.0 }, ArraysUtil.resize(doubles2, 3), 0);
		assertArrayEquals(new double[] { 1.0, 2.0, 0, 0, 0 }, ArraysUtil.resize(doubles1, 5), 0);
		assertArrayEquals(new double[] {}, ArraysUtil.resize(doubles1, 0), 0);

		boolean[] booleans1 = new boolean[] { true, true };
		boolean[] booleans2 = new boolean[] { true, true, false, false };
		assertBooleanArrayEquals(new boolean[] { true, true }, ArraysUtil.resize(booleans1, 2));
		assertBooleanArrayEquals(new boolean[] { true, true, false }, ArraysUtil.resize(booleans2, 3));
		assertBooleanArrayEquals(new boolean[] { true, true, false, false, false }, ArraysUtil.resize(booleans1, 5));
		assertBooleanArrayEquals(new boolean[] {}, ArraysUtil.resize(booleans1, 0));
	}

	@Test
	public void testSub() {
		assertArrayEquals(new int[] { 2, 3, 4 }, ArraysUtil.subarray(x, 1, 3));
		assertArrayEquals(new long[] { 2, 3, 4 }, ArraysUtil.values(ArraysUtil.subarray(xx, 1, 3)));
		assertArrayEquals(new String[] { "f", "o", "o" }, ArraysUtil.subarray(new String[] { "f", "o", "o", "b", "a", "r" }, 0, 3));
		assertArrayEquals(new byte[] { 2, 3 }, ArraysUtil.subarray(new byte[] { 1, 2, 3 }, 1, 2));
		assertArrayEquals(new char[] { 'f', 'o', 'o' }, ArraysUtil.subarray(new char[] { 'f', 'o', 'o', 'b', 'a', 'r' }, 0, 3));
		assertArrayEquals(new short[] { 2, 3 }, ArraysUtil.subarray(new short[] { 1, 2, 3 }, 1, 2));
		assertArrayEquals(new long[] { 2l, 3l }, ArraysUtil.subarray(new long[] { 1l, 2l, 3l }, 1, 2));
		assertArrayEquals(new float[] { 2.0f, 3.0f }, ArraysUtil.subarray(new float[] { 1.0f, 2.0f, 3.0f }, 1, 2), 0);
		assertArrayEquals(new double[] { 2.0, 3.0 }, ArraysUtil.subarray(new double[] { 1.0, 2.0, 3.0 }, 1, 2), 0);
		assertBooleanArrayEquals(new boolean[] { true, false }, ArraysUtil.subarray(new boolean[] { true, true, false, false }, 1, 2));
	}

	@Test
	public void testInsert() {
		assertArrayEquals(new int[] { 1, 2, 3, 11, 12, 13, 4, 5 }, ArraysUtil.insert(x, y, 3));
		assertArrayEquals(new int[] { 11, 12, 13, 1, 2, 3, 4, 5 }, ArraysUtil.insert(x, y, 0));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 11, 12, 13 }, ArraysUtil.insert(x, y, 5));
		assertArrayEquals(new int[] { 1, 2, 3, 173, 4, 5 }, ArraysUtil.insert(x, 173, 3));
		assertArrayEquals(new int[] { 173, 1, 2, 3, 4, 5 }, ArraysUtil.insert(x, 173, 0));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 173 }, ArraysUtil.insert(x, 173, 5));

		Integer[] integers1 = new Integer[] { 1, 2, 3, 4, 5 };
		Integer[] integers2 = new Integer[] { 11, 12, 13 };
		assertArrayEquals(new Integer[] { 1, 2, 3, 11, 12, 13, 4, 5 }, ArraysUtil.insert(integers1, integers2, 3));
		assertArrayEquals(new Integer[] { 11, 12, 13, 1, 2, 3, 4, 5 }, ArraysUtil.insert(integers1, integers2, 0));
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 11, 12, 13 }, ArraysUtil.insert(integers1, integers2, 5));
		assertArrayEquals(new Integer[] { 1, 2, 3, 173, 4, 5 }, ArraysUtil.insert(integers1, 173, 3));
		assertArrayEquals(new Integer[] { 173, 1, 2, 3, 4, 5 }, ArraysUtil.insert(integers1, 173, 0));
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 173 }, ArraysUtil.insert(integers1, 173, 5));

		String[] strings1 = new String[] { "f", "o", "o" };
		String[] strings2 = new String[] { "b", "a", "r" };
		assertArrayEquals(new String[] { "b", "a", "r", "f", "o", "o" }, ArraysUtil.insert(strings1, strings2, 0));
		assertArrayEquals(new String[] { "f", "o", "o", "b", "a", "r" }, ArraysUtil.insert(strings1, strings2, 3));
		assertArrayEquals(new String[] { "f", "b", "a", "r", "o", "o" }, ArraysUtil.insert(strings1, strings2, 1));
		assertArrayEquals(new String[] { "bar", "f", "o", "o" }, ArraysUtil.insert(strings1, "bar", 0));
		assertArrayEquals(new String[] { "f", "o", "o", "bar" }, ArraysUtil.insert(strings1, "bar", 3));
		assertArrayEquals(new String[] { "f", "bar", "o", "o" }, ArraysUtil.insert(strings1, "bar", 1));

		byte[] bytes1 = new byte[] { 1, 2 };
		byte[] bytes2 = new byte[] { 3, 4 };
		assertArrayEquals(new byte[] { 1, 2, 3, 4 }, ArraysUtil.insert(bytes1, bytes2, 2));
		assertArrayEquals(new byte[] { 1, 3, 4, 2 }, ArraysUtil.insert(bytes1, bytes2, 1));
		assertArrayEquals(new byte[] { 3, 4, 1, 2 }, ArraysUtil.insert(bytes1, bytes2, 0));
		assertArrayEquals(new byte[] { 1, 2, 3 }, ArraysUtil.insert(bytes1, (byte) 3, 2));
		assertArrayEquals(new byte[] { 1, 3, 2 }, ArraysUtil.insert(bytes1, (byte) 3, 1));
		assertArrayEquals(new byte[] { 3, 1, 2 }, ArraysUtil.insert(bytes1, (byte) 3, 0));

		char[] chars1 = new char[] { 'f', 'o', 'o' };
		char[] chars2 = new char[] { 'b', 'a', 'r' };
		assertArrayEquals(new char[] { 'b', 'a', 'r', 'f', 'o', 'o' }, ArraysUtil.insert(chars1, chars2, 0));
		assertArrayEquals(new char[] { 'f', 'o', 'o', 'b', 'a', 'r' }, ArraysUtil.insert(chars1, chars2, 3));
		assertArrayEquals(new char[] { 'f', 'b', 'a', 'r', 'o', 'o' }, ArraysUtil.insert(chars1, chars2, 1));
		assertArrayEquals(new char[] { 'b', 'f', 'o', 'o' }, ArraysUtil.insert(chars1, 'b', 0));
		assertArrayEquals(new char[] { 'f', 'o', 'o', 'b' }, ArraysUtil.insert(chars1, 'b', 3));
		assertArrayEquals(new char[] { 'f', 'b', 'o', 'o' }, ArraysUtil.insert(chars1, 'b', 1));

		short[] shorts1 = new short[] { 1, 2, 3, 4, 5 };
		short[] shorts2 = new short[] { 11, 12, 13 };
		assertArrayEquals(new short[] { 1, 2, 3, 11, 12, 13, 4, 5 }, ArraysUtil.insert(shorts1, shorts2, 3));
		assertArrayEquals(new short[] { 11, 12, 13, 1, 2, 3, 4, 5 }, ArraysUtil.insert(shorts1, shorts2, 0));
		assertArrayEquals(new short[] { 1, 2, 3, 4, 5, 11, 12, 13 }, ArraysUtil.insert(shorts1, shorts2, 5));
		assertArrayEquals(new short[] { 1, 2, 3, 173, 4, 5 }, ArraysUtil.insert(shorts1, (short) 173, 3));
		assertArrayEquals(new short[] { 173, 1, 2, 3, 4, 5 }, ArraysUtil.insert(shorts1, (short) 173, 0));
		assertArrayEquals(new short[] { 1, 2, 3, 4, 5, 173 }, ArraysUtil.insert(shorts1, (short) 173, 5));

		long[] longs1 = new long[] { 1, 2, 3, 4, 5 };
		long[] longs2 = new long[] { 11, 12, 13 };
		assertArrayEquals(new long[] { 1, 2, 3, 11, 12, 13, 4, 5 }, ArraysUtil.insert(longs1, longs2, 3));
		assertArrayEquals(new long[] { 11, 12, 13, 1, 2, 3, 4, 5 }, ArraysUtil.insert(longs1, longs2, 0));
		assertArrayEquals(new long[] { 1, 2, 3, 4, 5, 11, 12, 13 }, ArraysUtil.insert(longs1, longs2, 5));
		assertArrayEquals(new long[] { 1, 2, 3, 173, 4, 5 }, ArraysUtil.insert(longs1, 173, 3));
		assertArrayEquals(new long[] { 173, 1, 2, 3, 4, 5 }, ArraysUtil.insert(longs1, 173, 0));
		assertArrayEquals(new long[] { 1, 2, 3, 4, 5, 173 }, ArraysUtil.insert(longs1, 173, 5));

		float[] floats1 = new float[] { 1, 2, 3, 4, 5 };
		float[] floats2 = new float[] { 11, 12, 13 };
		assertArrayEquals(new float[] { 1, 2, 3, 11, 12, 13, 4, 5 }, ArraysUtil.insert(floats1, floats2, 3), 0);
		assertArrayEquals(new float[] { 11, 12, 13, 1, 2, 3, 4, 5 }, ArraysUtil.insert(floats1, floats2, 0), 0);
		assertArrayEquals(new float[] { 1, 2, 3, 4, 5, 11, 12, 13 }, ArraysUtil.insert(floats1, floats2, 5), 0);
		assertArrayEquals(new float[] { 1, 2, 3, 173, 4, 5 }, ArraysUtil.insert(floats1, 173, 3), 0);
		assertArrayEquals(new float[] { 173, 1, 2, 3, 4, 5 }, ArraysUtil.insert(floats1, 173, 0), 0);
		assertArrayEquals(new float[] { 1, 2, 3, 4, 5, 173 }, ArraysUtil.insert(floats1, 173, 5), 0);

		double[] doubles1 = new double[] { 1, 2, 3, 4, 5 };
		double[] doubles2 = new double[] { 11, 12, 13 };
		assertArrayEquals(new double[] { 1, 2, 3, 11, 12, 13, 4, 5 }, ArraysUtil.insert(doubles1, doubles2, 3), 0);
		assertArrayEquals(new double[] { 11, 12, 13, 1, 2, 3, 4, 5 }, ArraysUtil.insert(doubles1, doubles2, 0), 0);
		assertArrayEquals(new double[] { 1, 2, 3, 4, 5, 11, 12, 13 }, ArraysUtil.insert(doubles1, doubles2, 5), 0);
		assertArrayEquals(new double[] { 1, 2, 3, 173, 4, 5 }, ArraysUtil.insert(doubles1, 173, 3), 0);
		assertArrayEquals(new double[] { 173, 1, 2, 3, 4, 5 }, ArraysUtil.insert(doubles1, 173, 0), 0);
		assertArrayEquals(new double[] { 1, 2, 3, 4, 5, 173 }, ArraysUtil.insert(doubles1, 173, 5), 0);

		boolean[] booleans1 = new boolean[] { true, true, true };
		boolean[] booleans2 = new boolean[] { false, false };
		assertBooleanArrayEquals(new boolean[] { true, false, false, true, true }, ArraysUtil.insert(booleans1, booleans2, 1));
		assertBooleanArrayEquals(new boolean[] { false, false, true, true, true }, ArraysUtil.insert(booleans1, booleans2, 0));
		assertBooleanArrayEquals(new boolean[] { true, true, true, false, false }, ArraysUtil.insert(booleans1, booleans2, 3));
		assertBooleanArrayEquals(new boolean[] { true, false, true, true }, ArraysUtil.insert(booleans1, false, 1));
		assertBooleanArrayEquals(new boolean[] { false, true, true, true }, ArraysUtil.insert(booleans1, false, 0));
		assertBooleanArrayEquals(new boolean[] { true, true, true, false }, ArraysUtil.insert(booleans1, false, 3));
	}

	@Test
	public void testInsertAt() {
		assertArrayEquals(new int[] { 1, 2, 3, 11, 12, 13, 5 }, ArraysUtil.insertAt(x, y, 3));
		assertArrayEquals(new int[] { 11, 12, 13, 2, 3, 4, 5 }, ArraysUtil.insertAt(x, y, 0));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 11, 12, 13 }, ArraysUtil.insertAt(x, y, 4));

		Integer[] integers1 = new Integer[] { 1, 2, 3, 4, 5 };
		Integer[] integers2 = new Integer[] { 11, 12, 13 };
		assertArrayEquals(new Integer[] { 1, 2, 3, 11, 12, 13, 5 }, ArraysUtil.insertAt(integers1, integers2, 3));
		assertArrayEquals(new Integer[] { 11, 12, 13, 2, 3, 4, 5 }, ArraysUtil.insertAt(integers1, integers2, 0));
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 11, 12, 13 }, ArraysUtil.insertAt(integers1, integers2, 4));
		assertArrayEquals(new Integer[] { 1, 2, 3, 11, 12, 13, 5 },
				ArraysUtil.insertAt(integers1, integers2, 3, Integer.class));

		String[] strings1 = new String[] { "f", "o", "o" };
		String[] strings2 = new String[] { "b", "a", "r" };
		assertArrayEquals(new String[] { "b", "a", "r", "o", "o" }, ArraysUtil.insertAt(strings1, strings2, 0));
		assertArrayEquals(new String[] { "f", "o", "b", "a", "r" }, ArraysUtil.insertAt(strings1, strings2, 2));
		assertArrayEquals(new String[] { "f", "b", "a", "r", "o" }, ArraysUtil.insertAt(strings1, strings2, 1));

		byte[] bytes1 = new byte[] { 1, 2, 3, 4, 5 };
		byte[] bytes2 = new byte[] { 11, 12, 13 };
		assertArrayEquals(new byte[] { 1, 2, 3, 11, 12, 13, 5 }, ArraysUtil.insertAt(bytes1, bytes2, 3));
		assertArrayEquals(new byte[] { 11, 12, 13, 2, 3, 4, 5 }, ArraysUtil.insertAt(bytes1, bytes2, 0));
		assertArrayEquals(new byte[] { 1, 2, 3, 4, 11, 12, 13 }, ArraysUtil.insertAt(bytes1, bytes2, 4));

		char[] chars1 = new char[] { 'f', 'o', 'o' };
		char[] chars2 = new char[] { 'b', 'a', 'r' };
		assertArrayEquals(new char[] { 'b', 'a', 'r', 'o', 'o' }, ArraysUtil.insertAt(chars1, chars2, 0));
		assertArrayEquals(new char[] { 'f', 'o', 'b', 'a', 'r' }, ArraysUtil.insertAt(chars1, chars2, 2));
		assertArrayEquals(new char[] { 'f', 'b', 'a', 'r', 'o' }, ArraysUtil.insertAt(chars1, chars2, 1));

		short[] shorts1 = new short[] { 1, 2, 3, 4, 5 };
		short[] shorts2 = new short[] { 11, 12, 13 };
		assertArrayEquals(new short[] { 1, 2, 3, 11, 12, 13, 5 }, ArraysUtil.insertAt(shorts1, shorts2, 3));
		assertArrayEquals(new short[] { 11, 12, 13, 2, 3, 4, 5 }, ArraysUtil.insertAt(shorts1, shorts2, 0));
		assertArrayEquals(new short[] { 1, 2, 3, 4, 11, 12, 13 }, ArraysUtil.insertAt(shorts1, shorts2, 4));

		long[] longs1 = new long[] { 1, 2, 3, 4, 5 };
		long[] longs2 = new long[] { 11, 12, 13 };
		assertArrayEquals(new long[] { 1, 2, 3, 11, 12, 13, 5 }, ArraysUtil.insertAt(longs1, longs2, 3));
		assertArrayEquals(new long[] { 11, 12, 13, 2, 3, 4, 5 }, ArraysUtil.insertAt(longs1, longs2, 0));
		assertArrayEquals(new long[] { 1, 2, 3, 4, 11, 12, 13 }, ArraysUtil.insertAt(longs1, longs2, 4));

		float[] floats1 = new float[] { 1, 2, 3, 4, 5 };
		float[] floats2 = new float[] { 11, 12, 13 };
		assertArrayEquals(new float[] { 1, 2, 3, 11, 12, 13, 5 }, ArraysUtil.insertAt(floats1, floats2, 3), 0);
		assertArrayEquals(new float[] { 11, 12, 13, 2, 3, 4, 5 }, ArraysUtil.insertAt(floats1, floats2, 0), 0);
		assertArrayEquals(new float[] { 1, 2, 3, 4, 11, 12, 13 }, ArraysUtil.insertAt(floats1, floats2, 4), 0);

		double[] doubles1 = new double[] { 1, 2, 3, 4, 5 };
		double[] doubles2 = new double[] { 11, 12, 13 };
		assertArrayEquals(new double[] { 1, 2, 3, 11, 12, 13, 5 }, ArraysUtil.insertAt(doubles1, doubles2, 3), 0);
		assertArrayEquals(new double[] { 11, 12, 13, 2, 3, 4, 5 }, ArraysUtil.insertAt(doubles1, doubles2, 0), 0);
		assertArrayEquals(new double[] { 1, 2, 3, 4, 11, 12, 13 }, ArraysUtil.insertAt(doubles1, doubles2, 4), 0);

		boolean[] booleans1 = new boolean[] { true, true, true };
		boolean[] booleans2 = new boolean[] { false, false };
		assertBooleanArrayEquals(new boolean[] { true, true, false, false }, ArraysUtil.insertAt(booleans1, booleans2, 2));
		assertBooleanArrayEquals(new boolean[] { false, false, true, true }, ArraysUtil.insertAt(booleans1, booleans2, 0));
		assertBooleanArrayEquals(new boolean[] { true, false, false, true }, ArraysUtil.insertAt(booleans1, booleans2, 1));
	}


	@Test
	public void testIndexOf() {
		Assert.assertEquals(0, ArraysUtil.indexOf(x, 1));
		Assert.assertEquals(1, ArraysUtil.indexOf(x, 2));
		Assert.assertEquals(4, ArraysUtil.indexOf(x, 5));
		Assert.assertEquals(-1, ArraysUtil.indexOf(x, 6));
		Assert.assertEquals(0, ArraysUtil.indexOf(x, 1, 0));
		Assert.assertEquals(-1, ArraysUtil.indexOf(x, 1, 2));
		Assert.assertEquals(0, ArraysUtil.indexOf(x, 1, 0, 3));
		Assert.assertEquals(-1, ArraysUtil.indexOf(x, 1, 2, 2));

		Assert.assertEquals(1, ArraysUtil.indexOf(xx, Long.valueOf(2)));
		Assert.assertEquals(-1, ArraysUtil.indexOf(xx, Long.valueOf(12)));
		Assert.assertEquals(1, ArraysUtil.indexOf(yy, Long.valueOf(12)));
		Assert.assertEquals(-1, ArraysUtil.indexOf(yy, Long.valueOf(12), 2));
		Assert.assertEquals(1, ArraysUtil.indexOf(yy, Long.valueOf(12), 1));

		byte[] bytes = new byte[] { 0, 1, 2 };
		Assert.assertEquals(1, ArraysUtil.indexOf(bytes, (byte) 1));
		Assert.assertEquals(-1, ArraysUtil.indexOf(bytes, (byte) 3));
		Assert.assertEquals(1, ArraysUtil.indexOf(bytes, (byte) 1, 1));
		Assert.assertEquals(-1, ArraysUtil.indexOf(bytes, (byte) 1, 2));
		Assert.assertEquals(1, ArraysUtil.indexOf(bytes, (byte) 1, 1, 2));
		Assert.assertEquals(-1, ArraysUtil.indexOf(bytes, (byte) 1, 2, 2));

		char[] chars = new char[] { 'f', 'o', 'o' };
		Assert.assertEquals(0, ArraysUtil.indexOf(chars, 'f'));
		Assert.assertEquals(-1, ArraysUtil.indexOf(chars, 'a'));
		Assert.assertEquals(1, ArraysUtil.indexOf(new char[] { 'f', 'o', 'o', 'b', 'a' }, 'o', 1));
		Assert.assertEquals(-1, ArraysUtil.indexOf(chars, 'f', 2));
		Assert.assertEquals(1, ArraysUtil.indexOf(chars, 'o', 1, 2));
		Assert.assertEquals(-1, ArraysUtil.indexOf(chars, 'o', 2, 2));

		short[] shorts = new short[] { 0, 1, 2 };
		Assert.assertEquals(1, ArraysUtil.indexOf(shorts, (short) 1));
		Assert.assertEquals(-1, ArraysUtil.indexOf(shorts, (short) 3));
		Assert.assertEquals(1, ArraysUtil.indexOf(shorts, (short) 1, 1));
		Assert.assertEquals(-1, ArraysUtil.indexOf(shorts, (short) 1, 2));
		Assert.assertEquals(1, ArraysUtil.indexOf(shorts, (short) 1, 1, 2));
		Assert.assertEquals(-1, ArraysUtil.indexOf(shorts, (short) 1, 2, 2));

		long[] longs = new long[] { 0, 1, 2 };
		Assert.assertEquals(1, ArraysUtil.indexOf(longs, 1));
		Assert.assertEquals(-1, ArraysUtil.indexOf(longs, 3));
		Assert.assertEquals(1, ArraysUtil.indexOf(longs, 1, 1));
		Assert.assertEquals(-1, ArraysUtil.indexOf(longs, 1, 2));
		Assert.assertEquals(1, ArraysUtil.indexOf(longs, 1, 1, 2));
		Assert.assertEquals(-1, ArraysUtil.indexOf(longs, 1, 2, 2));

		float[] floats = new float[] { 0, 1, 2 };
		Assert.assertEquals(1, ArraysUtil.indexOf(floats, 1));
		Assert.assertEquals(-1, ArraysUtil.indexOf(floats, 3));
		Assert.assertEquals(1, ArraysUtil.indexOf(floats, 1, 1));
		Assert.assertEquals(-1, ArraysUtil.indexOf(floats, 1, 2));
		Assert.assertEquals(1, ArraysUtil.indexOf(floats, 1, 1, 2));
		Assert.assertEquals(-1, ArraysUtil.indexOf(floats, 1, 2, 2));

		double[] doubles = new double[] { 0, 1, 2 };
		Assert.assertEquals(1, ArraysUtil.indexOf(doubles, 1));
		Assert.assertEquals(-1, ArraysUtil.indexOf(doubles, 3));
		Assert.assertEquals(1, ArraysUtil.indexOf(doubles, 1, 1));
		Assert.assertEquals(-1, ArraysUtil.indexOf(doubles, 1, 2));
		Assert.assertEquals(1, ArraysUtil.indexOf(doubles, 1, 1, 2));
		Assert.assertEquals(-1, ArraysUtil.indexOf(doubles, 1, 2, 2));

		boolean[] boolenas = new boolean[] { true, true, true };
		Assert.assertEquals(0, ArraysUtil.indexOf(boolenas, true));
		Assert.assertEquals(-1, ArraysUtil.indexOf(boolenas, false));
		Assert.assertEquals(1, ArraysUtil.indexOf(boolenas, true, 1));
		Assert.assertEquals(1, ArraysUtil.indexOf(boolenas, true, 1, 2));
		Assert.assertEquals(-1, ArraysUtil.indexOf(boolenas, true, 2, 2));
		Assert.assertEquals(-1, ArraysUtil.indexOf(new boolean[] { true, true, true, false }, true, 3));
	}

	@Test
	public void testIndexOf2() {
		Assert.assertEquals(0, ArraysUtil.indexOf(x, new int[] {}));
		Assert.assertEquals(0, ArraysUtil.indexOf(x, new int[] { 1, 2, 3 }));
		Assert.assertEquals(-1, ArraysUtil.indexOf(x, new int[] { 1, 2, 3, 7 }));
		Assert.assertEquals(1, ArraysUtil.indexOf(x, new int[] { 2, 3 }));
		Assert.assertEquals(4, ArraysUtil.indexOf(x, new int[] { 5 }));
		Assert.assertEquals(0, ArraysUtil.indexOf(x, new int[] { 1, 2, 3 }, 0));
		Assert.assertEquals(0, ArraysUtil.indexOf(x, new int[] { 1, 2, 3 }, 0, 3));

		byte[] bytes = new byte[] { 0, 1, 2 };
		Assert.assertEquals(0, ArraysUtil.indexOf(bytes, new byte[] { 0, 1 }));
		Assert.assertEquals(-1, ArraysUtil.indexOf(bytes, new byte[] { 0, 1, 2, 7 }));
		Assert.assertEquals(0, ArraysUtil.indexOf(bytes, new byte[] {}, 0, 3));
		Assert.assertEquals(1, ArraysUtil.indexOf(bytes, new byte[] { 1, 2 }, 1));
		Assert.assertEquals(2, ArraysUtil.indexOf(bytes, new byte[] { 2 }, 1, 3));
		Assert.assertEquals(-1, ArraysUtil.indexOf(bytes, new byte[] { 1, 3 }, 1, 3));

		char[] chars = new char[] { 'b', 'a', 'r' };
		Assert.assertEquals(0, ArraysUtil.indexOf(chars, new char[] { 'b', 'a' }));
		Assert.assertEquals(-1, ArraysUtil.indexOf(chars, new char[] { 'b', 'a', 'r', 'z' }));
		Assert.assertEquals(0, ArraysUtil.indexOf(chars, new char[] {}, 0, 3));
		Assert.assertEquals(1, ArraysUtil.indexOf(chars, new char[] { 'a', 'r' }, 1));
		Assert.assertEquals(2, ArraysUtil.indexOf(chars, new char[] { 'r' }, 1, 3));
		Assert.assertEquals(-1, ArraysUtil.indexOf(chars, new char[] { 'a', 'z' }, 1, 3));

		short[] shorts = new short[] { 0, 1, 2 };
		Assert.assertEquals(0, ArraysUtil.indexOf(shorts, new short[] { 0, 1 }));
		Assert.assertEquals(-1, ArraysUtil.indexOf(shorts, new short[] { 0, 1, 2, 7 }));
		Assert.assertEquals(0, ArraysUtil.indexOf(shorts, new short[] {}, 0, 3));
		Assert.assertEquals(1, ArraysUtil.indexOf(shorts, new short[] { 1, 2 }, 1));
		Assert.assertEquals(2, ArraysUtil.indexOf(shorts, new short[] { 2 }, 1, 3));
		Assert.assertEquals(-1, ArraysUtil.indexOf(shorts, new short[] { 1, 3 }, 1, 3));

		long[] longs = new long[] { 0, 1, 2 };
		Assert.assertEquals(0, ArraysUtil.indexOf(longs, new long[] { 0, 1 }));
		Assert.assertEquals(-1, ArraysUtil.indexOf(longs, new long[] { 0, 1, 2, 7 }));
		Assert.assertEquals(0, ArraysUtil.indexOf(longs, new long[] {}, 0, 3));
		Assert.assertEquals(1, ArraysUtil.indexOf(longs, new long[] { 1, 2 }, 1));
		Assert.assertEquals(2, ArraysUtil.indexOf(longs, new long[] { 2 }, 1, 3));
		Assert.assertEquals(-1, ArraysUtil.indexOf(longs, new long[] { 1, 3 }, 1, 3));

		float[] floats = new float[] { 0, 1, 2 };
		Assert.assertEquals(0, ArraysUtil.indexOf(floats, new float[] { 0, 1 }));
		Assert.assertEquals(-1, ArraysUtil.indexOf(floats, new float[] { 0, 1, 2, 7 }));
		Assert.assertEquals(0, ArraysUtil.indexOf(floats, new float[] {}, 0, 3));
		Assert.assertEquals(1, ArraysUtil.indexOf(floats, new float[] { 1, 2 }, 1));
		Assert.assertEquals(2, ArraysUtil.indexOf(floats, new float[] { 2 }, 1, 3));
		Assert.assertEquals(-1, ArraysUtil.indexOf(floats, new float[] { 1, 3 }, 1, 3));

		double[] doubles = new double[] { 0, 1, 2 };
		Assert.assertEquals(0, ArraysUtil.indexOf(doubles, new double[] { 0, 1 }));
		Assert.assertEquals(-1, ArraysUtil.indexOf(doubles, new double[] { 0, 1, 2, 7 }));
		Assert.assertEquals(0, ArraysUtil.indexOf(doubles, new double[] {}, 0, 3));
		Assert.assertEquals(1, ArraysUtil.indexOf(doubles, new double[] { 1, 2 }, 1));
		Assert.assertEquals(2, ArraysUtil.indexOf(doubles, new double[] { 2 }, 1, 3));
		Assert.assertEquals(-1, ArraysUtil.indexOf(doubles, new double[] { 1, 3 }, 1, 3));

		boolean[] booleans = new boolean[] { true, true, true };
		Assert.assertEquals(0, ArraysUtil.indexOf(booleans, new boolean[] { true, true }));
		Assert.assertEquals(-1, ArraysUtil.indexOf(booleans, new boolean[] { true, true, true, false }));
		Assert.assertEquals(0, ArraysUtil.indexOf(booleans, new boolean[] {}, 0, 3));
		Assert.assertEquals(1, ArraysUtil.indexOf(booleans, new boolean[] { true, true }, 1));
		Assert.assertEquals(1, ArraysUtil.indexOf(booleans, new boolean[] { true }, 1, 3));
		Assert.assertEquals(-1, ArraysUtil.indexOf(booleans, new boolean[] { true, false }, 1, 3));
	}

	@Test
	public void testContains() {
		assertTrue(ArraysUtil.contains(x, 1));
		assertTrue(ArraysUtil.contains(x, 2));
		assertTrue(ArraysUtil.contains(x, 5));
		assertFalse(ArraysUtil.contains(x, 6));
		assertTrue(ArraysUtil.contains(xx, Long.valueOf(3)));
		assertFalse(ArraysUtil.contains(xx, Long.valueOf(13)));
		assertTrue(ArraysUtil.contains(yy, Long.valueOf(13)));
		assertFalse(ArraysUtil.contains(yy, Long.valueOf(13), 3));

		assertTrue(ArraysUtil.contains(new byte[] { 0, 1, 2 }, (byte) 1));
		assertFalse(ArraysUtil.contains(new byte[] { 0, 1, 2 }, (byte) 3));
		assertTrue(ArraysUtil.contains(new char[] { 'f', 'o', 'o' }, 'f'));
		assertFalse(ArraysUtil.contains(new char[] { 'f', 'o', 'o' }, 'a'));
		assertTrue(ArraysUtil.contains(new short[] { 0, 1, 2 }, (short) 1));
		assertFalse(ArraysUtil.contains(new short[] { 0, 1, 2 }, (short) 3));
		assertTrue(ArraysUtil.contains(new long[] { 0, 1, 2 }, 1));
		assertFalse(ArraysUtil.contains(new long[] { 0, 1, 2 }, 3));
		assertTrue(ArraysUtil.contains(new float[] { 0, 1, 2 }, 1));
		assertFalse(ArraysUtil.contains(new float[] { 0, 1, 2 }, 3));
		assertTrue(ArraysUtil.contains(new double[] { 0, 1, 2 }, 1));
		assertFalse(ArraysUtil.contains(new double[] { 0, 1, 2 }, 3));
		assertTrue(ArraysUtil.contains(new boolean[] {true, true }, true));
		assertFalse(ArraysUtil.contains(new boolean[] {true, true }, false));
	}

	@Test
	public void testContains2() {
		assertTrue(ArraysUtil.contains(x, new int[] {}));
		assertTrue(ArraysUtil.contains(x, new int[] { 1, 2, 3 }));
		assertFalse(ArraysUtil.contains(x, new int[] { 1, 2, 3, 7 }));
		assertTrue(ArraysUtil.contains(x, new int[] { 2, 3 }));
		assertTrue(ArraysUtil.contains(x, new int[] { 5 }));
		assertTrue(ArraysUtil.contains(new byte[] { 0, 1, 2 }, new byte[] { 0, 1, 2 }));
		assertFalse(ArraysUtil.contains(new byte[] { 0, 1, 2 }, new byte[] { 0, 1, 2, 7 }));
		assertTrue(ArraysUtil.contains(new char[] { 'f', 'o', 'o' }, new char[] { 'f', 'o' }));
		assertFalse(ArraysUtil.contains(new char[] { 'f', 'o', 'o' }, new char[] { 'f', 'o', 'o', 'r' }));
		assertTrue(ArraysUtil.contains(new short[] { 0, 1, 2 }, new short[] { 0, 1, 2 }));
		assertFalse(ArraysUtil.contains(new short[] { 0, 1, 2 }, new short[] { 0, 1, 2, 7 }));
		assertTrue(ArraysUtil.contains(new long[] { 0, 1, 2 }, new long[] { 0, 1, 2 }));
		assertFalse(ArraysUtil.contains(new long[] { 0, 1, 2 }, new long[] { 0, 1, 2, 7 }));
		assertTrue(ArraysUtil.contains(new float[] { 0, 1, 2 }, new float[] { 0, 1, 2 }));
		assertFalse(ArraysUtil.contains(new float[] { 0, 1, 2 }, new float[] { 0, 1, 2, 7 }));
		assertTrue(ArraysUtil.contains(new double[] { 0, 1, 2 }, new double[] { 0, 1, 2 }));
		assertFalse(ArraysUtil.contains(new double[] { 0, 1, 2 }, new double[] { 0, 1, 2, 7 }));
		assertTrue(ArraysUtil.contains(new boolean[] { true, true }, new boolean[] { true }));
		assertFalse(ArraysUtil.contains(new boolean[] { true, true }, new boolean[] { false }));
	}


	@Test
	public void testConvert() {
		Integer[] src = new Integer[]{Integer.valueOf(1), null, Integer.valueOf(3)};
		int[] dest = ArraysUtil.values(src);
		Assert.assertEquals(3, dest.length);
		Assert.assertEquals(1, dest[0]);
		Assert.assertEquals(0, dest[1]);
		Assert.assertEquals(3, dest[2]);

		src = ArraysUtil.valuesOf(dest);
		Assert.assertEquals(3, src.length);
		Assert.assertEquals(1, src[0].intValue());
		Assert.assertEquals(0, src[1].intValue());
		Assert.assertEquals(3, src[2].intValue());

	}

	@Test
	public void testToString() {
		Assert.assertEquals("null", ArraysUtil.toString((int[]) null));
		Assert.assertEquals("1,2,3", ArraysUtil.toString(new int[] { 1, 2, 3 }));

		Assert.assertEquals("null", ArraysUtil.toString((Object[]) null));
		Assert.assertEquals("1,null,3.1",
				ArraysUtil.toString(new Object[] { Integer.valueOf(1), null, Double.valueOf(3.1) }));

		Assert.assertEquals("null", ArraysUtil.toString((String[]) null));
		Assert.assertEquals("foo,bar", ArraysUtil.toString(new String[] { "foo", "bar" }));
		Assert.assertEquals("null", ArraysUtil.toString((byte[]) null));
		Assert.assertEquals("0,1,2", ArraysUtil.toString(new byte[] { 0, 1, 2 }));
		Assert.assertEquals("null", ArraysUtil.toString((char[]) null));
		Assert.assertEquals("f,o,o", ArraysUtil.toString(new char[] { 'f', 'o', 'o' }));
		Assert.assertEquals("null", ArraysUtil.toString((short[]) null));
		Assert.assertEquals("0,1,2", ArraysUtil.toString(new short[] { 0, 1, 2 }));
		Assert.assertEquals("null", ArraysUtil.toString((long[]) null));
		Assert.assertEquals("0,1,2", ArraysUtil.toString(new long[] { 0, 1, 2 }));
		Assert.assertEquals("null", ArraysUtil.toString((float[]) null));
		Assert.assertEquals("0.0,1.0,2.0", ArraysUtil.toString(new float[] { 0.0f, 1.0f, 2.0f }));
		Assert.assertEquals("null", ArraysUtil.toString((double[]) null));
		Assert.assertEquals("0.0,1.0,2.0", ArraysUtil.toString(new double[] { 0.0, 1.0, 2.0 }));
		Assert.assertEquals("null", ArraysUtil.toString((boolean[]) null));
		Assert.assertEquals("true,false", ArraysUtil.toString(new boolean[] { true, false }));

	}

	@Test
	public void testRemove() {
		assertArrayEquals(new int[]{1, 2, 5}, ArraysUtil.remove(x, 2, 2));
		assertArrayEquals(new int[]{1}, ArraysUtil.remove(x, 1, 4));
		assertArrayEquals(new long[]{1, 3, 4, 5}, ArraysUtil.values(ArraysUtil.remove(xx, 1, 1)));
		assertArrayEquals(new String[]{"f","o","o"}, ArraysUtil.remove(new String[]{"f","o","o","b","a","r"}, 3, 3));
		assertArrayEquals(new byte[]{1, 2}, ArraysUtil.remove(new byte[]{1, 2, 3, 4}, 2, 2));
		assertArrayEquals(new char[]{'f','o','o'}, ArraysUtil.remove(new char[]{'f','o','o', 'b','a','r'}, 3, 3));
		assertArrayEquals(new short[]{1, 2}, ArraysUtil.remove(new short[]{1, 2, 3, 4}, 2, 2));
		assertArrayEquals(new long[]{1l, 2l}, ArraysUtil.remove(new long[]{1l, 2l, 3l, 4l}, 2, 2));
		assertArrayEquals(new float[]{1.0f, 2.0f}, ArraysUtil.remove(new float[]{1.0f, 2.0f, 3.0f,4.0f}, 2, 2), 0);
		assertArrayEquals(new double[]{1.0, 2.0}, ArraysUtil.remove(new double[]{1.0, 2.0, 3.0, 4.0}, 2, 2), 0);
		assertBooleanArrayEquals(new boolean[]{true, true}, ArraysUtil.remove(new boolean[]{true, true, false, true}, 2, 2));
	}

	@Test
	public void testSuperType() {
		oo = new Object[] {Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(5)};

		oo = ArraysUtil.append(oo, Integer.valueOf(7));

		assertEquals(4, oo.length);

		oo = ArraysUtil.append(oo, "xxx");

		assertEquals(5, oo.length);
	}
	
	@Test
	public void testArray() {
		assertArrayEquals(new Integer[] {}, ArraysUtil.array());
		assertArrayEquals(new Integer[] { 1, 2, 5 }, ArraysUtil.array(1, 2, 5));

		assertArrayEquals(new byte[] {}, ArraysUtil.bytes());
		assertArrayEquals(new byte[] { 1, 0 }, ArraysUtil.bytes((byte) 1, (byte) 0));

		assertArrayEquals(new char[] {}, ArraysUtil.chars());
		assertArrayEquals(new char[] { 'f', 'o', 'o' }, ArraysUtil.chars('f', 'o', 'o'));

		assertArrayEquals(new short[] {}, ArraysUtil.shorts());
		assertArrayEquals(new short[] { 1, 2, 5 }, ArraysUtil.shorts((short) 1, (short) 2, (short) 5));

		assertArrayEquals(new int[] {}, ArraysUtil.ints());
		assertArrayEquals(new int[] { 1, 2, 5 }, ArraysUtil.ints(1, 2, 5));

		assertArrayEquals(new long[] {}, ArraysUtil.longs());
		assertArrayEquals(new long[] { 1, 2, 5 }, ArraysUtil.longs(1l, 2l, 5l));

		assertArrayEquals(new float[] {}, ArraysUtil.floats(), 0);
		assertArrayEquals(new float[] { 1.0f, 2.0f, 5.0f }, ArraysUtil.floats(1.0f, 2.0f, 5.0f), 0);

		assertArrayEquals(new double[] {}, ArraysUtil.doubles(), 0);
		assertArrayEquals(new double[] { 1.0, 2.0, 5.0 }, ArraysUtil.doubles(1.0, 2.0, 5.0), 0);

		assertBooleanArrayEquals(new boolean[] {}, ArraysUtil.booleans());
		assertBooleanArrayEquals(new boolean[] { true, false }, ArraysUtil.booleans(true, false));

	}

	@Test
	public void testValues() {
		assertArrayEquals(new byte[] { 0, 1 }, ArraysUtil.values(new Byte[] { 0, 1 }));
		assertArrayEquals(new Byte[] { 0, 1 }, ArraysUtil.valuesOf(new byte[] { 0, 1 }));
		assertArrayEquals(new char[] { 'f', 'o', 'o' }, ArraysUtil.values(new Character[] { 'f', 'o', 'o' }));
		assertArrayEquals(new Character[] { 'f', 'o', 'o' }, ArraysUtil.valuesOf(new char[] { 'f', 'o', 'o' }));
		assertArrayEquals(new short[] { 0, 1 }, ArraysUtil.values(new Short[] { 0, 1 }));
		assertArrayEquals(new Short[] { 0, 1 }, ArraysUtil.valuesOf(new short[] { 0, 1 }));
		assertArrayEquals(new int[] { 0, 1 }, ArraysUtil.values(new Integer[] { 0, 1 }));
		assertArrayEquals(new Integer[] { 0, 1 }, ArraysUtil.valuesOf(new int[] { 0, 1 }));
		assertArrayEquals(new long[] { 0, 1 }, ArraysUtil.values(new Long[] { 0l, 1l }));
		assertArrayEquals(new Long[] { 0l, 1l }, ArraysUtil.valuesOf(new long[] { 0, 1 }));
		assertArrayEquals(new float[] { 0.0f, 1.0f }, ArraysUtil.values(new Float[] { 0.0f, 1.0f }), 0);
		assertArrayEquals(new Float[] { 0.0f, 1.0f }, ArraysUtil.valuesOf(new float[] { 0.0f, 1.0f }));
		assertArrayEquals(new double[] { 0.0, 1.0 }, ArraysUtil.values(new Double[] { 0.0, 1.0 }), 0);
		assertArrayEquals(new Double[] { 0.0, 1.0 }, ArraysUtil.valuesOf(new double[] { 0.0, 1.0 }));
		assertBooleanArrayEquals(new boolean[] { true, false }, ArraysUtil.values(new Boolean[] { true, false }));
		assertArrayEquals(new Boolean[] { true, false }, ArraysUtil.valuesOf(new boolean[] { true, false }));
	}
	
	private void assertBooleanArrayEquals(boolean[] arr1, boolean[] arr2){
		assertEquals(arr1.length, arr2.length);
		for (int i = 0; i < arr1.length; i++) {
			assertEquals(arr1[i], arr2[i]);
		}
	}
}

