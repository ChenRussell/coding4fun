package com.nowcoder.zhenti;

public class MaxMin {
	public static void main(String[] args) {
		byte bmax, bmin;
		short shmax, shmin;
		char cmax, cmin;
		int imax, imin;
		long lmax,lmin;
		float fmax,fmin;
		double dmax,dmin;
		fmax = Float.MAX_VALUE;
		fmin = Float.MIN_VALUE;
		dmax = Double.MAX_VALUE;
		dmin = Double.MIN_VALUE;
		bmax = Byte.MAX_VALUE;
		bmin = Byte.MIN_VALUE;
		cmax = Character.MAX_VALUE;
		cmin = Character.MIN_VALUE;
		shmax = Short.MAX_VALUE;
		shmin = Short.MIN_VALUE;
		imax = Integer.MAX_VALUE;
		imin = Integer.MIN_VALUE;
		lmax = Long.MAX_VALUE;
		lmin = Long.MIN_VALUE;
		System.out.println("float max="+fmax);
		System.out.println("float min="+fmin);
		System.out.println("double max="+String.valueOf(dmax));
		System.out.println("double min="+dmin);
		System.out.println("byte max="+bmax);
		System.out.println("byte min="+bmin);
		System.out.println("char max="+cmax);
		System.out.println("char min="+cmin);
		System.out.println("short max="+shmax);
		System.out.println("short min="+shmin);
		System.out.println("int max="+imax);
		System.out.println("int min="+imin);
		System.out.println("long max="+lmax);
		System.out.println("long min="+lmin);
	}
}
